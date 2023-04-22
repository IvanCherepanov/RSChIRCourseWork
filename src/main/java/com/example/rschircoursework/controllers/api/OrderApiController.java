package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.services.IItemService;
import com.example.rschircoursework.services.IOrderService;
import com.example.rschircoursework.services.IPetService;
import com.example.rschircoursework.services.IUserService;
import com.example.rschircoursework.services.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/order")
@CrossOrigin(origins = "http://localhost:3006")
public class OrderApiController extends AbstractController<Order, IOrderService> {
    private IOrderService iOrderService;
    private IUserService iUserService;
    private IItemService iItemService;
    private IPetService iPetService;

    protected OrderApiController(IOrderService service,
                                 IOrderService iOrderService,
                                 IUserService iUserService,
                                 IItemService iItemService,
                                 IPetService iPetService) {
        super(service);
        this.iItemService = iItemService;
        this.iOrderService = iOrderService;
        this.iUserService = iUserService;
        this.iPetService = iPetService;
    }

    @GetMapping("/list")
    public List<Order> readingAll() {
       return service.getAll();
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        order.setOrderTime(iOrderService.convertDateFromString(order.getInputDate()));
        return service.create(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id,
                             @RequestBody Order order) {
        Order existingOrder = service.findById(id);
        existingOrder.setCostOrder(order.getCostOrder());
        return service.update(id, existingOrder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getAllOrdersByUserId(@PathVariable Long userId) {
        return service.getAllOrderByUserId(userId);
    }

}
