package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    ChessPiece[][] currentBoard = new ChessPiece[8][8];

    public ChessBoard() {}
    //I made my chessboard a 2D Array of ChessPiece objects
    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        currentBoard[position.getRow()-1][position.getColumn()-1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        if(currentBoard[position.getRow()-1][position.getColumn()-1] != null){
            return currentBoard[position.getRow()-1][position.getColumn()-1];
        }
        else return null;
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     * Looks like below
     *                 |r|n|b|q|k|b|n|r|
     *                 |p|p|p|p|p|p|p|p|
     *                 | | | | | | | | |
     *                 | | | | | | | | |
     *                 | | | | | | | | |
     *                 | | | | | | | | |
     *                 |P|P|P|P|P|P|P|P|
     *                 |R|N|B|Q|K|B|N|R|
     */
    public void resetBoard() {
        this.clearBoard();
        ChessGame.TeamColor Colour = ChessGame.TeamColor.WHITE;
        for(int i=0; i<5; i++){
            if(Colour == ChessGame.TeamColor.BLACK) {i+=6;}
            currentBoard[i][0] = new ChessPiece(Colour, ChessPiece.PieceType.ROOK);
            currentBoard[i][1] = new ChessPiece(Colour, ChessPiece.PieceType.KNIGHT);
            currentBoard[i][2] = new ChessPiece(Colour, ChessPiece.PieceType.BISHOP);
            currentBoard[i][3] = new ChessPiece(Colour, ChessPiece.PieceType.QUEEN);
            currentBoard[i][4] = new ChessPiece(Colour, ChessPiece.PieceType.KING);
            currentBoard[i][5] = new ChessPiece(Colour, ChessPiece.PieceType.BISHOP);
            currentBoard[i][6] = new ChessPiece(Colour, ChessPiece.PieceType.KNIGHT);
            currentBoard[i][7] = new ChessPiece(Colour, ChessPiece.PieceType.ROOK);
            if(Colour == ChessGame.TeamColor.BLACK) {i-=2;}
            for(int j=0; j<8; j++){
                currentBoard[i+1][j] = new ChessPiece(Colour, ChessPiece.PieceType.PAWN);
            }
            Colour = ChessGame.TeamColor.BLACK;
        }
    }

    public boolean isSpaceEmpty(ChessPosition currentPosition){
        return (currentBoard[currentPosition.getRow()-1][currentPosition.getColumn()-1] == null);
    }

    public void clearBoard() {
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                currentBoard[i][j] = null;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessBoard that)) return false;
        return Arrays.deepEquals(currentBoard, that.currentBoard);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(currentBoard);
    }

    @Override
    public String toString() {
        StringBuilder builtBoard = new StringBuilder();
        builtBoard.append("|");
        for (int i=0; i<8; i++){

            if(i>0) {
                builtBoard.append("\n");
                builtBoard.append("|");
            }
            for (int j=0; j<8; j++){
                ChessPosition currentPosition = new ChessPosition(i+1,j+1);
                if(this.getPiece(currentPosition) != null){
                    builtBoard.append(getPiece(currentPosition).toString());
                }
                else{
                    builtBoard.append(" ");
                }
                builtBoard.append("|");
            }
        }
        return builtBoard.toString();
    }
}
