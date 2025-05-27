package ru.itis.dis301.lab2_10.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis301.lab2_10.model.User;
import ru.itis.dis301.lab2_10.repository.UserRepository;

@Service(value = "lab10UserDetailsServise")
public class UserDetailsServiseImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        if (user != null) {
            return new UserDetailImpl(user);
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
