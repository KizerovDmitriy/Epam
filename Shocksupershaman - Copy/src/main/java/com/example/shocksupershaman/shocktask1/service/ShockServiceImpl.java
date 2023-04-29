package com.example.shocksupershaman.shocktask1.service;

import com.example.shocksupershaman.shocktask1.exception.UserNotFoundException;
import com.example.shocksupershaman.shocktask1.model.User;
import com.example.shocksupershaman.shocktask1.model.UserDTO;
import com.example.shocksupershaman.shocktask1.repository.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class ShockServiceImpl implements ShockService{

    private final UserMapper userMapper;
    private final Repository repository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {

        return repository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserById(String id) {

        User user = repository.findUserById(id);

        if (user == null)
            throw new UserNotFoundException();

        return userMapper.toDTO(user);

    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO user) {

        User userToEntity = userMapper.toEntity(user);
        userToEntity.setId(generateId());

        repository.save(userToEntity);

        return user;

    }
}