package com.example.shocksupershaman.shocktask1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserDTO toDTO() {
        return UserDTO.builder()
                .id(id)
                .name(name)
                .age(age)
                .build();
    }
}