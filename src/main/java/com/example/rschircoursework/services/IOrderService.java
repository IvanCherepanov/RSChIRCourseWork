package com.example.rschircoursework.services;

import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.model.entity.ShoppingBasket;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService extends IAbstractService<Order>{
    LocalDateTime convertDateFromString(String dateString);
    List<Order> getAllOrderByUserId(Long userId);
}
