package model;

import com.google.gson.Gson;

import java.util.UUID;

public record AuthData(
        String authToken, String username) {

    public AuthData newAuthToken(String username){
        return new AuthData(UUID.randomUUID().toString(),username);
    }

    public String toString() {return new Gson().toJson(this);}
}
