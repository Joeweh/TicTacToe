package com.github.obeseclown.tictactoe.ai;

import java.util.Random;

import com.github.obeseclown.tictactoe.core.Board;
import com.github.obeseclown.tictactoe.core.Move;

public class RandomAI {
	
	public Move getBestMove(Board board)
	{
		Random rng = new Random();
		
		int size = board.getAvailablePositions().size();
		
		return board.getAvailablePositions().get(rng.nextInt(size) + 1);
	}
}
