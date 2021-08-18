package be.salai.springboot_login_and_register_withmysql.repositories;

import be.salai.springboot_login_and_register_withmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository <User, Long> {
}
