package bg.softuni.mobilelele.mobilelele.web;

import bg.softuni.mobilelele.mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.mobilelele.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.mobilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService){

        this.userService = userService;
    }
    @ModelAttribute("userModel")
    public UserRegisterServiceModel userModel(){
        return new UserRegisterServiceModel();
    }

    @GetMapping("/register")
    public String getRegister(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserRegisterServiceModel userModel, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
            if (bindingResult.hasErrors()){
                redirectAttributes.addFlashAttribute("userModel", userModel);
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
                return "redirect:/users/register";
            }
            userService.registerUser(userModel);
        return "redirect:/users/login";
    }
}
