package com.github.obeseclown.tictactoe.core;

import java.util.ArrayList;

public class Board {
	private Tile[][] board = new Tile[][] {
		{new Tile(), new Tile(), new Tile()},
		{new Tile(), new Tile(), new Tile()},
		{new Tile(), new Tile(), new Tile()}
	};
	
	public Board() {}

	public Tile[][] getTiles() 
	{
		return this.board;
	}

	public void place(Move location, Tile.TileState state) 
	{
		this.board[location.getX()][location.getY()].setState(state);
	}
	
	@Override
	public String toString()
	{
		int counter = 1;
		StringBuilder builder = new StringBuilder();

		System.out.println();

		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{	
				switch (board[i][j].getState())
				{
				case BLANK:
					builder.append(j != board[i].length - 1 ? counter + " | " : counter + " ");
					counter++;
					break;
				case O:
					builder.append(j != board[i].length - 1 ? "O | " : "O");
					counter++;
					break;

				case X:
					builder.append(j != board[i].length - 1 ? "X | " : "X");
					counter++;
					break;
					
					
				}
			}
			builder.append(i != board.length - 1 ? "\n---------\n" : "");
		}
		return builder.toString();
	}
	
	public ArrayList<Move> getAvailablePositions() 
	{
		ArrayList<Move> availablePositions = new ArrayList<Move>();
		for (int i = 0; i < board.length; i++) 
		{
			for (int j = 0; j < board[i].length; j++) 
			{
				if (board[i][j].getState() == Tile.TileState.BLANK) 
				{
					availablePositions.add(new Move(i, j));
				}
			}
		}
		return availablePositions;
	}
	
	public int evaluate(Player player) 
	{
        for (int rows = 0; rows < board.length; rows++) 
        {
            if (board[rows][0].getState() != Tile.TileState.BLANK && board[rows][0].getState() == board[rows][1].getState() && board[rows][1].getState() == board[rows][2].getState()) 
            {
                if (board[rows][0].getState() == player.getMarker()) 
                {
                    return 1;
                } 
                
                else 
                {
                    return -1;
                }
            }
        }

        for (int columns = 0; columns < board[0].length; columns++) 
        {
            if (board[0][columns].getState() != Tile.TileState.BLANK && board[0][columns].getState() == board[1][columns].getState() && board[1][columns].getState() == board[2][columns].getState()) 
            {
                if (board[0][columns].getState() == player.getMarker()) 
                {
                    return 1;
                }
                
                else 
                {
                    return -1;
                }
            }
        }

        if (board[1][1].getState() != Tile.TileState.BLANK && board[0][0].getState() == board[1][1].getState() && board[1][1].getState() == board[2][2].getState()) 
        {
            if (board[1][1].getState() == player.getMarker()) 
            {
                return 1;
            } 
            
            else 
            {
                return -1;
            }
        }
        
        if (board[1][1].getState() != Tile.TileState.BLANK && board[0][2].getState() == board[1][1].getState() && board[1][1].getState() == board[2][0].getState()) 
        {
            if (board[1][1].getState() == player.getMarker()) 
            {
                return 1;
            } 
            
            else 
            {
                return -1;
            }
        }
        return 0;
    }
}
