package chess;

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
        currentBoard[position.getRow()][position.getColumn()] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return currentBoard[position.getRow()][position.getColumn()];
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

    }
}
