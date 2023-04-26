package co.game.tictactoe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.game.tictactoe.driver.GameDriver;

@SpringBootApplication
public class TicTacToeApplication implements CommandLineRunner{
	GameDriver gameDriver;
	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		gameDriver = new GameDriver();
		gameDriver.start();
				
		
	}

}
