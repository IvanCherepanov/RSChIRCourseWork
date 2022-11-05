package com.example.rschircoursework.services.impl;

import com.example.rschircoursework.model.dao.IOrderRepository;
import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.services.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order, IOrderRepository> implements IOrderService {
    protected OrderServiceImpl(IOrderRepository defaultDao) {
        super(defaultDao);
    }

    @Override
    public LocalDateTime convertDateFromString(String dateString) {
        dateString = dateString.replace("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return dateTime;
    }
}
