package com.example.shocksupershaman.shocktask1.service;

import com.example.shocksupershaman.shocktask1.model.User;
import com.example.shocksupershaman.shocktask1.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDTO toDTO(User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());

        return userDTO;
    }

    /*

    public User toEntity(UserDTO userDTO) {

        User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());

        return user;
    }

     */
}
