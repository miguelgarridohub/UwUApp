package com.match.uwu.controllers.restcontrollers;

import com.match.uwu.dto.Users;
import com.match.uwu.services.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController("/")
public class MainController {

    @Autowired
    UsersServiceImpl usersService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> getUsers() {
        try {
            List<Users> usersList = usersService.findAll();
            return ResponseEntity.ok(usersList);
        } catch (Exception e) {
            throw e;
        }

    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Users> getUserById(@PathVariable(value = "id") int id) throws Exception {
        try {
            Users users = usersService.findById(id);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            throw e;
        }

    }


    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public ResponseEntity<String> postNewUser(@RequestBody Users user){
        try {
            usersService.createUser(user);
            return ResponseEntity.ok("Usuario " + user.getName() + " creado correctamente");
        } catch (Exception e) {
            throw e;
        }

    }
}
