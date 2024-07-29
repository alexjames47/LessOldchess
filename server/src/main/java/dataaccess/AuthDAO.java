package dataaccess;

import model.AuthData;

public interface AuthDAO {
    AuthData createAuth();
    AuthData getAuth(AuthData authToken);
}
