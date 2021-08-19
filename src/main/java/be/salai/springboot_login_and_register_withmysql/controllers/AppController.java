package be.salai.springboot_login_and_register_withmysql.controllers;

import be.salai.springboot_login_and_register_withmysql.model.User;
import be.salai.springboot_login_and_register_withmysql.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    private UserRep repo;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage(Model model) {

        return "login";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegistering(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);
//        repo.existsById(user.getId());

        return "registerSuccess";
//        can be land direct to the profile setting page.
    }

    @GetMapping("user_login")
    public String userLogIn(User user) {
        repo.equals(user);

        return "index";
    }
    @GetMapping("/registerSuccess")
    public String SuccessPage(Model model) {

        return "registerSuccess";
    }

//    @RequestMapping
}

