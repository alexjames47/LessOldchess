package service;

import com.google.gson.Gson;

public record ListGamesRequest() {
    public String toString() {return new Gson().toJson(this);}
}
