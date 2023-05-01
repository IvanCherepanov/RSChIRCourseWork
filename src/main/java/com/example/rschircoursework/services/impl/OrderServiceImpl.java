package com.example.rschircoursework.services.impl;

import com.example.rschircoursework.model.dao.IOrderRepository;
import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.services.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order, IOrderRepository> implements IOrderService {
    private IOrderRepository iOrderRepository;
    protected OrderServiceImpl(IOrderRepository defaultDao,
                               IOrderRepository iOrderRepository) {
        super(defaultDao);
        this.iOrderRepository = iOrderRepository;
    }

    @Override
    public LocalDateTime convertDateFromString(String dateString) {
        //System.out.println("dateString usual" + dateString);
        dateString = dateString.replace("T", " ");
        //System.out.println("dateString usual converted" + dateString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return dateTime;
    }

    @Override
    public List<Order> getAllOrderByUserId(Long userId) {
        return iOrderRepository.findAllByUserId(userId);
    }
}
