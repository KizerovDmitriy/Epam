package com.example.shocksupershaman.shocktask1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;

}