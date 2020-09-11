package com.github.obeseclown.tictactoe.utils;

import java.util.Scanner;

import com.github.obeseclown.tictactoe.core.Board;
import com.github.obeseclown.tictactoe.core.Player;

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
