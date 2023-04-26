package co.game.tictactoe.game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
	char [][] board;
	Queue<Player> players;
	
	public Game (){
		board = new char[4][4];
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				board[i][j] = '-';
			}
		}
		players = new LinkedList<Player>();
		System.out.println("Who's Playing");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first player name :");
		String symbolname[] = scanner.nextLine().split(" ");
		players.offer(new Player(symbolname[1], symbolname[0].charAt(0)));
		System.out.print("Enter Second player name :");
		symbolname = scanner.nextLine().split(" ");
		players.offer(new Player(symbolname[1], symbolname[0].charAt(0)));
		
	}
	public void print() {
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public boolean isOver() {
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				if(board[i][j] == '-')
					return false;
			}
		}
		System.out.println("Game Over!");
		return true;
	}
	public boolean winner(Player currentPlayer) {
		int d1Count = 0;
		int d2Count = 0;
		boolean won = false;
		for(int i=1;i<=3;i++) {
			int rowCount =0;
			int colCount =0;
			if(board[i][i] == currentPlayer.getSymbol())
				d1Count++;
			if(board[i][4-i] == currentPlayer.getSymbol())
				d2Count++;
			for(int j=1;j<=3;j++) {
				if(board[i][j] == currentPlayer.getSymbol())
					rowCount++;
				if(board[j][i] == currentPlayer.getSymbol())
					colCount++;
			}
			if(rowCount==3 || colCount ==3) {
				won = true;
			}
		}
		if(won || d1Count == 3 || d2Count == 3) {
			System.out.println(currentPlayer.getName()+" won the game");
			return true;
		}
			
		return false;
	}
	public boolean validMove(Integer r, Integer c) {
		if(board[r][c] == '-')
			return true;
		return false;
	}
}
