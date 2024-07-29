package service;

import com.google.gson.Gson;

public record RegisterResult(String username,
                             String authToken) {
    public String toString() {return new Gson().toJson(this);}
}
