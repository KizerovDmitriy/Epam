package com.example.shocksupershaman.shocktask1;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserDTO toDTO() {
        return UserDTO.of(name, age);
    }
}