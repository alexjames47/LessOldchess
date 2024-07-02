package chess.chessMoveCalculators;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;
import java.util.HashSet;

public class PawnMove extends PieceMoveCalculator implements PieceMove{

    public Collection<ChessMove> currentPieceMoves(ChessBoard currentBoard, ChessPosition currentPosition){
        if(currentBoard.getCurrentBoard()[currentPosition.getRow()-1][currentPosition.getColumn()-1].getTeamColor()
                == ChessGame.TeamColor.WHITE){
            return whitePawnMoves(currentBoard,currentPosition);
        } else if(currentBoard.getCurrentBoard()[currentPosition.getRow()-1][currentPosition.getColumn()-1].getTeamColor()
                == ChessGame.TeamColor.BLACK){
            return blackPawnMoves(currentBoard,currentPosition);
        }
        throw new RuntimeException("Invalid Piece");
    }

    public Collection<ChessMove> whitePawnMoves(ChessBoard currentBoard, ChessPosition currentPosition){
        HashSet<ChessMove> movesHashSet = new HashSet<>();
        int[][] movableDirections = whitePawnMovableDirections();
        ChessPosition initialPosition = new ChessPosition(currentPosition.getRow(),currentPosition.getColumn());
        ChessPosition[] chessPositions = new ChessPosition[]{initialPosition,currentPosition};
        for (int i=0; i<3; i++){
            if(withinBoard(chessPositions[1],movableDirections[i])){
                if(whitePawnCanMove(currentBoard, i, chessPositions[1])){
                    movesHashSet.add(pieceMoveAdder(chessPositions, movableDirections[i], currentBoard)); //add the possible move
                }
            }
            chessPositions[1] = chessPositions[0];
        }
        movesHashSet.remove(null);
        return movesHashSet;
    }

    public Collection<ChessMove> blackPawnMoves(ChessBoard currentBoard, ChessPosition currentPosition){
        HashSet<ChessMove> movesHashSet = new HashSet<>();
        int[][] movableDirections = blackPawnMovableDirections();
        ChessPosition initialPosition = new ChessPosition(currentPosition.getRow(),currentPosition.getColumn());
        ChessPosition[] chessPositions = new ChessPosition[]{initialPosition,currentPosition};
        for (int i=0; i<3; i++){
            if(withinBoard(chessPositions[1],movableDirections[i])){
                if(blackPawnCanMove(currentBoard, i, chessPositions[1])){
                    movesHashSet.add(pieceMoveAdder(chessPositions, movableDirections[i], currentBoard)); //add the possible move
                }
            }
            chessPositions[1] = chessPositions[0];
        }
        movesHashSet.remove(null);
        return movesHashSet;
    }

    boolean whitePawnCanMove(ChessBoard currentBoard, int i, ChessPosition currentPosition){
        return ((i==2 && !currentBoard.isSpaceEmpty(new ChessPosition(currentPosition.getRow()+1,currentPosition.getColumn()-1)))
                || (i==1 && !currentBoard.isSpaceEmpty(new ChessPosition(currentPosition.getRow()+1,currentPosition.getColumn()+1)))
                || (i==0 && currentBoard.isSpaceEmpty(new ChessPosition(currentPosition.getRow()+1,currentPosition.getColumn()))));
    }

    boolean blackPawnCanMove(ChessBoard currentBoard, int i, ChessPosition currentPosition){
        return ((i==2 && !currentBoard.isSpaceEmpty(new ChessPosition(currentPosition.getRow()-1,currentPosition.getColumn()-1)))
                || (i==1 && !currentBoard.isSpaceEmpty(new ChessPosition(currentPosition.getRow()-1,currentPosition.getColumn()+1)))
                || (i==0 && currentBoard.isSpaceEmpty(new ChessPosition(currentPosition.getRow()-1,currentPosition.getColumn()))));
    }

    int[][] whitePawnMovableDirections(){
        int[][] directions = new int[3][2];
        //N
        directions[0][0] = 1;
        directions[0][1] = 0;
        //NE
        directions[1][0] = 1;
        directions[1][1] = 1;
        //NW
        directions[2][0] = 1;
        directions[2][1] = -1;
        return directions;
    }

    int[][] blackPawnMovableDirections(){
        int[][] directions = new int[3][2];
        //S
        directions[0][0] = 0;
        directions[0][1] = 1;
        //SE
        directions[1][0] = -1;
        directions[1][1] = 1;
        //NW
        directions[2][0] = -1;
        directions[2][1] = -1;
        return directions;
    }

}
