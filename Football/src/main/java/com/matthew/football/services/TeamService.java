package com.matthew.football.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.football.models.Team;
import com.matthew.football.models.User;
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
	
	// Create Team
	public Team updateTeam(Team updatedTeam) {
		return this.tRepo.save(updatedTeam);
	}
	
	// Create Team with Request Param (Normal HTML Forms)
	public Team createTeamHTML(String name, String city, int players) {
		Team newTeam = new Team(name, city, players);
		return this.tRepo.save(newTeam);
	}
	
	// Delete
	public void deleteTeam(Long id) {
		this.tRepo.deleteById(id);
	}
	
	//Add Liker To Football Team
	public void addLiker(Team team, User user) {
		// Fetch the list of likers currently from the database
		List<User> currentLikers = team.getLikers();
		// Add that user to the arraylist of likers
		currentLikers.add(user);
		// Update the database
		this.tRepo.save(team);
	}
	
	//Remove Liker From Football Team
	public void removeLiker(Team team, User user) {
		// Fetch the list of likers currently from the database
		List<User> currentLikers = team.getLikers();
		// Add that user to the arraylist of likers
		currentLikers.remove(user);
		// Update the database
		this.tRepo.save(team);
	}
	
}
