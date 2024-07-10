package chess.chessMoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

public class PieceMoveCalculator {

    ChessMove pieceMoveAdder(ChessPosition[] chessPositions, int[] movableDirection, ChessBoard currentBoard){
        ChessPosition startingPosition = chessPositions[0];
        ChessPosition possibleNewPosition = new ChessPosition(chessPositions[1].getRow()+movableDirection[0],chessPositions[1].getColumn()+movableDirection[1]);

        chessPositions[1] = possibleNewPosition;

        if(currentBoard.isSpaceEmpty(possibleNewPosition) || currentBoard.getOccupiedSpaceColor(startingPosition) != currentBoard.getOccupiedSpaceColor(possibleNewPosition)){
            if(!currentBoard.isSpaceEmpty(possibleNewPosition) && currentBoard.getPiece(possibleNewPosition).getPieceType() == ChessPiece.PieceType.KING){
                return new ChessMove(startingPosition,possibleNewPosition,null,true);
            }
            return new ChessMove(startingPosition,possibleNewPosition,null);
        } else return null;
    }

    boolean withinBoard(ChessPosition currentPosition, int[] currentDirection){
        return(currentPosition.getRow()+currentDirection[0]<9
                && currentPosition.getRow()+currentDirection[0] > 0
                && currentPosition.getColumn()+currentDirection[1] < 9
                && currentPosition.getColumn()+currentDirection[1] > 0);
    }

}
