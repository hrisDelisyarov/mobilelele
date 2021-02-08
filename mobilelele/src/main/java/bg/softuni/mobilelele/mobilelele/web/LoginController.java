package bg.softuni.mobilelele.mobilelele.web;

import bg.softuni.mobilelele.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.mobilelele.security.CurrentUser;
import bg.softuni.mobilelele.mobilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final CurrentUser currentUser;
    private final UserService userService;

    public LoginController(CurrentUser currentUser, UserService userService) {
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String showLogin(){
        return "auth-login";
    }

    @PostMapping("/users/login")

    public String login(UserLoginServiceModel model){
        if (userService.authenticate(model.getUsername(),model.getPassword())){
            userService.loginUser(model.getUsername());
            return "redirect:/";
        }
        return "redirect:/users/login";
    }


}
