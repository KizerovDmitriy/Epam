package com.example.shocksupershaman;

import com.example.shocksupershaman.shocktask1.exception.UserNotFoundException;
import com.example.shocksupershaman.shocktask1.model.User;
import com.example.shocksupershaman.shocktask1.model.UserDTO;
import com.example.shocksupershaman.shocktask1.service.UserMapper;
import com.example.shocksupershaman.shocktask1.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testException() {

        assertEquals(0, userService.getAllUsers().size());
        assertThrows(UserNotFoundException.class, () -> userService.getUserById("1"));

    }

    @Test
    void testGetAllUsers() {

        List<UserDTO> users = createUsers();

        userService.createUser(users.get(0));
        userService.createUser(users.get(1));

        List<UserDTO> allUsers = userService.getAllUsers();

        assertEquals(2, allUsers.size());
        assertTrue(allUsers.contains(users.get(0)));
        assertTrue(allUsers.contains(users.get(1)));

    }

    @Test
    void testGetUserById() {

        List<UserDTO> users = createUsers();
        UserDTO createdUser = userService.createUser(users.get(0));
        users.get(0).setId(createdUser.getId());

        assertEquals(users.get(0), userService.getUserById(createdUser.getId()));
        assertEquals(users.get(0).getId(), userService.getUserById(createdUser.getId()).getId());
        assertEquals(users.get(0).getName(), userService.getUserById(createdUser.getId()).getName());
        assertEquals(users.get(0).getAge(), userService.getUserById(createdUser.getId()).getAge());

    }


    @Test
    void testCreateUser() {

        List<UserDTO> users = createUsers();
        UserDTO createdUserDTO = userService.createUser(users.get(0));

        assertEquals(users.get(0).getId(), createdUserDTO.getId());
        assertEquals(users.get(0).getName(), createdUserDTO.getName());
        assertEquals(users.get(0).getAge(), createdUserDTO.getAge());
        assertEquals(1, userService.getAllUsers().size());
        assertTrue(userService.getAllUsers().contains(createdUserDTO));

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