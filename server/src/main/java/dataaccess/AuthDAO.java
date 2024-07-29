package dataaccess;

import exception.ResponseException;
import model.AuthData;

public interface AuthDAO {
    AuthData createAuth() throws ResponseException;
    AuthData getAuth(AuthData authToken) throws ResponseException;
}
