package dataAccess.memoryDOAs;

import dataAccess.GameDAO;
import model.GameData;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

import static java.util.HashSet.newHashSet;

public class MemoryGameDAO implements GameDAO {

    private final Map<Integer, GameData> gamesList = new HashMap<>();

    @Override
    public void clear() {
        gamesList.clear();
    }

    @Override
    public GameData getGame(int gameID) {
        return gamesList.get(gameID);
    }

    @Override
    public HashSet<GameData> getAllGames() {
        return (HashSet<GameData>) gamesList.values();
    }

    @Override
    public GameData insertGame(GameData newGame) {
        int gameID = 1;
        while(gamesList.get(gameID) != null){gameID++;}
        newGame = new GameData(gameID, newGame.whiteUsername(), newGame.blackUsername(), newGame.gameName(), newGame.game());
        gamesList.put(gameID,newGame);
        return newGame;
    }
}
