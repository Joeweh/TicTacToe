package com.github.obeseclown.tictactoe.core;

import java.util.Scanner;

public abstract class GameParent {
	
	private Board board = new Board();
	public static Player PLAYER1, PLAYER2, currentPlayer;
	public static final Scanner scanner = new Scanner(System.in);
	
	public abstract void start();
	
	public Board getBoard()
	{
		return this.board;
	}
}
