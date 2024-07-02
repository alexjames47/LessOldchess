package chess.chessMoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

public class PieceMoveCalculator {

    ChessMove pieceMoveAdder(ChessPosition[] chessPositions, int[] movableDirections, ChessBoard currentBoard){
        ChessPosition startingPosition = chessPositions[0];
        ChessPosition currentPosition = chessPositions[1];
        ChessPosition newPosition = new
                ChessPosition(currentPosition.getRow()+movableDirections[0],currentPosition.getColumn()+movableDirections[1]);

        if(!currentBoard.isSpaceEmpty(newPosition)){
            if()
        }
    }

    boolean withinBoard(ChessPosition currentPosition, int[] currentDirection){
        return(currentPosition.getRow()+currentDirection[0]<9
                && currentPosition.getRow()+currentDirection[0] > 0
                && currentPosition.getRow()+currentDirection[1] < 9
                && currentPosition.getRow()+currentDirection[1] > 0);
    }

}
