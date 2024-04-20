package com.mandava.springboot.springbootjpa.demo;

import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TennisPlayerSpringDataApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PlayerSpringDataRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// insert
		logger.info("Inserting player ...",
				repo.save(new Player("Sampras", "USA", Date.valueOf("1978-05-18"), 100)));
		logger.info("Inserting player ...",
				repo.save(new Player("Djokovic", "Serbia", Date.valueOf("1986-03-05"), 110)));
		logger.info("Inserting player ...", 
				repo.save(new Player("Federer", "Switzerland", Date.valueOf("1985-02-03"), 90)));
		logger.info("Inserting player ...", 
				repo.save(new Player("Agassy", "USA", Date.valueOf("1979-01-09"), 90)));
		
		// update
		logger.info("Updating player with id(1) ...",
				repo.save(new Player(1, "Pete Sampras", "America", Date.valueOf("1979-05-17"), 105)));
		
		// get
		logger.info("Getting player with id(2) ...", repo.findById(2));
		
		// get all players
		logger.info("Getting all players ...", repo.findAll());
		
		// get all players by nationality
		logger.info("Getting all USA players ...", repo.getPlayersByNationality("USA"));
		// delete
		logger.info("Deleting player by id(1) ...", repo.findById(1));
		repo.deleteById(1);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerSpringDataApplication.class, args);

	}

};
