package com.matthew.football.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthew.football.models.Team;
import com.matthew.football.services.TeamService;

@RestController
public class MainController {
	@Autowired
	private TeamService tService;
	
	
	@GetMapping("/")
	public List<Team> index() {
		return this.tService.getAllTeams();
	}
	
	// Get One Team
	@GetMapping("/{id}")
	public Team getTeam(@PathVariable("id") Long id) {
		return this.tService.getOneTeam(id);
	}
	
	// Create A Team
	@PostMapping("/add")
	public Team create(Team newTeam) {
		return this.tService.createTeam(newTeam);
		
	}
	
	@DeleteMapping("/team/{id}")
	public String removeTeam(@PathVariable("id") Long id) {
		this.tService.deleteTeam(id);
		return id + " has been removed from the database";
	}
}
