package com.github.obeseclown.tictactoe.examples;

import java.util.Random;
import java.util.Scanner;

import com.github.obeseclown.tictactoe.core.Move;
import com.github.obeseclown.tictactoe.core.Player;
import com.github.obeseclown.tictactoe.core.Tile;
import com.github.obeseclown.tictactoe.utils.GameParent;

public class PlayerGame extends GameParent {
	
	private static Random rng = new Random();
	private static Scanner input = new Scanner(System.in);
	private static Player PLAYER1 = new Player("Player 1", Tile.TileState.O), PLAYER2 = new Player("Player 2", Tile.TileState.X), currentPlayer;
	
	public static void main(String[] args)
	{
		new PlayerGame().start();
	}
	
	public void playerTurn(Player player)
	{
		boolean inputValid = false;
		
		while (!inputValid)
		{
			System.out.println("\n=== " + currentPlayer.getName() +"'s Turn ===");
			System.out.println(getBoard());
			System.out.print("\nEnter Corresponding Number: ");
			
			int space = input.nextInt();

			switch (space)
			{
			
			case 1:
				if (getBoard().getTiles()[0][0].getState() == Tile.TileState.BLANK)
				{
					getBoard().place(new Move(0, 0), player.getMarker());
					inputValid = true;
				}
				
				else
				{
					System.out.println("Space Is Taken");
				}
				break;
			case 2:
				if (getBoard().getTiles()[0][1].getState() == Tile.TileState.BLANK)
				{
					getBoard().place(new Move(0, 1), player.getMarker());
					inputValid = true;
				}
				
				else
				{
					System.out.println("Space Is Taken");
				}
				break;
				
			case 3:
				if (getBoard().getTiles()[0][2].getState() == Tile.TileState.BLANK)
				{
					getBoard().place(new Move(0, 2), player.getMarker());
					inputValid = true;
				}
				
				else
				{
					System.out.println("Space Is Taken");
				}
				break;
				
			case 4:
				if (getBoard().getTiles()[1][0].getState() == Tile.TileState.BLANK)
				{
					getBoard().place(new Move(1, 0), player.getMarker());
					inputValid = true;
				}
				
				else
				{
					System.out.println("Space Is Taken");
				}
				break;
				
			case 5:
				if (getBoard().getTiles()[1][1].getState() == Tile.TileState.BLANK)
				{
					getBoard().place(new Move(1, 1), player.getMarker());
					inputValid = true;
				}
				
				else
				{
					System.out.println("Space Is Taken");
				}
				break;
				
			case 6:
				if (getBoard().getTiles()[1][2].getState() == Tile.TileState.BLANK)
				{
					getBoard().place(new Move(1, 2), player.getMarker());
					inputValid = true;
				}
				
				else
				{
					System.out.println("Space Is Taken");
				}
				break;
				
			case 7:
				if (getBoard().getTiles()[2][0].getState() == Tile.TileState.BLANK)
				{
					getBoard().place(new Move(2, 0), player.getMarker());	
					inputValid = true;
				}
				
				else
				{
					System.out.println("Space Is Taken");
				}
				break;
				
			case 8:
				if (getBoard().getTiles()[2][1].getState() == Tile.TileState.BLANK)
				{
					getBoard().place(new Move(2, 1), player.getMarker());	
					inputValid = true;
				}
				
				else
				{
					System.out.println("Space Is Taken");
				}
				break;
				
			case 9:
				if (getBoard().getTiles()[2][2].getState() == Tile.TileState.BLANK)
				{
					getBoard().place(new Move(2, 2), player.getMarker());	
					inputValid = true;
				}
				
				else
				{
					System.out.println("Space Is Taken");
				}
				break;
				
			default: 
				System.out.println("\nInvalid Input\n");
			}
		}
	}
	
	public void start() 
	{
		decideTurnOrder();
		
		boolean continueGame = true;
		
		while (continueGame)
		{	
			if (currentPlayer == PLAYER1)
			{	
				playerTurn(PLAYER1);
				if (getBoard().evaluate(currentPlayer) == 1 || getBoard().getAvailablePositions().isEmpty())
				{
					continueGame = false;
				}
				currentPlayer = PLAYER2;
			}
			
			else
			{	
				playerTurn(PLAYER2);
				if (getBoard().evaluate(currentPlayer) == 1 || getBoard().getAvailablePositions().isEmpty())
				{
					continueGame = false;
				}
				currentPlayer = PLAYER1;
			}
		}
		
		System.out.println("\n==== Game Finished! ====");
		System.out.println(getBoard());
		
		if (getBoard().evaluate(PLAYER1) == 1) 
		{
			System.out.println("\nPlayer 1 Wins!");
		} 
		
		else if (getBoard().evaluate(PLAYER2) == 1) 
		{
			System.out.println("\nPlayer 2 Wins!");
		} 
		
		else 
		{
			System.out.println("Tie");
		}	
	}
	
	public void decideTurnOrder()
	{	
		System.out.println("=======================");
		System.out.println("== Decide Turn Order ==");
		System.out.println("=======================\n");
		
		while (true)
		{	
			int randomNum = rng.nextInt(10) + 1;
			
			System.out.println("=== Player 1 ===");
			System.out.print("Guess Number 1-10: ");
			int player1Guess = input.nextInt();
			
			System.out.println("\n=== Player 2 ===");
			System.out.print("Guess Number 1-10: ");
			int player2Guess = input.nextInt();
			
			System.out.println("\nNumber Was " + randomNum + "\n");
			
			if (Math.max(randomNum, player1Guess) - Math.min(randomNum, player1Guess) > Math.max(randomNum, player2Guess) - Math.min(randomNum, player2Guess))
			{	
				currentPlayer = PLAYER2;
				System.out.println(currentPlayer.getName() + " Goes First");
				return;
			}
			
			else if (Math.max(randomNum, player1Guess) - Math.min(randomNum, player1Guess) < Math.max(randomNum, player2Guess) - Math.min(randomNum, player2Guess))
			{
				currentPlayer = PLAYER1;
				System.out.println(currentPlayer.getName() + " Goes First");
				return;
			}
			
			else
			{
				System.out.println("Tie\n");
			}
		} 
	}
}
