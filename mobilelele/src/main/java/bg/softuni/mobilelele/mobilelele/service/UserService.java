package bg.softuni.mobilelele.mobilelele.service;

public interface UserService {
    /**
     *
     * @param username
     * @param password
     * @return true if authentication was successful
     */
    boolean authenticate(String username, String password);
    void loginUser(String username);

    void logoutUser();
}
