package com.jennilyn.services;

import com.jennilyn.interfaces.UserRepository;
import com.jennilyn.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByUsername(s);

        if (user == null){
            throw new UsernameNotFoundException("Username or Password are incorrect.");
        }

        return user;
    }
}
