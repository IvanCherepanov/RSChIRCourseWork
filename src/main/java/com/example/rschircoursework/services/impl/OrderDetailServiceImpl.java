package com.example.rschircoursework.services.impl;

import com.example.rschircoursework.model.dao.IOrderDetailRepository;
import com.example.rschircoursework.model.dao.IShoppingBasketRepository;
import com.example.rschircoursework.model.entity.OrderDetail;
import com.example.rschircoursework.model.entity.ShoppingBasket;
import com.example.rschircoursework.services.IOrderDetailServer;
import com.example.rschircoursework.services.IOrderService;
import com.example.rschircoursework.services.IShoppingBasketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailServiceImpl
        extends AbstractServiceImpl<OrderDetail, IOrderDetailRepository>
        implements IOrderDetailServer {
    protected OrderDetailServiceImpl(IOrderDetailRepository defaultDao) {
        super(defaultDao);
    }
}
