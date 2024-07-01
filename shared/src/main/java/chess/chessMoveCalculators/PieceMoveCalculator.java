package chess.chessMoveCalculators;

import chess.ChessPosition;

public class PieceMoveCalculator {


    boolean withinBoard(ChessPosition currentPosition, int[] currentDirection){
        return(currentPosition.getRow()+currentDirection[0]<9
                && currentPosition.getRow()+currentDirection[0] > 0
                && currentPosition.getRow()+currentDirection[1] < 9
                && currentPosition.getRow()+currentDirection[1] > 0);
    }

}
