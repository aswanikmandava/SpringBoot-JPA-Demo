package com.mandava.springboot.springbootjpa.demo;

import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PlayerRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// insert
		logger.info("Inserting player ...",
				repo.insertPlayer(new Player("Sampras", "USA", Date.valueOf("1978-05-18"), 100)));
		logger.info("Inserting player ...",
				repo.insertPlayer(new Player("Djokovic", "Serbia", Date.valueOf("1986-03-05"), 110)));
		logger.info("Inserting player ...", 
				repo.insertPlayer(new Player("Federer", "Switzerland", Date.valueOf("1985-02-03"), 90)));
		
		// update
		logger.info("Updating player with id(1) ...",
				repo.updatePlayer(new Player(1, "Pete Sampras", "America", Date.valueOf("1979-05-17"), 105)));
		
		// get
		logger.info("Getting player with id(2) ...",
				repo.getPlayerById(2));
		
		// delete
		logger.info("Deleting player by id(1) ...", repo.getPlayerById(1));
		repo.deletePlayerById(1);
	}

}
