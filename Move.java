package com.github.obeseclown.tictactoe.core;

public class Move {
	
	private int x = -1, y = -1; 
	
	public Move() {}
	
	public Move(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	@Override
	public String toString()
	{
		return "Move {X: " + this.x + " Y: " + this.y + "}";
	}
}