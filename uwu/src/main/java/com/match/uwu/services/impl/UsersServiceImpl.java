package com.match.uwu.services.impl;

import com.match.uwu.services.UserService;
import com.match.uwu.dto.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UserService {

    private static List<Users> usersList = new ArrayList<>();

    static {
        usersList.add(new Users(1, "Miguel", "Male", 23));
        usersList.add(new Users(2, "Bianca", "Female", 26));
        usersList.add(new Users(3, "Jesus", "Male", 24));
    }

    @Override
    public List<Users> findAll() {
        return usersList;
    }

    @Override
    public Users findById(int id) throws Exception {
        try {
            Users user = usersList.stream()
                    .filter(us -> us.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new Exception("No se encuentra el usuario"));
            return user;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void createUser(Users user) {
        usersList.add(user);
    }
}
