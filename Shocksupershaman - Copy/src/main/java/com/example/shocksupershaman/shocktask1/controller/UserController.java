package com.example.shocksupershaman.shocktask1.controller;

import com.example.shocksupershaman.shocktask1.model.User;
import com.example.shocksupershaman.shocktask1.model.UserDTO;
import com.example.shocksupershaman.shocktask1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Validated User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/vovanrylit")
    public ResponseEntity<String> vovanrylit() {
        return ResponseEntity.ok("Shock is the best elem shaman ever :)");
    }
}