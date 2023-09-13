package com.andres.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.booking.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
