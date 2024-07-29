package service;

import com.google.gson.Gson;

public record JoinGameRequest(String playerColor, String gameID) {
    public String toString() {return new Gson().toJson(this);}
}
