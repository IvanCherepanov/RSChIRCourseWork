package com.example.rschircoursework.model.dao;

import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends IAbstractRepository<Order>{
    List<Order> findAllByUserId(Long userId);
}
