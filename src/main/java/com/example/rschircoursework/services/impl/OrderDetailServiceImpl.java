package com.example.rschircoursework.services.impl;

import com.example.rschircoursework.model.dao.IOrderDetailRepository;
import com.example.rschircoursework.model.dao.IOrderRepository;
import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.model.entity.OrderDetail;
import com.example.rschircoursework.services.IOrderDetailService;
import com.example.rschircoursework.services.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl
        extends AbstractServiceImpl<OrderDetail, IOrderDetailRepository>
        implements IOrderDetailService {
    private IOrderService iOrderService;
    private IOrderDetailRepository iOrderDetailRepository;
    protected OrderDetailServiceImpl(IOrderDetailRepository defaultDao,
                                     IOrderService iOrderService,
                                     IOrderDetailRepository iOrderDetailRepository) {
        super(defaultDao);
        this.iOrderDetailRepository = iOrderDetailRepository;
        this.iOrderService = iOrderService;
    }

    @Override
    public List<OrderDetail> getAllOrderDetailsByOrderId(Long orderId) {
        return iOrderDetailRepository.findOrderDetailsByOrderId(orderId);
    }
}
