package chess;

import java.util.Collection;

/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {

    ChessBoard currentBoard = new ChessBoard();
    TeamColor playerTurn = TeamColor.WHITE;

    public ChessGame() {

    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return playerTurn;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        playerTurn = team;
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        Collection<ChessMove> moveCollection = currentBoard.getPiece(startPosition).pieceMoves(currentBoard,startPosition);
        KingEndangerCalculator endangerCalculator = new KingEndangerCalculator();
        return endangerCalculator.removeEndangeringMoves(moveCollection,currentBoard);
    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to preform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
        if(currentBoard != null
                && currentBoard.getCurrentBoard()[move.getStartPosition().getRow()-1][move.getStartPosition().getColumn()-1] != null
                && validMoves(move.getStartPosition()).contains(move)
                && currentBoard.getCurrentBoard()[move.getStartPosition().getRow()-1][move.getStartPosition().getColumn()-1].getTeamColor() == playerTurn){

            if(move.getPromotionPiece() != null){
                currentBoard.addPiece(move.getEndPosition(),new ChessPiece(currentBoard.getOccupiedSpaceColor(move.getStartPosition()),move.getPromotionPiece()));
            } else {
                currentBoard.addPiece(move.getEndPosition(), currentBoard.getPiece(move.startPosition));
            }
            currentBoard.getCurrentBoard()[move.getStartPosition().getRow()-1][move.getStartPosition().getColumn()-1] = null;
            if(playerTurn == TeamColor.WHITE) {playerTurn = TeamColor.BLACK;}
            else {playerTurn = TeamColor.WHITE;}
        } else {
            throw new InvalidMoveException();
        }
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        KingEndangerCalculator endangerCalculator = new KingEndangerCalculator();
        return endangerCalculator.isKingEndangeredOnBoard(currentBoard,teamColor);
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        //parses through all possible moves on the board and returns false if at least one of them do not endanger the king
        KingEndangerCalculator endangerCalculator = new KingEndangerCalculator();
        if(!isInCheck(teamColor)){return false;}
        else {
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(currentBoard.getPiece(new ChessPosition(i+1,j+1)) != null
                            && currentBoard.getPiece(new ChessPosition(i+1,j+1)).getTeamColor() == teamColor){
                        Collection<ChessMove> moves = currentBoard.getPiece(new ChessPosition(i+1,j+1)).pieceMoves(currentBoard,new ChessPosition(i+1,j+1));
                        for(ChessMove currentMove: moves) {
                            if(!endangerCalculator.isKingEndangered(currentMove,currentBoard)){return false;}
                        }
                    }
                }
            }
            return true;
        }
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        KingEndangerCalculator endangerCalculator = new KingEndangerCalculator();
        if(!isInCheck(teamColor)){
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(currentBoard != null
                            && currentBoard.getPiece(new ChessPosition(i+1,j+1)) != null
                            && currentBoard.getPiece(new ChessPosition(i+1,j+1)).getTeamColor() == teamColor){
                        Collection<ChessMove> moves = currentBoard.getPiece(new ChessPosition(i+1,j+1)).pieceMoves(currentBoard,new ChessPosition(i+1,j+1));
                        for(ChessMove currentMove: moves) {
                            if(endangerCalculator.isKingEndangered(currentMove,currentBoard)){return false;}
                        }
                    }
                }
            }
            return true;
        } else {return false;}
    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        this.currentBoard = new ChessBoard(board);
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return currentBoard;
    }
}
