package com.matthew.football.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.football.models.Player;
import com.matthew.football.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository pRepo;
	
	// Create
	public Player create(Player player) {
		return this.pRepo.save(player);
	}
}
