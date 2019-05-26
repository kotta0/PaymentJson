package com.karamihaylov.chesschallenges.KnightMoveInLimitBoard;

/**
 * Knights Move using Greedy Algorithm
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//import java.util.Scanner;

public class KnightOnMove {

    private static final int[] ROWS = {1, -1, 1, -1, 2, 2, -2, -2};
    private static final int[] COLS = {2, 2, -2, -2, 1, -1, 1, -1};
    //Init board standard 8x8 Chessboard
    private static int n = 8;
    private static int moveNumber = 1;
    private static Cell[][] board;
    private static Cell currentCell;

    public static void main(String[] args) {
     //   Test with Matrix 7x7 as well	
     //   Scanner input = new Scanner(System.in);
     //   n = Integer.parseInt(input.nextLine());
      
        initBoard(n, n);
        
        //start from top left corner
        move(0, 0);
        
        List<Cell> availableMoves = getAvailableMoves(currentCell);
        while (moveNumber <= (n * n) && !availableMoves.isEmpty()) {
            Collections.sort(availableMoves);
            move(availableMoves.get(0).row, availableMoves.get(0).col);
            availableMoves = getAvailableMoves(currentCell);
        }

        printResult();
        KnightOnMove kom = new KnightOnMove();
        kom.getMaxMoveNumber();
    }

    private static void move(int row, int col) {
        board[row][col].moveNumber = moveNumber;
        board[row][col].visited = true;
        currentCell = board[row][col];
        moveNumber++;
    }

    private static  List<Cell> getAvailableMoves(Cell currentCell) {
        List<Cell> result = new ArrayList<Cell>();

        for (int i = 0; i < ROWS.length; i++) {

            int nextRow = currentCell.row + ROWS[i];
            int nextCol = currentCell.col + COLS[i];

            if (isInBounds(nextRow, nextCol)
                    && !board[nextRow][nextCol].visited) {

                int counter = 0;
                for (int j = 0; j < COLS.length; j++) {
                    if (isInBounds(nextRow + ROWS[j], nextCol + COLS[j])
                            && !board[nextRow + ROWS[j]][nextCol + COLS[j]].visited) {
                        counter++;
                    }
                }
                Cell tempCell = new Cell(nextRow, nextCol);
                tempCell.availableMoves = counter;
                result.add(tempCell);
            }
        }
        return result;
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0
                && row < n
                && col >= 0
                && col < n;
    }

    private static void printResult() {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(String.format("%4d", board[row][col].moveNumber));
            }
            System.out.println();
        }
    }

    public int getMaxMoveNumber(){
    	
		int maxNumberElement = 0;
		//TO-do
		//find maxNumber element and return for UnitTest
		return maxNumberElement;
    	
    }
    private static void initBoard(int rows, int cols) {
        board = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
        //The core of the figure disabled
        board[3][3].visited = true;
        board[3][4].visited = true;
        board[4][3].visited = true;
        board[4][4].visited = true;
    }

}

