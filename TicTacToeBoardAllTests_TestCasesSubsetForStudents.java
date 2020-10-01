package test;

import tictactoe.TicTacToeBoard;
import tictactoe.TicTacToeBoardImpl_Polk;

//Student needs to finish some test cases by replacing RuntimeExceptions with test code
public class TicTacToeBoardAllTests_TestCasesSubsetForStudents {
	private String GOLD_STANDARD_MESSAGE;
	public static final String PACKAGE_NAME = "tictactoe";

	private TicTacToeBoard ticTacToeBoard_Polk;

	/**********************************************************************************************************************/	
	private void initializeBoard(int[] movesArray)
	{
		ticTacToeBoard_Polk = new TicTacToeBoardImpl_Polk();
		
//		ticTacToeBoard_Polk.temptyBoardTest();
//		    // Test case: position was available (blank)
//		assertEquals('X', t.getMark(1,1));
//	
//		while 
//		{
//		System.out.println(“Current board layout:”);
//		game.printBoard();
//		int row;
//		int col;
//		do
//		{
//		System.out.println(“Player “ + game.getCurrentPlayer() + “, enter an empty row and column to place your mark!”);
//		row = scan.nextInt()-1;
//		col = scan.nextInt()-1;
//		}
//		while (!game.placeMark(row, col));
//		game.changePlayer();
//		}
		
		throw new RuntimeException("Student needs to add code here to properly initialize board or initialize board another way!");
	}
	/**********************************************************************************************************************/

	@Points(value=5)
	@Test(timeout=3000)
	public void emptyBoardTest()
	{
		int[] movesArray = new int[]{};
		
		initializeBoard(movesArray);
		throw new RuntimeException("Student needs to check that all methods behave properly!");
	}

	@Points(value=5)
	@Test(timeout=3000)
	public void oneSymbolTest()
	{	
		int[] movesArray = new int[]{2};

		initializeBoard(movesArray);
		throw new RuntimeException("Student needs to check that all methods behave properly!");
	}	

	@Points(value=5)
	@Test(timeout=3000)
	public void twoSymbolTest()
	{
		int[] movesArray = new int[]{4,8};

		initializeBoard(movesArray);
		throw new RuntimeException("Student needs to check that all methods behave properly!");
	}	

	@Points(value=5)
	@Test(timeout=3000)
	public void threeSymbolTest()
	{
		int[] movesArray = new int[]{1, 2, 3};

		initializeBoard(movesArray);
		throw new RuntimeException("Student needs to check that all methods behave properly!");
	}

	@Points(value=5)
	@Test(timeout=3000)
	public void earlyWinnerTest()
	{
		int[] movesArray = new int[]{3, 8, 4, 7, 5};

		initializeBoard(movesArray);
		throw new RuntimeException("Student needs to check that all methods behave properly!");
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void setMarkOutOfBounds()
	{
		final int ROW = 4;
		final int COLUMN = 3;

		GOLD_STANDARD_MESSAGE = "Throw an AssertionError on the call " + "setMark(" + ROW + ", " + COLUMN + ")";
		ticTacToeBoard_Polk.setMark(ROW, COLUMN);
	}

	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void setMarkOutOfBounds2()
	{
		final int ROW = 0;
		final int COLUMN = 13;

		GOLD_STANDARD_MESSAGE = "Throw an AssertionError on the call " + "setMark(" + ROW + ", " + COLUMN + ")";
		ticTacToeBoard_Polk.setMark(ROW, COLUMN);
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void setMarkTwice()
	{	
		final int ROW = 1;
		final int COLUMN = 2;

		GOLD_STANDARD_MESSAGE = "Correctly throw an AssertionError on the call " + "setMark(" + ROW + ", " + COLUMN + ")";
		
		ticTacToeBoard_Polk.setMark(ROW, COLUMN);
		ticTacToeBoard_Polk.setMark(ROW, COLUMN);
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void setMarkAfterGameOver()
	{
		
		GOLD_STANDARD_MESSAGE = "Correctly throw an AssertionError on the call " + "setMark(" + 1 + ", " + 2 + ")";
		
		ticTacToeBoard_Polk.setMark(0, 0);
		ticTacToeBoard_Polk.setMark(1, 0);
		ticTacToeBoard_Polk.setMark(0, 1);
		ticTacToeBoard_Polk.setMark(1, 1);
		ticTacToeBoard_Polk.setMark(0, 2);
		ticTacToeBoard_Polk.setMark(1, 2);
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void setMarkAfterGameOver2()
	{	
		GOLD_STANDARD_MESSAGE = "Correctly throw an AssertionError on the call " + "setMark(" + 2 + ", " + 0 + ")";
		
		ticTacToeBoard_Polk.setMark(1, 1);
		ticTacToeBoard_Polk.setMark(0, 0);
		ticTacToeBoard_Polk.setMark(2, 2);
		ticTacToeBoard_Polk.setMark(0, 2);
		ticTacToeBoard_Polk.setMark(1, 0);
		ticTacToeBoard_Polk.setMark(0, 1);
		ticTacToeBoard_Polk.setMark(2, 0);
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void getMarkOutOfBounds()
	{
		final int ROW = 2;
		final int COLUMN = 4;

		GOLD_STANDARD_MESSAGE = "Correctly throw an AssertionError on the call " + "getMark(" + ROW + ", " + COLUMN + ")";
		
		ticTacToeBoard_Polk.setMark(ROW, COLUMN);
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void emptyBoardGetWinner()
	{
		GOLD_STANDARD_MESSAGE = "Correctly throw an AssertionError on the call " + ".getWinner()";
		
		ticTacToeBoard_Polk.getWinner();
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void twoRoundsGetWinner()
	{
		GOLD_STANDARD_MESSAGE = "Correctly throw an AssertionError on the call " + "getWinner()";
		
		ticTacToeBoard_Polk.setMark(0, 0);
		ticTacToeBoard_Polk.setMark(1, 1);
		ticTacToeBoard_Polk.getWinner();
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void threeRoundsGetWinner()
	{
		GOLD_STANDARD_MESSAGE = "Correctly throw an AssertionError on the call " + "getWinner()";
		
		ticTacToeBoard_Polk.setMark(0, 0);
		ticTacToeBoard_Polk.setMark(1, 1);
		ticTacToeBoard_Polk.setMark(2, 0);
		ticTacToeBoard_Polk.getWinner();
	}
}
