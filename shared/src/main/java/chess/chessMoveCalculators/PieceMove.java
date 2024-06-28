package chess.chessMoveCalculators;



import java.util.Collection;

public interface PieceMove {
    Collection<chess.ChessMove> currentPieceMoves(chess.ChessBoard currentBoard, chess.ChessPosition currentPosition);
}
