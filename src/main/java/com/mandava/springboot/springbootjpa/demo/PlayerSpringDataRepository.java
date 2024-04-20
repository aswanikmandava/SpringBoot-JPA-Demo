package com.mandava.springboot.springbootjpa.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {
	// no CRUD method implementations required for Players
	
	public List<Player> getPlayersByNationality(String country);
}
