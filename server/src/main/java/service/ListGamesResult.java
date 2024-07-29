package service;

import com.google.gson.Gson;

public record ListGamesResult(String gameID,
                              String whiteUsername,
                              String blackUsername,
                              String gameName) {
    public String toString() {return new Gson().toJson(this);}
}
