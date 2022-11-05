package com.example.rschircoursework.model.dao;

import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.model.entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDetailRepository extends IAbstractRepository<OrderDetail>{
    List<OrderDetail> findOrderDetailsByOrderId(Long orderId);
}
