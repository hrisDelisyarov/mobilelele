package bg.softuni.mobilelele.mobilelele.model.service;

import bg.softuni.mobilelele.mobilelele.model.entities.UserRoleEntity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserRegisterServiceModel {
    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String username;

    @NotNull
    @NotEmpty
    @Size(min=5)
    private String password;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;

    private boolean isActive;
    private List<UserRoleEntity> roles;
    private String imageUrl;

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserRegisterServiceModel setActive(boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserRegisterServiceModel setRole(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserRegisterServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegisterServiceModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", role=" + roles +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
