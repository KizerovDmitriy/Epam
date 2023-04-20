package com.example.shocksupershaman.shocktask1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOList = userService.getAllUsers();
        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<UserDTO> user = userService.getUserById(id);
        return ResponseEntity.of(user);
    }

    @GetMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestParam String name,
                                             @RequestParam int age) {
        User user = userService.createUser(new User(name, age));
        if (user == null) {
            return ResponseEntity.badRequest().body("Something go wrong");
        }
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping("/vovanrylit")
    public String vovanrylit() {
        return "Shock is the best elem shaman ever :)";
    }
}