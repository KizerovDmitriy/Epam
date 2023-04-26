package com.example.shocksupershaman.shocktask1.service;

import com.example.shocksupershaman.shocktask1.model.UserDTO;

import java.util.List;
import java.util.UUID;

public interface ShockService {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(String id);
    UserDTO createUser(UserDTO user);

    default String generateId() {
        return UUID.randomUUID().toString();
    }
}
