package com.example.rschircoursework.services;

import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.model.entity.OrderDetail;

import java.util.List;

public interface IOrderDetailService extends IAbstractService<OrderDetail>{
    List<OrderDetail> getAllOrderDetailsByOrderId(Long orderId);
}
