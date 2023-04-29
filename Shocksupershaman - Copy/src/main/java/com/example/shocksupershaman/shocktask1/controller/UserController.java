package com.example.shocksupershaman.shocktask1.controller;

import com.example.shocksupershaman.shocktask1.model.UserDTO;
import com.example.shocksupershaman.shocktask1.service.ShockService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Qualifier("ShockServiceImpl")
    private final ShockService shockService;

    public UserController(ShockService shockService) {
        this.shockService = shockService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<UserDTO> userDTOList = shockService.getAllUsers();

        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {

        UserDTO user = shockService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Validated UserDTO user) {

        UserDTO createdUser = shockService.createUser(user);

        return ResponseEntity.ok(createdUser.getId());
    }

    @GetMapping("/vovanrylit")
    public ResponseEntity<String> vovanrylit() {

        return ResponseEntity.ok("Shock is the best elem shaman ever :)");
    }
}