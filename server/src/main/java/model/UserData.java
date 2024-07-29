package model;

import com.google.gson.Gson;

public record UserData(
        String username, String password, String email) {

    UserData newPassword(String newPassword) {
        return new UserData(username, (newPassword), email);
    }
    UserData newEmail(String newEmail) {
        return new UserData(username, password, (newEmail));
    }
    public String toString() {return new Gson().toJson(this);}
}
