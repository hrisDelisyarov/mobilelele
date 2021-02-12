package bg.softuni.mobilelele.mobilelele.security;


import bg.softuni.mobilelele.mobilelele.model.entities.enums.UserRolesEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {
    private static final String ANONYMOUS = "anonymous";
    private String name=ANONYMOUS;
    private boolean isAnonymous = true;
    private List<UserRolesEnum> userRoles = new ArrayList<>();
    public boolean isAdmin()
    {
        return userRoles.contains(UserRolesEnum.ADMIN);
    }

    public  CurrentUser setUserRoles(List<UserRolesEnum> roles)
    {
        userRoles.clear();
        userRoles.addAll(roles);
        return this;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public boolean isLoggedIn()
    {
        return !isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        if (anonymous)
        {
            this.name=ANONYMOUS;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
    }
}
