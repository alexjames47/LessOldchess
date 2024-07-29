package service;

import com.google.gson.Gson;

record LoginRequest(
        String username,
        String password){
    public String toString() {return new Gson().toJson(this);}
}
