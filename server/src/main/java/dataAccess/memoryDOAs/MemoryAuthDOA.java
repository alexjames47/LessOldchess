package dataAccess.memoryDOAs;

import dataAccess.AuthDAO;
import model.AuthData;

import java.util.HashMap;
import java.util.Map;

public class MemoryAuthDOA implements AuthDAO {

    private final Map<String, AuthData> authTokens = new HashMap<>();

    @Override
    public void clear() {
        authTokens.clear();
    }

    @Override
    public void createAuth(AuthData authToken) {
        authTokens.put(authToken.authToken(), authToken);
    }

    @Override
    public AuthData getAuth(String authToken) {
        return authTokens.get(authToken);
    }

    @Override
    public void deleteAuth(String authToken) {
        authTokens.remove(authToken);
    }
}
