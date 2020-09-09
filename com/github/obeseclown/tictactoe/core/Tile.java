package com.github.obeseclown.tictactoe.core;

public class Tile {
	
	private TileState state = TileState.BLANK;
	
	public Tile() {}
	
	public Tile(TileState initialState) 
	{ 
		this.state = initialState;
	}
	
	public TileState getState()
	{
		return this.state;
	}
	
	public void setState(TileState newState)
	{
		this.state = newState;
	}
	
	public enum TileState 
	{
		X, O, BLANK
	}
	
	@Override
	public String toString()
	{
		return "Tile {State: " + this.state + "}";
	}
}
