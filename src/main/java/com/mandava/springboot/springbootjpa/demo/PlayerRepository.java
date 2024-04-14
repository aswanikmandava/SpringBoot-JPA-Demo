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

}
