package be.salai.springboot_login_and_register_withmysql;


import be.salai.springboot_login_and_register_withmysql.model.User;
import be.salai.springboot_login_and_register_withmysql.repositories.UserRep;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepTest {

    @Autowired
    private UserRep repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("salai2@gmail.com");
        user.setPassword("salai2");
        user.setFirstName("Salai2");
        user.setLastName("Aung");

        User savedUser =  repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat (existUser.getEmail()).isEqualTo(user.getEmail());

    }
    @Test
    public void testFindUserByEmail(){
        String email = "salai1@gmail.com";
        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();

    }
}
