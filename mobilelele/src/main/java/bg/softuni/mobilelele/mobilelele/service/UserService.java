package bg.softuni.mobilelele.mobilelele.service;

import bg.softuni.mobilelele.mobilelele.model.service.UserRegisterServiceModel;

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
    void registerUser(UserRegisterServiceModel model);
}
