package service;

import com.google.gson.Gson;

public record LogoutResult() {
    public String toString() {return new Gson().toJson(this);}
}
