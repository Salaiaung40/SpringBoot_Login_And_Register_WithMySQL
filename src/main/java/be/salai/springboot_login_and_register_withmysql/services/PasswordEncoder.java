package be.salai.springboot_login_and_register_withmysql.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "salaiaung3";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
        //$2a$10$ABxEGxoB1O3dVYUUFlXXTe/N3ZnD0dxLVZnl4kTEALm02FQkgb0tW
    }
}
