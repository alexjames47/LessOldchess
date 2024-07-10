package chess;

import chess.chessMoveCalculators.*;

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
            BishopMove BishopMovesCalculator = new BishopMove();
            return BishopMovesCalculator.currentPieceMoves(board,myPosition);
        } else if(board.getPiece(myPosition).getPieceType() == PieceType.KING){
            KingMove KingMovesCalculator = new KingMove();
            return KingMovesCalculator.currentPieceMoves(board,myPosition);
        } else if(board.getPiece(myPosition).getPieceType() == PieceType.KNIGHT){
            KnightMove KnightMovesCalculator = new KnightMove();
            return KnightMovesCalculator.currentPieceMoves(board,myPosition);
        } else if(board.getPiece(myPosition).getPieceType() == PieceType.PAWN){
            PawnMove PawnMovesCalculator = new PawnMove();
            return PawnMovesCalculator.currentPieceMoves(board,myPosition);
        } else if(board.getPiece(myPosition).getPieceType() == PieceType.QUEEN){
            QueenMove QueenMovesCalculator = new QueenMove();
            return QueenMovesCalculator.currentPieceMoves(board,myPosition);
        } else if(board.getPiece(myPosition).getPieceType() == PieceType.ROOK){
            RookMove RookMovesCalculator = new RookMove();
            return RookMovesCalculator.currentPieceMoves(board,myPosition);
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
        String temp;
        if(this.currentType == PieceType.KNIGHT){temp = String.valueOf(this.currentType).substring(1,2);}
        else {temp = String.valueOf(this.currentType).substring(0,1);}
        if(this.currentPieceColor == ChessGame.TeamColor.WHITE) {temp = temp.toLowerCase();}
        return temp;
    }
}
