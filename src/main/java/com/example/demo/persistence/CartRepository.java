package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
