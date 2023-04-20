package com.example.shocksupershaman.shocktask1.service;

import com.example.shocksupershaman.shocktask1.exception.UserCreateException;
import com.example.shocksupershaman.shocktask1.exception.UserNotFoundException;
import com.example.shocksupershaman.shocktask1.model.User;
import com.example.shocksupershaman.shocktask1.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Map<String, User> db = new HashMap<>();
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

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

    public User createUser(User user) {

        if (user == null) {
            throw new UserCreateException();
        }

        String id = generateId();
        user.setId(id);

        db.put(id, user);

        return user;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}