package com.github.obeseclown.tictactoe.core;

public class Player {
	
	private String name;
	private Tile.TileState marker;
	
	public Player(String name, Tile.TileState marker)
	{
		this.name = name;
		this.marker = marker;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Tile.TileState getMarker()
	{
		return this.marker;
	}
	
	@Override
	public String toString()
	{
		return "Player {Marker: " + this.marker + "}";
	}
}