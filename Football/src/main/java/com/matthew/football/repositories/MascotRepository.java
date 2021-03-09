package com.matthew.football.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.football.models.Mascot;

@Repository
public interface MascotRepository extends CrudRepository<Mascot, Long>{

}
