package chess;

import chess.chessMoveCalculators.BishopMove;

import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    ChessGame.TeamColor currentPieceColor;
    ChessPiece.PieceType currentType;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        currentPieceColor = pieceColor;
        currentType = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return currentPieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return currentType;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if(board.getPiece(myPosition).getPieceType() == PieceType.BISHOP){
            BishopMove ValidBishopMovesCalculator = new BishopMove();
            return ValidBishopMovesCalculator.currentPieceMoves(board,myPosition);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessPiece that)) return false;
        return currentPieceColor == that.currentPieceColor && currentType == that.currentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPieceColor, currentType);
    }

    @Override
    public String toString() {
        String value;
        if (this.currentPieceColor == ChessGame.TeamColor.BLACK){
            value = String.valueOf(currentType);
            value = value.substring(0,1);   // Black is Upper Case
        }
        else{
            value = String.valueOf(currentType);
            value = value.substring(0,1);
            value = value.toLowerCase();    // White is Lower Case
        }
        return value;
    }
}
