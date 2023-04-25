package com.example.shocksupershaman.shocktask1;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String name;
    private int age;

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static UserDTO of(String name, int age) {
        return new UserDTO(name, age);
    }
}