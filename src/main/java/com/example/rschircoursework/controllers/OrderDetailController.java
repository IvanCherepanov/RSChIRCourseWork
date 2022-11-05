package com.example.rschircoursework.controllers;

import com.example.rschircoursework.model.entity.OrderDetail;
import com.example.rschircoursework.services.IOrderDetailService;
import com.example.rschircoursework.services.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/orderDetail")
public class OrderDetailController extends AbstractController<OrderDetail, IOrderDetailService>{
    private IOrderDetailService iOrderDetailService;
    private IOrderService iOrderService;

    protected OrderDetailController(IOrderDetailService service,
                                    IOrderDetailService iOrderDetailService,
                                    IOrderService iOrderService) {
        super(service);
        this.iOrderDetailService = iOrderDetailService;
        this.iOrderService = iOrderService;
    }

    @GetMapping("/list/{id}")
    public String readingAll(@PathVariable Long id, Model model) {
        model.addAttribute("order", iOrderService.findById(id));
        model.addAttribute("order_items", iOrderDetailService.getAllOrderDetailsByOrderId(id));
        System.out.println(456);
        return "order_detail";
    }

}
