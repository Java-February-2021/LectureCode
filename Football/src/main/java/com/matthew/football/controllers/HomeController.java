package com.matthew.football.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.football.models.Team;
import com.matthew.football.services.TeamService;

@Controller
public class HomeController {
	@Autowired
	private TeamService tService;
	// @RequestMapping(value="/" method=RequestMethod.GET)
	// @RequestMapping(value="/" method=RequestMethod.POST)
	// @RequestMapping("/")
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Team> allTeams = this.tService.getAllTeams();
		viewModel.addAttribute("allTeams", allTeams);
		return "index.jsp";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute("team") Team team) {
		return "add.jsp";
	}
	
	@PostMapping("/add")
	public String addTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		 } else {
			 this.tService.createTeam(team);
			 return "redirect:/";
		 }
	}
	
	@PostMapping("/addHtmlWay")
	public String addTeamTwo(@RequestParam("name") String name, @RequestParam("city") String city, @RequestParam("players") int players, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Hey There you forgot to add a name");
		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/add";
		}
		
		this.tService.createTeamHTML(name, city, players);
		return "redirect:/";
	}
}
