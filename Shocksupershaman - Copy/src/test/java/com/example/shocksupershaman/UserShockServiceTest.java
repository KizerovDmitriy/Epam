package com.example.shocksupershaman;

import com.example.shocksupershaman.shocktask1.exception.UserNotFoundException;
import com.example.shocksupershaman.shocktask1.model.User;
import com.example.shocksupershaman.shocktask1.model.UserDTO;
import com.example.shocksupershaman.shocktask1.repository.Repository;
import com.example.shocksupershaman.shocktask1.service.ShockServiceImpl;
import com.example.shocksupershaman.shocktask1.service.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserShockServiceTest {

    @Mock
    private UserMapper userMapper;
    @Mock
    private Repository repository;
    @InjectMocks
    private ShockServiceImpl shockService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testException() {

        List<User> users = new ArrayList<>();

        when(repository.findAll()).thenReturn(users);

        assertEquals(0, shockService.getAllUsers().size());
        assertThrows(UserNotFoundException.class, () -> shockService.getUserById("1"));

    }

    @Test
     void testGetAllUsers() {

        List<User> users = createUsers().stream()
                .map(userMapper::toEntity)
                .collect(Collectors.toList());

        when(repository.findAll()).thenReturn(users);

        List<UserDTO> expectedUserDTOs = createUsers();

        when(userMapper.toDTO(users.get(0))).thenReturn(expectedUserDTOs.get(0));
        when(userMapper.toDTO(users.get(1))).thenReturn(expectedUserDTOs.get(1));

        List<UserDTO> actualUserDTOs = shockService.getAllUsers();

        assertEquals(expectedUserDTOs, actualUserDTOs);
    }

    @Test
    public void testGetUserById() {
        String id = "1";

        User user = new User();
        UserDTO expectedUserDTO = new UserDTO();

        user.setId(id);
        user.setName("fenix");
        user.setAge(32);

        expectedUserDTO.setId(id);
        expectedUserDTO.setName("fenix");
        expectedUserDTO.setAge(32);

        when(repository.findUserById(id)).thenReturn(user);
        when(userMapper.toDTO(user)).thenReturn(expectedUserDTO);

        UserDTO actualUserDTO = shockService.getUserById(id);

        assertEquals(expectedUserDTO, actualUserDTO);
    }


    @Test
    void testCreateUser() {

        List<UserDTO> users = createUsers();

        User user = userMapper.toEntity(users.get(0));
        UserDTO userDTO = users.get(0);

        Mockito.when(repository.save(user)).thenReturn(user);

        UserDTO createdUserDTO = shockService.createUser(userDTO);

        assertEquals(users.get(0).getId(), createdUserDTO.getId());
        assertEquals(users.get(0).getName(), createdUserDTO.getName());
        assertEquals(users.get(0).getAge(), createdUserDTO.getAge());

    }

    private List<UserDTO> createUsers() {

        List<UserDTO> users = new ArrayList<>();
        UserDTO user1DTO = new UserDTO();
        user1DTO.setName("fenix");
        user1DTO.setAge(32);

        User user1 = new User();
        user1.setName("fenix");
        user1.setAge(32);

        UserDTO user2DTO = new UserDTO();
        user2DTO.setName("shock");
        user2DTO.setAge(31);

        User user2 = new User();
        user2.setName("shock");
        user2.setAge(31);

        when(userMapper.toEntity(user1DTO)).thenReturn(user1);
        when(userMapper.toEntity(user2DTO)).thenReturn(user2);

        when(userMapper.toDTO(user1)).thenReturn(user1DTO);
        when(userMapper.toDTO(user2)).thenReturn(user2DTO);

        users.add(user1DTO);
        users.add(user2DTO);

        return users;
    }
}