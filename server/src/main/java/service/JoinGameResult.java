package service;

import com.google.gson.Gson;

public record JoinGameResult() {
    public String toString() {return new Gson().toJson(this);}
}
