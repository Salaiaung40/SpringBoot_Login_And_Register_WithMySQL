package be.salai.springboot_login_and_register_withmysql.controllers;

import be.salai.springboot_login_and_register_withmysql.model.User;
import be.salai.springboot_login_and_register_withmysql.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public  String processRegistering (User user) {
        repo.save(user);

        return "registerSuccess";
//        can be land direct to the profile setting page.
}
}

