package com.matthew.football.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.football.models.Mascot;
import com.matthew.football.models.Team;
import com.matthew.football.models.User;
import com.matthew.football.services.MascotService;
import com.matthew.football.services.TeamService;
import com.matthew.football.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private TeamService tService;
	@Autowired
	private MascotService mService;
	@Autowired
	private UserService uService;
	
	// @RequestMapping(value="/" method=RequestMethod.GET)
	// @RequestMapping(value="/" method=RequestMethod.POST)
	// @RequestMapping("/")
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<User> user = this.uService.allUsers();
		viewModel.addAttribute("users", user);
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("user")Long id) {
		if(session.getAttribute("user__id") == null) {
			session.setAttribute("user__id", id);
		}
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		System.out.println(userId);
		User user = this.uService.find(userId);
		List<Team> allTeams = this.tService.getAllTeams();
		viewModel.addAttribute("allTeams", allTeams);
		viewModel.addAttribute("loggedInUser", user);
		return "index.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
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
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("mascot") Mascot mascot, @ModelAttribute("team") Team team) {
		viewModel.addAttribute("team", this.tService.getOneTeam(id));
		return "show.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String editTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("team", this.tService.getOneTeam(id));
			return "show.jsp";
		}
		this.tService.updateTeam(team);
		return "redirect:/" + id;
	}
	
	@PostMapping("/mascot/{id}")
	public String addMascot(@Valid @ModelAttribute("Mascot") Mascot newMascot, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("team", this.tService.getOneTeam(id));
			return "show.jsp";
		}
		Team teamForMascot = this.tService.getOneTeam(id);
		newMascot.setTeam(teamForMascot);
		this.mService.create(newMascot);
		return "redirect:/" + id;
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTeam(@PathVariable("id") Long id) {
		this.tService.deleteTeam(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/like/{teamId}")
	public String like(@PathVariable("teamId") Long teamId, HttpSession session) {
		// Items from session retrieved all are Objects (from object superclass);
		Long userId = (Long)session.getAttribute("user__id");
		Team teamToLike = this.tService.getOneTeam(teamId);
		User userWhoLikedTeam = this.uService.find(userId);
		this.tService.addLiker(teamToLike, userWhoLikedTeam);
		return "redirect:/home"; 		
	}
	
	@GetMapping("/unlike/{teamId}")
	public String unlike(@PathVariable("teamId") Long teamId, HttpSession session) {
		// Items from session retrieved all are Objects (from object superclass);
		Long userId = (Long)session.getAttribute("user__id");
		Team teamToUnLike = this.tService.getOneTeam(teamId);
		User userWhoUnLikedTeam = this.uService.find(userId);
		this.tService.removeLiker(teamToUnLike, userWhoUnLikedTeam);
		return "redirect:/home"; 
		
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
