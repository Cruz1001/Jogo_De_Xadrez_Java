package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    // Construtor com verificação de validade para número de linhas e colunas
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    // Getters para número de linhas e colunas
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Retorna a peça em uma posição específica (linha e coluna)
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    // Retorna a peça em uma posição dada uma instância de Position
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    // Coloca uma peça no tabuleiro em uma posição específica
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on this position: " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position; // Assumindo que há um setter para position na classe Piece
    }
    
    public Piece removePiece(Position position) {
    	if(!positionExists(position))
    		throw new BoardException("Position not on the board");
    	if (piece(position) == null)
    		return null;
    	Piece aux = piece(position);
    	aux.position = null;
    	pieces[position.getRow()][position.getColumn()] = null;
    	return aux;
    	}
    

    // Verifica se uma posição (linha e coluna) existe no tabuleiro
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    // Verifica se uma posição dada por uma instância de Position existe no tabuleiro
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    // Verifica se há uma peça em uma determinada posição
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
