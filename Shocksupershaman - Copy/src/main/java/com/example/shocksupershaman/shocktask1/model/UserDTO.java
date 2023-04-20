package com.example.shocksupershaman.shocktask1.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UserDTO {
    private String id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;

}