package com.example.shocksupershaman.shocktask1.repository;

import com.example.shocksupershaman.shocktask1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, String> {

    User findUserById(String id);

}
