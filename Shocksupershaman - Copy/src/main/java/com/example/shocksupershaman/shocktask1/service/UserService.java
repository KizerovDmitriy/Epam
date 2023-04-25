package com.example.shocksupershaman.shocktask1.service;

import com.example.shocksupershaman.shocktask1.exception.UserNotFoundException;
import com.example.shocksupershaman.shocktask1.model.User;
import com.example.shocksupershaman.shocktask1.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final Map<String, User> db = new HashMap<>();
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return db.values().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(String id) {

        User user = db.get(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return userMapper.toDTO(user);
    }

    public UserDTO createUser(UserDTO user) {

        String id = generateId();
        user.setId(id);

        db.put(id, userMapper.toEntity(user));

        return user;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}