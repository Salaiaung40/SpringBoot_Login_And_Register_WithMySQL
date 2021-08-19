package be.salai.springboot_login_and_register_withmysql.services;

import be.salai.springboot_login_and_register_withmysql.model.CustomUserDetailImpl;
import be.salai.springboot_login_and_register_withmysql.model.User;
import be.salai.springboot_login_and_register_withmysql.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRep userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepo.findByEmail(username);
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetailImpl(user);

//        return null;
    }

}
