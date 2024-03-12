package pl.michalboguski.HMS.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    AutenticationService autenticationService;

    @GetMapping("")
    public String displayRegisterPage(){
        return "register";
    }

    @PostMapping("")
    public String procesRegistration(RegisterDto registerDto){
        autenticationService.registerUser(registerDto.getUsername(),registerDto.getPassword());

        return "redirect:/index";
    }
}
