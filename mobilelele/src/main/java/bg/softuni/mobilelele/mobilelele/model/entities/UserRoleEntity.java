package bg.softuni.mobilelele.mobilelele.model.entities;

import bg.softuni.mobilelele.mobilelele.model.entities.enums.UserRolesEnum;

import javax.persistence.*;
@Entity
@Table(name="UserRoles")
public class UserRoleEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRolesEnum role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRolesEnum getRole() {
        return role;
    }

    public void setRole(UserRolesEnum role) {
        this.role = role;
    }
}
