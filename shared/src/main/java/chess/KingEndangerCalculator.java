package chess;

import java.util.Collection;
import java.util.HashSet;

public class KingEndangerCalculator {

    Collection<ChessMove> removeEndangeringMoves(Collection<ChessMove> currentMoves, ChessBoard currentBoard){
        HashSet<ChessMove> safeMoves = new HashSet<>();
        for(ChessMove currentMove : currentMoves){
            if(!isKingEndangered(currentMove, currentBoard)){
                safeMoves.add(currentMove);
            }
        }
        return safeMoves;
    }

    boolean isKingEndangered(ChessMove currentMove, ChessBoard currentBoard){
        // Create a temporary Board that has made the given move
        ChessBoard tempBoard = new ChessBoard(currentBoard);
        ChessGame.TeamColor playerTurn = currentBoard.getOccupiedSpaceColor(currentMove.getStartPosition());
        tempBoard.getCurrentBoard()[currentMove.getEndPosition().getRow()-1][currentMove.getEndPosition().getColumn()-1] =
                tempBoard.getCurrentBoard()[currentMove.getStartPosition().getRow()-1][currentMove.getStartPosition().getColumn()-1];
        tempBoard.getCurrentBoard()[currentMove.getStartPosition().getRow()-1][currentMove.getStartPosition().getColumn()-1] = null;
        return(isKingEndangeredOnBoard(tempBoard, playerTurn));
    }

    boolean isKingEndangeredOnBoard(ChessBoard tempBoard, ChessGame.TeamColor playerTurn){
        //Parses through each piece and checks if they can now attack the king
        boolean isKingEndangered = false;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(tempBoard.getCurrentBoard()[i][j] != null
                    && tempBoard.getPiece(new ChessPosition(i+1,j+1)).getTeamColor() != playerTurn){
                    for(ChessMove currentMove : tempBoard.getPiece(new ChessPosition(i+1,j+1)).pieceMoves(tempBoard,new ChessPosition(i+1,j+1))){
                        if(currentMove.getEndangersEnemyKing()){
                            isKingEndangered = true;
                            return isKingEndangered;
                        }
                    }
                }
            }
        }
        return isKingEndangered;
    }

}
