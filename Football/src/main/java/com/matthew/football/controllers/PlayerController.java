package com.matthew.football.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.football.models.Player;
import com.matthew.football.services.PlayerService;
import com.matthew.football.services.TeamService;

@Controller
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private TeamService tService;
	@Autowired
	private PlayerService pService;
	
	@GetMapping("/new")
	public String create(Model viewModel, @ModelAttribute("player") Player player) {
		viewModel.addAttribute("teams", this.tService.getAllTeams());
		return "player/new.jsp";
	}
	
	@PostMapping("/new")
	public String createPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("teams", this.tService.getAllTeams());
			return "player/new.jsp";
		}
		this.pService.create(player);
		return "redirect:/";
	}
	
}
