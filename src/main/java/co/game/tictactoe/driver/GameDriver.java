package co.game.tictactoe.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import co.game.tictactoe.game.Game;
import co.game.tictactoe.game.Player;

public class GameDriver {
	Game game;
	
	public GameDriver() {
		game = new Game();
	}
	
	public void start() throws IOException {
		Player currentPlayer = game.getPlayers().poll();
		while(!game.isOver()) {
			System.out.println(currentPlayer.getName()+"'s Move:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String input = reader.readLine();
			if(input.equals("exit")) {
				System.out.println("Quitting game");
				break;
			}
			String [] cell = input.split(" ");
			if(!game.validMove(Integer.valueOf(cell[0]), Integer.valueOf(cell[1]))) {
				System.out.println("Invalid Move");
				game.getPlayers().offer(currentPlayer);
				game.getPlayers().offer(game.getPlayers().poll());
			}
			game.getBoard()[Integer.valueOf(cell[0])][Integer.valueOf(cell[1])] = currentPlayer.getSymbol();
			game.getPlayers().offer(currentPlayer);
			game.print();
			if(game.winner(currentPlayer))
				break;
			currentPlayer = game.getPlayers().poll();
			
		}
	}
}
