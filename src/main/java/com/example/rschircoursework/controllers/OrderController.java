package com.example.rschircoursework.controllers;

import com.example.rschircoursework.model.entity.Item;
import com.example.rschircoursework.model.entity.Order;
import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.services.IItemService;
import com.example.rschircoursework.services.IOrderService;
import com.example.rschircoursework.services.IUserService;
import com.example.rschircoursework.services.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends AbstractController<Order, IOrderService> {
    private IOrderService iOrderService;
    private IUserService iUserService;
    private IItemService iItemService;

    protected OrderController(IOrderService service,
                              IOrderService iOrderService,
                              IUserService iUserService,
                              IItemService iItemService) {
        super(service);
        this.iItemService = iItemService;
        this.iOrderService = iOrderService;
        this.iUserService = iUserService;
    }

    @GetMapping("/list")
    public String readingAll(Model model) {
        model.addAttribute("orders", service.getAll());
        System.out.println(456);
        return "admin/admin-order";
    }

    @GetMapping("/new")
    public String createItem(Model model) {
        Order order = new Order();
        model.addAttribute("users", iUserService.getAll());
        model.addAttribute("order", order);
        return "admin/admin-order-add";

    }

    @PostMapping("/create")
    public String saveItem(@ModelAttribute("item") Order order) {
        order.setOrderTime(iOrderService.convertDateFromString(order.getInputDate()));
        service.create(order);
        return "redirect:/order/list";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        model.addAttribute("order", service.findById(id));
        return "admin/admin-order-edit";
    }

    @PostMapping("/{id}")
    public String updateItem(@PathVariable Long id,
                             @ModelAttribute("item") Order order) {
        Order existingOrder = service.findById(id);
        //existingOrder.setId(id);
        //existingOrder.setOrderTime();//iOrderService.convertDateFromString(order.getInputDate())
        //existingOrder.setUserId(order.getUserId());
        existingOrder.setCostOrder(order.getCostOrder());
        service.update(id, existingOrder);
        return "redirect:/order/list";
    }

    // handler method to handle delete student request

    @GetMapping("del/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/order/list";
    }

    @GetMapping("/owner")
    public String readingAllByUser(Authentication authentication, Model model) {
        String userRole = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName()))).getRole();
        Long userId = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName()))).getId();
        model.addAttribute("orders", service.getAllOrderByUserId(userId));
        model.addAttribute("userRole", userRole);
        System.out.println(456);
        return "order";
    }

}
