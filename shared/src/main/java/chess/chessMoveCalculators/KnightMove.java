package chess.chessMoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;
import java.util.HashSet;

public class KnightMove extends PieceMoveCalculator implements PieceMove{

    public Collection<ChessMove> currentPieceMoves(ChessBoard currentBoard, ChessPosition currentPosition){
        HashSet<ChessMove> movesHashSet = new HashSet<>();
        int[][] movableDirections = knightMovableDirections();
        ChessPosition initialPosition = new ChessPosition(currentPosition.getRow(),currentPosition.getColumn());
        ChessPosition[] chessPositions = new ChessPosition[]{initialPosition,currentPosition};
        for (int i=0; i<8; i++){
            while(withinBoard(chessPositions[1],movableDirections[i])){
                movesHashSet.add(pieceMoveAdder(chessPositions, movableDirections[i], currentBoard)); //add the possible move
            }
            chessPositions[1] = chessPositions[0];
        }
        movesHashSet.remove(null);
        return movesHashSet;
    }

    int[][] knightMovableDirections(){
        int[][] directions = new int[8][2];
        //SW
        directions[0][0] = -1;
        directions[0][1] = -2;
        //SW
        directions[1][0] = -2;
        directions[1][1] = -1;
        //SE
        directions[2][0] = -1;
        directions[2][1] = 2;
        //SE
        directions[3][0] = -2;
        directions[3][1] = 1;
        //NE
        directions[4][0] = 1;
        directions[4][1] = 2;
        //NE
        directions[5][0] = 2;
        directions[5][1] = 1;
        //NW
        directions[6][0] = 1;
        directions[6][1] = -2;
        //NW
        directions[7][0] = 2;
        directions[7][1] = -1;
        return directions;
    }

}
