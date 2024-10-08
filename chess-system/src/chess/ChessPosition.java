package chess;

import boardgame.Position;

public class ChessPosition {
	public char column;
	public int row;
	
	
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || row <1 || row>8)
			throw new ChessException("Invalid number of rows or columns");
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
		
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
		
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
}
