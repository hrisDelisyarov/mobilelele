package bg.softuni.mobilelele.mobilelele.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private boolean isActive;

    @ManyToMany
    private List<UserRoleEntity> role;

    @Column
    private String imageUrl;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<UserRoleEntity> getRole() {
        return role;
    }

    public void setRole(List<UserRoleEntity> role) {
        this.role = role;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='N/A" + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", role=" + role +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
