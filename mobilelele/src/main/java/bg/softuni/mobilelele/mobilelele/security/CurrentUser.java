package bg.softuni.mobilelele.mobilelele.security;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private static final String ANONYMOUS = "anonymous";
    private String name=ANONYMOUS;
    private boolean isAnonymous;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        if (anonymous)
        {
            this.name=ANONYMOUS;
        }
        isAnonymous = anonymous;
    }
}