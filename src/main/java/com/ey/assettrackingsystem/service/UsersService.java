package com.ey.assettrackingsystem.service;

import com.ey.assettrackingsystem.entity.Users;
import com.ey.assettrackingsystem.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;


    public void saveUsers(Users users) {
        usersRepository.save(users);
    }

    public boolean authenticate(String email, String password) {
        Users user = usersRepository.findByEmail(email);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }
}
