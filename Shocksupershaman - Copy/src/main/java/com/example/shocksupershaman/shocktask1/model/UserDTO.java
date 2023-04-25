package com.example.shocksupershaman.shocktask1.model;

import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force = true)
public class UserDTO {

    private String id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;

}