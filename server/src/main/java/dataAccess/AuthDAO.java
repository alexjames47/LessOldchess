package dataAccess;

import model.AuthData;

public interface AuthDAO {
    void clear();
    void createAuth(AuthData authToken);
    AuthData getAuth(String authToken);
    void deleteAuth(String authToken);
}
