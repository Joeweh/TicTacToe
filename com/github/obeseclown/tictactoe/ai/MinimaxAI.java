package com.github.obeseclown.tictactoe.ai;

import com.github.obeseclown.tictactoe.core.Board;
import com.github.obeseclown.tictactoe.core.Move;
import com.github.obeseclown.tictactoe.core.Player;
import com.github.obeseclown.tictactoe.core.Tile;

public class MinimaxAI {
	
    private static int minimax(Board board, int depth, boolean isMaximizing, Player AIPlayer, int alpha, int beta) 
    {
        Tile.TileState opponent;
        int score = board.evaluate(AIPlayer);

        if (AIPlayer.getMarker() == Tile.TileState.X) opponent = Tile.TileState.O;
        
        else opponent = Tile.TileState.X;
        
        if (score == 1) return score;

        if (score == -1) return score;

        if (board.getAvailablePositions().isEmpty()) return 0;

        if (isMaximizing) 
        {
            int best = Integer.MIN_VALUE;

            for (int i = 0; i < board.getTiles().length; i++) 
            {
                for (int j = 0; j < board.getTiles()[i].length; j++) 
                {
                    if (board.getTiles()[i][j].getState() == Tile.TileState.BLANK) 
                    {
                        board.getTiles()[i][j].setState(AIPlayer.getMarker());

                        best = Math.max(best, minimax(board, depth + 1, !isMaximizing, AIPlayer, alpha, beta));

                        board.getTiles()[i][j].setState(Tile.TileState.BLANK);
                        
                        alpha = Math.max(alpha, best);
                        
                        if (beta <= alpha)
                        {
                        	break;
                        }
                    }
                }
            }
            
            return best;
        }

        else 
        {
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < board.getTiles().length; i++) 
            {
                for (int j = 0; j < board.getTiles()[i].length; j++) 
                {
                    if (board.getTiles()[i][j].getState() == Tile.TileState.BLANK) 
                    {
                        board.getTiles()[i][j].setState(opponent);

                        best = Math.min(best, minimax(board, depth + 1, !isMaximizing, AIPlayer, alpha, beta));

                        board.getTiles()[i][j].setState(Tile.TileState.BLANK);
                        
                        beta = Math.min(beta, best);
                        
                        if (beta <= alpha)
                        {
                        	break;
                        }
                    }
                }
            }
            return best;
        }
    }

    public static Move getBestMove(Board board, Player player) 
    {
        int bestValue = Integer.MIN_VALUE;
        Move bestMove = new Move(-1, -1);

        for (int i = 0; i < board.getTiles().length; i++) 
        {
            for (int j = 0; j < board.getTiles()[i].length; j++) 
            {
                if (board.getTiles()[i][j].getState() == Tile.TileState.BLANK) 
                {
                    board.getTiles()[i][j].setState(player.getMarker());

                    int moveValue = minimax(board, 0, false, player, Integer.MIN_VALUE, Integer.MAX_VALUE);

                    board.getTiles()[i][j].setState(Tile.TileState.BLANK);

                    if (moveValue > bestValue) 
                    {
                    	bestMove.setX(i);
                        bestMove.setY(j);
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }
}
