package com.github.obeseclown.tictactoe.examples;

import java.util.Random;

import com.github.obeseclown.tictactoe.ai.MinimaxAI;
import com.github.obeseclown.tictactoe.core.GameParent;
import com.github.obeseclown.tictactoe.core.Move;
import com.github.obeseclown.tictactoe.core.Player;
import com.github.obeseclown.tictactoe.core.Tile;

public class AIGame extends GameParent {
	
	private static Random rng = new Random();
	
	public static void main(String[] args)
	{
		new AIGame().start();
	}
	
	public AIGame()
	{
		PLAYER1 = new Player("Human", Tile.TileState.O);
		PLAYER2 = new Player("AI", Tile.TileState.X);
	}
	
	@Override
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
				AITurn();
				
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
			System.out.println("\n" + PLAYER1.getName() + " Wins!");
		} 
		
		else if (getBoard().evaluate(PLAYER2) == 1) 
		{
			System.out.println("\n" + PLAYER2.getName() + " Wins!");
		} 
		
		else 
		{
			System.out.println("\nTie");
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
			
			System.out.print("Guess Number 1-10: ");
			int human = scanner.nextInt();
			
			int ai = rng.nextInt(10) + 1;
			
			System.out.println("\nAI's Number: " + ai + "\n");
			System.out.println("Number Was " + randomNum + "\n");
			
			if (Math.max(randomNum, human) - Math.min(randomNum, human) > Math.max(randomNum, ai) - Math.min(randomNum, ai))
			{	
				currentPlayer = PLAYER2;
				System.out.println("AI Goes First");
				return;
			}
			
			else if (Math.max(randomNum, human) - Math.min(randomNum, human) < Math.max(randomNum, ai) - Math.min(randomNum, ai))
			{
				currentPlayer = PLAYER1;
				System.out.println("You Go First");
				return;
			}
			
			else
			{
				System.out.println("Tie\n");
			}
		} 
	}
	
	public void playerTurn(Player player)
	{
		boolean inputValid = false;
		
		while (!inputValid)
		{
			System.out.println("\n=== " + currentPlayer.getName() +"'s Turn ===");
			System.out.println(getBoard());
			System.out.print("\nEnter Corresponding Number: ");
			
			int space = scanner.nextInt();

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
	
	public void AITurn()
	{
		System.out.println("\n=== " + currentPlayer.getName() + "'s Turn ===");
		
		getBoard().place(MinimaxAI.getBestMove(getBoard(), currentPlayer), Tile.TileState.X);
		System.out.println(getBoard() + "\n");
	}
}
