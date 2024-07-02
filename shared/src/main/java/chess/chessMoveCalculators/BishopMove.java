package chess.chessMoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;
import java.util.HashSet;

public class BishopMove extends PieceMoveCalculator implements PieceMove{
    public Collection<ChessMove> currentPieceMoves(ChessBoard currentBoard, ChessPosition currentPosition){
        HashSet<ChessMove> movesHashSet = new HashSet<>();
        int[][] movableDirections = bishopMovableDirections();
        ChessPosition initialPosition = new ChessPosition(currentPosition.getRow(),currentPosition.getColumn());
        ChessPosition[] chessPositions = new ChessPosition[]{initialPosition,currentPosition};
        for (int i=0; i<4; i++){
            while(withinBoard(chessPositions[1],movableDirections[i])){
                movesHashSet.add(pieceMoveAdder(chessPositions, movableDirections[i], currentBoard)); //add the possible move
                if(!currentBoard.isSpaceEmpty(chessPositions[1])){break;}
            }
            chessPositions[1] = chessPositions[0];
        }
        movesHashSet.remove(null);
        return movesHashSet;
    }

    int[][] bishopMovableDirections(){
        int[][] directions = new int[4][2];
        //SW
        directions[0][0] = -1;
        directions[0][1] = -1;
        //SE
        directions[1][0] = -1;
        directions[1][1] = 1;
        //NE
        directions[2][0] = 1;
        directions[2][1] = 1;
        //NW
        directions[3][0] = 1;
        directions[3][1] = -1;
        return directions;
    }
}
