package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.*;
import com.example.rschircoursework.model.enumerations.MyValues;
import com.example.rschircoursework.services.*;
import com.example.rschircoursework.services.impl.EmailService;
import com.example.rschircoursework.services.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.sun.activation.registries.LogSupport.log;

@Slf4j
@RestController
@RequestMapping(value = "/api/shopping_basket")
@CrossOrigin(origins = {"http://frontpart:3000", "http://localhost:3000","http://frontpart:3006", "http://localhost:3006","http://51.250.100.37:3000"})
public class ShoppingBasketServiceApiController extends AbstractController<ShoppingBasket, IShoppingBasketService> {
    private IItemService iItemService;
    private IUserService iUserService;
    private IPetService iPetService;
    private IShoppingBasketService iShoppingBasketService;
    private IOrderService iOrderService;
    private IOrderDetailService iOrderDetailServer;
    private EmailService emailService;

    @Autowired
    protected ShoppingBasketServiceApiController(IShoppingBasketService service,
                                                 IItemService iItemService,
                                                 IUserService iUserService,
                                                 IPetService iPetService,
                                                 IShoppingBasketService iShoppingBasketService,
                                                 IOrderService iOrderService,
                                                 IOrderDetailService iOrderDetailServer,
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
    public String addPurchase(@RequestBody ShoppingBasketRequest request) {
        var userId = request.getUserId();
        System.out.println(request);
        System.out.println(userId);
        var id = request.getId();
        var count = request.getCount();
        String userRole = "ADMIN";
        if (userRole.equals("GUEST")) {
            return "user_guest";
        } else {

            ShoppingBasket shoppingBasket = iShoppingBasketService.getShoppingBasketByUserIdAndItemId(userId, id);
            if (shoppingBasket == null) {
                ShoppingBasket newPurchase = new ShoppingBasket();
                newPurchase.setUserId(userId);
                newPurchase.setItemId(id);
                newPurchase.setAmount(count);
                iShoppingBasketService.create(newPurchase);
                return "OK";
            } else {
                shoppingBasket.setAmount(shoppingBasket.getAmount() + count);
                iShoppingBasketService.create(shoppingBasket);
                return "OK";
            }
        }
    }

    public static class ShoppingBasketRequest {
        private Long userId;
        private Long id;
        private int count;

        // Конструкторы
        public ShoppingBasketRequest() {
        }

        public ShoppingBasketRequest(Long userId, Long id, int count) {
            this.userId = userId;
            this.id = id;
            this.count = count;
        }

        // Геттеры и сеттеры
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getShoppingBasket(@RequestParam Long userId) {
        List<ShoppingBasket> shoppingBasketItems = iShoppingBasketService.getItemByUserId(userId);
        if (shoppingBasketItems.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        } else {
            List<ShoppingBasketResponse> responseList = new ArrayList<>();
            for (ShoppingBasket item : shoppingBasketItems) {
                Item itemEntity = iItemService.findById(item.getItemId());
                ShoppingBasketResponse response = new ShoppingBasketResponse();
                response.setItemId(item.getItemId());
                response.setItemName(itemEntity.getItemName());
                response.setAmount(item.getAmount());
                response.setPrice(itemEntity.getCost());
                response.setTotalPrice(itemEntity.getCost() * item.getAmount());

                responseList.add(response);
            }
            return ResponseEntity.ok(responseList);
        }

    }

    public static class ShoppingBasketRequestGet {
        private Long userId;

        // Конструкторы
        public ShoppingBasketRequestGet() {
        }

        public ShoppingBasketRequestGet(Long userId) {
            this.userId = userId;
        }

        // Геттеры и сеттеры
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    private static class ShoppingBasketResponse {
        private Long itemId;
        private String itemName;
        private Integer amount;
        private int price;
        private int totalPrice;

        // Getters and Setters

        public Long getItemId() {
            return itemId;
        }

        public void setItemId(Long itemId) {
            this.itemId = itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
        }
    }


    @DeleteMapping("/remove")
    public String removeFromShoppingBasket(@RequestParam Long itemId, @RequestParam Long userId) {
        ShoppingBasketServiceApiController.log.info("{}, {}", itemId, userId);
        ShoppingBasket shoppingBasket = iShoppingBasketService.getShoppingBasketByUserIdAndItemId(userId, itemId);
        var purchaseId = 0;
        System.out.println(shoppingBasket.toString());
        if (shoppingBasket != null && shoppingBasket.getUserId().equals(userId)) {

            iShoppingBasketService.delete(shoppingBasket.getId());
            return "OK";
        } else {
            return "error";
        }
    }

    @PostMapping("/changeAmountPurchases")
    public String updatePurchase(@RequestBody UpdatePurchaseRequest request) {
        var id = request.getId();
        var userId = request.getUserId();
        var amount = request.getAmount();
        ShoppingBasketServiceApiController.log.info(
                "{}, {}, {}, {}, {}, {}",
                id, id.getClass(), userId,userId.getClass(), amount, amount.getClass());
        System.out.println(iShoppingBasketService.getShoppingBasketByUserIdAndItemId(userId, id));
        if (iShoppingBasketService.getShoppingBasketByUserIdAndItemId(userId, id) != null) {
            ShoppingBasket shoppingBasket = iShoppingBasketService.getShoppingBasketByUserIdAndItemId(userId, id);
            shoppingBasket.setAmount(amount);
            iShoppingBasketService.create(shoppingBasket);
            return ("Purchase amount updated successfully.");
        } else {
            return ("Failed to update purchase amount.");
        }
    }

    public static class UpdatePurchaseRequest {
        private Long userId;
        private Long id;
        private Integer amount;

        public UpdatePurchaseRequest() {
        }

        public UpdatePurchaseRequest(Long userId, Long id, Integer amount) {
            this.userId = userId;
            this.id = id;
            this.amount = amount;
        }

        // Геттеры и сеттеры для полей userId, id, и amount

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }
    }


    @PostMapping("/sendPurchases")
    public String sendPurchases(@RequestParam(value = "userId") Long userId,
                                @RequestParam(value = "address") String address,
                                    @RequestParam(value = "telephone") String telephone) {
        try{
            User user = iUserService.findById(userId);
    //        User user = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(authentication.getName())));
            String userMessage = iShoppingBasketService.createMessageForUser(iShoppingBasketService.getItemByUserId(user.getId()), user.getId());
            String managerMessage = iShoppingBasketService.createMessageForManager(user, address, telephone, iShoppingBasketService.getItemByUserId(user.getId()));

            Order order = new Order();
            order.setUserId(user.getId());
            order.setOrderTime(LocalDateTime.now());
            order.setCostOrder(iShoppingBasketService.getTotalPrice(iShoppingBasketService.getItemByUserId(user.getId())));
            iOrderService.create(order);

            List<ShoppingBasket> tempList = iShoppingBasketService.getItemByUserId(user.getId());
            for (ShoppingBasket shoppingBasket : tempList) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(order.getId());
                orderDetail.setItemId(shoppingBasket.getItemId());
                orderDetail.setAmount(shoppingBasket.getAmount());
                iOrderDetailServer.create(orderDetail);
            }

            emailService.sendmail(user.getEmail(), userMessage);
            emailService.sendmail(MyValues.EMAILMENEGER, managerMessage);
            iShoppingBasketService.deleteAllByUserId(user.getId());
            return "Purchases sent successfully.";
        } catch (Exception e) {
            // Обработка ошибок
            log("Error sending purchases: " + e.getMessage());
            return "Error";
        }
    }
}

