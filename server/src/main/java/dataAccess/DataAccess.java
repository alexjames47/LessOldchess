package dataAccess;

public interface DataAccess {

    AuthDAO getAuthDAO();
    GameDAO getGameDAO();
    UserDAO getUserDAO();

}
