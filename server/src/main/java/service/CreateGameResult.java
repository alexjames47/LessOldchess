package service;

import com.google.gson.Gson;

public record CreateGameResult(String gameID) {
    public String toString() {return new Gson().toJson(this);}
}
