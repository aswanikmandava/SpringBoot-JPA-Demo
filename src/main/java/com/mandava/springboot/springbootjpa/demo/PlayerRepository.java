package com.mandava.springboot.springbootjpa.demo;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PlayerRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	public Player insertPlayer(Player p) {
		return entityManager.merge(p);
	}

	public Player updatePlayer(Player p) {
		return entityManager.merge(p);
	}
	
	public Player getPlayerById(int id) {
		return entityManager.find(Player.class, id);
	}
	
	public void deletePlayerById(int id) {
		Player p = entityManager.find(Player.class, id);
		entityManager.remove(p);
	}

}
