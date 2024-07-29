package service;

import com.google.gson.Gson;

record LoginResult(
        String username,
        String authToken){
    public String toString() {return new Gson().toJson(this);}
}
