package ru.itis.dis301.lab2_10.repository;

import org.springframework.stereotype.Repository;
import ru.itis.dis301.lab2_10.model.User;

@Repository
public class UserRepository {
    public User findByUserName(String username) {
        if (username.equals("admin")) {
            return User.builder()
                    .id(1l)
                    .userName("admin")
                    .password("$2a$10$La3VwUXYS/x0D4TbTofepuKsYqVD/D55sESz0K.7JTMi4S/jqGin2")
                    .role("ADMIN").build();
        } else if (username.equals("user")) {
            return User.builder()
                    .id(2l)
                    .userName("user")
                    .password("$2a$10$ZgiZNA1WWchQ9yLkUxeIJ.DHIVVqEPnFsk5chlj86f2aW1B.mzykm")
                    .role("USER").build();
        } else {
            return null;
        }
    }
}
