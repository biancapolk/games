package tictactoe;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class TicTacToeBoardImpl_Polk implements TicTacToeBoard{

	//Symbolics 
	protected static final int NO_MOVE = -1;
	protected static final int NO_MATCH = -1;

	protected int[] movesArray;

	public TicTacToeBoardImpl_Polk()
	{
		final int CELL_COUNT = ROW_COUNT * COLUMN_COUNT;

		//movesArray is set to size 9
		movesArray = new int[CELL_COUNT];
		//LinkedList<Mark> players = new LinkedList<Mark>();

		//each value of the array is set to NO_MOVE
		for(int i = 0; i < CELL_COUNT; i++)
		{
			movesArray[i] = NO_MOVE;
		}
	
	}

	public String toString()
	{
		String toString = ""; 

		for(int row = 0; row < movesArray.length; row ++) 
		{
			
			for(int column = 0; column < movesArray.length; column ++) 
			{
				String temp = " " + getMark(1, 1) + "|" + getMark(0, 1) + "|" + getMark(0, 2) + "\n" 
						+ "-----\n" + " " + getMark(1, 0) + "|" + getMark(1, 1) + "|" + getMark(1, 2) + "\n"
						+ "-----\n" + " " + getMark(2, 0) + "|" + getMark(2, 1) + "|" + getMark(2, 2) + "\n";
				return temp;
			}

		}
		return toString;	
	}

	//(row,column) -> gridSpot on board
	public static int getGridSpot(int row, int column) 
	{
		assert isValidRange(row, column) == true;

		int gridSpot = row * ROW_COUNT + column;

		return gridSpot;
	}


	public static boolean isValidRange(int row, int column)
	{
		if ( 0 <= row && row < ROW_COUNT && 0 <= column && column < COLUMN_COUNT )
		{
			return true;
		}
		return false;

	}


	//part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
	//part of post: rv == null <==> the (row, column) spot on the board is empty
	public Mark getMark(int row, int column) 
	{
		assert isValidRange(row, column) == true : "Out of range!";
		
		int r = row;
		int c = row;

		getGridSpot(row, column);

		Mark X = Mark.X;
		Mark O = Mark.O;
		Mark Empty = null;

		//(row, col) then return gridSpot
		// loop through movesArrayIndex[] and check for the value of the gridSpot
		for(int index = 0; index < movesArray.length; index++) 
		{
			boolean evenGridSpot = (index % 2 == 0);
			boolean oddGridSpot = (index % 2 == 1); 

			if((movesArray[index] != -1 && movesArray[index] == getGridSpot(r, c)))
			{
				if(evenGridSpot)
				{
					return Mark.X;
				}
				return Mark.O;
			}
		}
		return Empty; //or if !gameOver() Mark == Empty ??????
	}


	public void setMark(int row, int column) {

		assert isValidRange(row, column): "range is invalid";

		//ensure its marks turn by using getTurn()
		Mark player = getTurn();

		//assert getTurn() -> true for 
		//(row, col) then gridSpot

		//call getMark() to see if spot is empty
		assert getMark(row, column) == null;

		int[] myMovesArray = new int[9];
		while(!isGameOver())
		{
			for(int index = 0; index < movesArray.length; index++)
			{
				int gridSpot = row * ROW_COUNT + column;
				boolean arrayAlreadyContainValue = (movesArray[index] == gridSpot);
				if(arrayAlreadyContainValue == false && movesArray[index] == NO_MOVE )
				{
					myMovesArray[index] = gridSpot;
				}
				movesArray.equals(myMovesArray);
			}
		}
	}

	//part of post: rv == null <==> it is neither player's turn (i.e. game is over)
	public Mark getTurn() 
	{
		if(movesArray[0] == NO_MOVE)
		{
			return Mark.X;
		}
		Mark player = null;

		while(!isGameOver()) 
		{
		
			int oCount = 0;              
			int xCount = 0; 

			for(int index = 0; index < movesArray.length; index++)  
			{ 
				boolean evenGridSpot = (index % 2 == 0);

				if (evenGridSpot) 
				{
					xCount ++;          
				}
				else 
				{
					oCount ++;          
				}
			}

			while(xCount > oCount)
			{
				return Mark.O;
			}
			return Mark.X;
		} 
		return player;
	}


	//part of post: See Tic-tac-toe rules in order to fill this out
	public boolean isGameOver() 
	{

		boolean gameOver = false;
		boolean boardIsFull = movesArray[8] != NO_MOVE;

		if(movesArray[0] == -1)
		{
			return false;
		}

		//check to see if there is a winner up & down left & right and diagonally 
		if(checkRow() == true)
		{
			return true;
		}

		if(checkColumn() == true)
		{
			return true;
		}

		if(checkDiagonal() == true)
		{
			return true;
		}
		if(boardIsFull) 
		{
			return true;
		}
		return gameOver;

		//if (there is a winner)
		//return false
	}

	private boolean checkRow() 
	{
		for(int index = 0; index < ROW_COUNT; index++) //use ROW_COUNT??
		{
			boolean rowValuesMatch = getMark(index, 0) == getMark(index, 1) && getMark(index, 0) == getMark(index, 2);
			if(getMark(index, 0) != null)// && rowValuesMatch )
			{
				return true;
			}
		}
		return false;
	}

	public boolean checkColumn() 
	{
		for(int index = 0; index < ROW_COUNT; index++) //use ROW_COUNT??
		{
			boolean columnValuesMatch = getMark(0, index) == getMark(1, index) && getMark(0, index) == getMark(2,index);
			if(getMark(0, index) != null) // && columnValuesMatch )
			{
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonal() 
	{
		for(int index = 0; index < ROW_COUNT; index++) //use ROW_COUNT??
		{
			boolean diagonalValuesMatch = getMark(1, 1) == getMark(0, 0) && getMark(1, 1) == getMark(2, 2) ||
					getMark(1, 1) == getMark(0, 2) && getMark(1, 1) == getMark(2, 0);
			if(diagonalValuesMatch == true)
			{
				if(getMark(1, 1) != null)
				{
					return true;
				}
			}
		}
		return false;
	}

	//part of pre: isGameOver()
	//part of post: rv == null <==> neither player won (i.e. the game ended in a tie)
	public Mark getWinner() 
	{
		assert isGameOver() == true : "Game not Over!";
		Mark gameWinner = null; 

		if(checkRow() == true)
		{
			return gameWinner();
		}

		if(checkColumn() == true)
		{
			return gameWinner();
		}

		if(checkDiagonal() == true)
		{
			return gameWinner();
		}
		return gameWinner;
	}


	public Mark gameWinner() {

		if(isGameOver() == true) 
		{
			int xCount = 0;              
			int oCount = 0; 

			for(int index = 0; index < movesArray.length; index++)  
			{ 
				boolean evenIndex = (index % 2 == 0);

				if (evenIndex) 
				{
					xCount ++;          
				}
				else 
				{
					oCount ++;          
				}
			}

			if(xCount > oCount)
			{
				return Mark.O;
			}
		}
		return Mark.X;
	}



}
