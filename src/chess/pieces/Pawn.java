package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		p.setValues(position.getRow(), position.getColumn());
		
		if (getColor() == Color.WHITE) {
			p.setRow(p.getRow() - 1);
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				if (getMoveCount() == 0 && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow() - 1][p.getColumn()] = true;
				}
			}
			if (isThereOponentPiece(p)) mat[p.getRow()][p.getColumn()] = true;
			
			//nw
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//ne
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		if (getColor() == Color.BLACK) {
			p.setRow(p.getRow() + 1);
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				if (getMoveCount() == 0 && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow() + 1][p.getColumn()] = true;
				}
			}
			if (isThereOponentPiece(p)) mat[p.getRow()][p.getColumn()] = true;
			
			//sw
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//se
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return mat;
	}

}
