package com.example.shocksupershaman.shocktask1;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Data
@NoArgsConstructor
@Service
public class UserService {
    private final Map<Long, User> db = new HashMap<>();
    private static final AtomicLong COUNTER = new AtomicLong();

    public List<UserDTO> getAllUsers() {
        List<UserDTO> dtoList = new ArrayList<>();
        for (User user : db.values()) {
            dtoList.add(user.toDTO());
        }
        return dtoList;
    }

    public Optional<UserDTO> getUserById(Long id) {
        User user = db.get(id);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user.toDTO());
    }

    public User createUser(User user) {
        long id = generateId();
        user.setId(id);
        db.put(id, user);
        return user;
    }

    private long generateId() {
        return COUNTER.incrementAndGet();
    }
}