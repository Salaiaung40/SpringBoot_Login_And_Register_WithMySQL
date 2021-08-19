package be.salai.springboot_login_and_register_withmysql.repositories;

import be.salai.springboot_login_and_register_withmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRep extends JpaRepository <User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

}
