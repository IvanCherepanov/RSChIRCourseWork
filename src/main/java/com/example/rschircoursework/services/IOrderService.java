package com.example.rschircoursework.services;

import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.model.entity.ShoppingBasket;

import java.time.LocalDateTime;

public interface IOrderService extends IAbstractService<Order>{
    LocalDateTime convertDateFromString(String dateString);

}
