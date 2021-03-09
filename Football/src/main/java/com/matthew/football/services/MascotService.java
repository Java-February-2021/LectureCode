package com.matthew.football.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.football.models.Mascot;
import com.matthew.football.repositories.MascotRepository;

@Service
public class MascotService {
	@Autowired
	private MascotRepository mRepo;
	
	// Create
	public Mascot create(Mascot mascot) {
		return this.mRepo.save(mascot);
	}
}
