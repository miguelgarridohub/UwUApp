package com.match.uwu.services;

import com.match.uwu.dto.Users;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    List<Users> findAll();

    Users findById(int id) throws Exception;

    void createUser(Users users);
}
