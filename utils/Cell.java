package utils;

public class Cell implements Comparable<Cell> {

	private int row;
	
	private int col;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "[" + row + ", " + col + "]";
	}

	@Override
	public int compareTo(Cell c) {
		return this.row - c.row;
	}
	
}
