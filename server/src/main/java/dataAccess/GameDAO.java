package dataAccess;

import model.GameData;

import java.util.HashSet;

public interface GameDAO {
    void clear();
    GameData getGame(int gameID);
    HashSet<GameData> getAllGames();
    GameData insertGame(GameData newGame);
}
