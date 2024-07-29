package dataaccess;

import model.GameData;

import java.util.HashSet;

public interface GameDAO {
    void clear();
    GameData getGame(String gameID);
    HashSet<GameData> getAllGames();
    GameData insertGame(GameData newGame);
}
