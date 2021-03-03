package com.matthew.football.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.football.models.Team;
import com.matthew.football.repositories.TeamRepository;

@Service
public class TeamService {
	private TeamRepository tRepo;
	
	public TeamService(TeamRepository repo) {
		this.tRepo = repo;
	}
	
	// Get All
	public List<Team> getAllTeams(){
		return this.tRepo.findAll();
	}
	
	// Get One
	public Team getOneTeam(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	// Create Team
	public Team createTeam(Team newTeam) {
		return this.tRepo.save(newTeam);
	}
	
	// Delete
	public void deleteTeam(Long id) {
		this.tRepo.deleteById(id);
	}
	
}
