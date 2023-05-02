package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.model.entity.OrderDetail;
import com.example.rschircoursework.services.IOrderDetailService;
import com.example.rschircoursework.services.IOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orderDetail")
@CrossOrigin(origins = {"http://frontpart:3000", "http://localhost:3000","http://frontpart:3006", "http://localhost:3006"})
public class OrderDetailApiController extends AbstractController<OrderDetail, IOrderDetailService> {
    private IOrderDetailService iOrderDetailService;
    private IOrderService iOrderService;

    protected OrderDetailApiController(IOrderDetailService service,
                                       IOrderDetailService iOrderDetailService,
                                       IOrderService iOrderService) {
        super(service);
        this.iOrderDetailService = iOrderDetailService;
        this.iOrderService = iOrderService;
    }

    @GetMapping("/list/{id}")
    public OrderDetailResponse getAllOrderDetailsByOrderId(@PathVariable Long id) {
        Order order_id = (iOrderService.findById(id));
        List<OrderDetail> orderItems = (iOrderDetailService.getAllOrderDetailsByOrderId(id));
        OrderDetailResponse response = new OrderDetailResponse(order_id, orderItems);
        return response;
    }

    // Define response object
    private static class OrderDetailResponse {
        private Order order;
        private List<OrderDetail> orderItems;

        public OrderDetailResponse(Order order, List<OrderDetail> orderItems) {
            this.order = order;
            this.orderItems = orderItems;
        }
// Getters and Setters

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public List<OrderDetail> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(List<OrderDetail> orderItems) {
            this.orderItems = orderItems;
        }
    }

}
