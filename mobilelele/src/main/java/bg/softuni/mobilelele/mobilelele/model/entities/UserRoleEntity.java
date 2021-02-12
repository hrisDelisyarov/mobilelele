package bg.softuni.mobilelele.mobilelele.model.entities;

import bg.softuni.mobilelele.mobilelele.model.entities.enums.UserRolesEnum;

import javax.persistence.*;
@Entity
@Table(name="user_roles")
public class UserRoleEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRolesEnum role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRolesEnum getRole() {
        return role;
    }

    public void setRole(UserRolesEnum role) {
        this.role = role;
    }
}
