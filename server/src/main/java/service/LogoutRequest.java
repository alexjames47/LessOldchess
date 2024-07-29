package service;

import com.google.gson.Gson;

public record LogoutRequest() {
    public String toString() {return new Gson().toJson(this);}
}
