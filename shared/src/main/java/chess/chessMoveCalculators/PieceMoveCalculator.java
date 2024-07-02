package chess.chessMoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

public class PieceMoveCalculator {

    ChessMove pieceMoveAdder(ChessPosition[] chessPositions, int[] movableDirections, ChessBoard currentBoard){
        ChessPosition startingPosition = chessPositions[0];
        ChessPosition currentPosition = chessPositions[1];
        ChessPosition possibleNewPosition = new
                ChessPosition(currentPosition.getRow()+movableDirections[0],currentPosition.getColumn()+movableDirections[1]);

        if(!currentBoard.isSpaceEmpty(possibleNewPosition)){
            if(currentBoard.getOccupiedSpaceColor(startingPosition) != currentBoard.getOccupiedSpaceColor(possibleNewPosition)){
                ChessMove moveToAdd = new ChessMove(startingPosition,possibleNewPosition,null);
                chessPositions[1] = possibleNewPosition;
                return moveToAdd; // Can Move here and Take Piece
            } else if(currentBoard.getOccupiedSpaceColor(startingPosition) == currentBoard.getOccupiedSpaceColor(possibleNewPosition)){
                chessPositions[1] = possibleNewPosition;
                return null; // Cannot Move here - Occupied by friendly piece
            }
        } else if(currentBoard.isSpaceEmpty(possibleNewPosition)) {
            ChessMove moveToAdd = new ChessMove(startingPosition,possibleNewPosition,null);
            chessPositions[1] = possibleNewPosition;
            return moveToAdd;
        }
        return null;
    }

    boolean withinBoard(ChessPosition currentPosition, int[] currentDirection){
        return(currentPosition.getRow()+currentDirection[0]<9
                && currentPosition.getRow()+currentDirection[0] > 0
                && currentPosition.getRow()+currentDirection[1] < 9
                && currentPosition.getRow()+currentDirection[1] > 0);
    }

}
