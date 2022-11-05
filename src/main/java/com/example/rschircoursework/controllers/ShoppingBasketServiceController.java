package com.example.rschircoursework.controllers;

import com.example.rschircoursework.model.entity.*;
import com.example.rschircoursework.model.enumerations.MyValues;
import com.example.rschircoursework.services.*;
import com.example.rschircoursework.services.impl.EmailService;
import com.example.rschircoursework.services.impl.UserServiceImpl;
import org.hibernate.type.LocalDateTimeType;
import org.hibernate.type.LocalDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(value = "/shopping_basket")
public class ShoppingBasketServiceController extends AbstractController<ShoppingBasket, IShoppingBasketService> {
    private IItemService iItemService;
    private IUserService iUserService;
    private IPetService iPetService;
    private IShoppingBasketService iShoppingBasketService;
    private IOrderService iOrderService;
    private IOrderDetailServer iOrderDetailServer;
    private EmailService emailService;

    @Autowired
    protected ShoppingBasketServiceController(IShoppingBasketService service,
                                              IItemService iItemService,
                                              IUserService iUserService,
                                              IPetService iPetService,
                                              IShoppingBasketService iShoppingBasketService,
                                              IOrderService iOrderService,
                                              IOrderDetailServer iOrderDetailServer,
                                              EmailService emailService) {
        super(service);
        this.iItemService = iItemService;
        this.iUserService = iUserService;
        this.iPetService = iPetService;
        this.iShoppingBasketService = iShoppingBasketService;
        this.iOrderService = iOrderService;
        this.iOrderDetailServer = iOrderDetailServer;
        this.emailService = emailService;
    }

    @PostMapping("/addPurchase")
    public String addPurchase(Authentication authentication,
                                    final RedirectAttributes redirectAttributes,
                                    @RequestParam Long id,
                                    @RequestParam int count,
                                    Model model) {
        String userRole = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName()))).getRole();
        if (userRole == "GUEST") {
            model.addAttribute("Status", "user_guest");
            redirectAttributes.addFlashAttribute("Status", "user_guest");
        }
        else {
            Long userId = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName()))).getId();
            ShoppingBasket shoppingBasket =  iShoppingBasketService.getShoppingBasketByUserIdAndItemId(userId, id);
            if (shoppingBasket == null) {
                ShoppingBasket newPurchase = new ShoppingBasket();
                newPurchase.setUserId(userId);
                newPurchase.setItemId(id);
                newPurchase.setAmount(count);
                iShoppingBasketService.create(newPurchase);
                model.addAttribute("Status", "OK");
                redirectAttributes.addAttribute("Status", "OK");
            }
            else {
                shoppingBasket.setAmount(shoppingBasket.getAmount()+count);
                iShoppingBasketService.create(shoppingBasket);
                model.addAttribute("Status", "OK");
                redirectAttributes.addAttribute("Status", "OK");
            }
        }
        return "redirect:/shopping_basket/purchases";
    }

    @GetMapping("/purchases")
    public String purchases(Authentication authentication, Model model) {
        String userRole = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName()))).getRole();
        Long userId = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName()))).getId();
        model.addAttribute("totalPrice", iShoppingBasketService.getTotalPrice(iShoppingBasketService.getItemByUserId(userId)));
        model.addAttribute("userRole", userRole);
        model.addAttribute("userName", authentication.getName());
        model.addAttribute("pets", iPetService.getAll());
        model.addAttribute("purchases", iShoppingBasketService.getItemByUserId(userId));
        model.addAttribute("productsService", iItemService);
        return "basket";
    }

    @GetMapping(value = "/changePurchases/{purchaseId}")
    public String deletePurchase(Authentication authentication, @PathVariable Long purchaseId,  Model model) {
        Long userId = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName()))).getId();
        if (iShoppingBasketService.getShoppingBasketByIdAndUserId(purchaseId, userId) != null) {
            iShoppingBasketService.delete(purchaseId);
        }
        return "redirect:/shopping_basket/purchases";
    }

    @PostMapping("/changeAmountPurchases")
    public String updatePurchase(Authentication authentication,
                                 @RequestParam(name = "purchaseId") Long id,
                                 @RequestParam(name = "amount") Integer amount,
                             Model model) {
        Long userId = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName()))).getId();
        if (iShoppingBasketService.getShoppingBasketByIdAndUserId(id, userId) != null) {
            ShoppingBasket shoppingBasket = iShoppingBasketService.getShoppingBasketByIdAndUserId(id, userId);
            shoppingBasket.setAmount(amount);
            iShoppingBasketService.create(shoppingBasket);
        }
        return "redirect:/shopping_basket/purchases";
    }

    @PostMapping(value = "/sendPurchases")
    public String sendPurchases(Authentication authentication,
                                @RequestParam(value="address") String address,
                                @RequestParam(value="telephone") String telephone) {
        User user = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName())));
        String userMessage = iShoppingBasketService.
                createMessageForUser(iShoppingBasketService.
                        getItemByUserId(user.getId()), user.getId());
        String managerMessage = iShoppingBasketService.createMessageForManager(
                user,
                address,
                telephone,
                iShoppingBasketService.
                        getItemByUserId(user.getId()));

        System.out.println("the letter is send");

        Order order = new Order();
        order.setUserId(user.getId());
        order.setOrderTime(LocalDateTime.now());
        order.setCostOrder(
                iShoppingBasketService.getTotalPrice(
                        iShoppingBasketService.getItemByUserId(
                                user.getId()
                        )));

        iOrderService.create(order);

        List<ShoppingBasket> tempList = iShoppingBasketService.getItemByUserId(user.getId());
        for (ShoppingBasket shoppingBasket: tempList) {
            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setOrderId(order.getId());
            orderDetail.setItemId(shoppingBasket.getItemId());
            orderDetail.setAmount(shoppingBasket.getAmount());

            iOrderDetailServer.create(orderDetail);
        }

        //emailService.sendmail(user.getEmail(), userMessage);
        //emailService.sendmail(MyValues.EMAILMENEGER, managerMessage);
        iShoppingBasketService.deleteAllByUserId(user.getId());
        return "redirect:/shopping_basket/purchases";
    }

}
