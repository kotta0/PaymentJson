package com.karamihaylov.chesschallenges.KnightMoveInLimitBoard;

public class Cell implements Comparable<Cell> {
	
	    int row;
	    int col;
	    boolean visited;
	    int moveNumber;
	    int availableMoves;

	    Cell(int row, int col) {
	        this.row = row;
	        this.col = col;
	        this.visited = false;
	    }

	    public int compareTo(Cell o) {
	        return Integer.compare(this.availableMoves, o.availableMoves);
	    }

}
