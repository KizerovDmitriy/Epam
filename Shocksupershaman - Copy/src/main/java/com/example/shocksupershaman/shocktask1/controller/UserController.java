package com.example.shocksupershaman.shocktask1.controller;

import com.example.shocksupershaman.shocktask1.model.User;
import com.example.shocksupershaman.shocktask1.model.UserDTO;
import com.example.shocksupershaman.shocktask1.exception.UserNotFoundException;
import com.example.shocksupershaman.shocktask1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOList = userService.getAllUsers();
        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        try {
            UserDTO user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        if (createdUser == null) {
            return ResponseEntity.badRequest().body("Something go wrong");
        }
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping("/vovanrylit")
    public ResponseEntity<String> vovanrylit() {
        return ResponseEntity.ok("Shock is the best elem shaman ever :)");
    }
}