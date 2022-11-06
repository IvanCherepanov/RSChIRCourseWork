package com.example.rschircoursework.services.impl;

import com.example.rschircoursework.model.dao.IShoppingBasketRepository;
import com.example.rschircoursework.model.entity.Item;
import com.example.rschircoursework.model.entity.ShoppingBasket;
import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.services.IItemService;
import com.example.rschircoursework.services.IShoppingBasketService;
import com.example.rschircoursework.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ShoppingBasketServiceImpl extends AbstractServiceImpl<ShoppingBasket, IShoppingBasketRepository> implements IShoppingBasketService {
    private IShoppingBasketRepository iShoppingBasketRepository;
    private IItemService iItemService;
    private IUserService iUserService;

    @Autowired
    protected ShoppingBasketServiceImpl(IShoppingBasketRepository defaultDao,
                                        IItemService iItemService,
                                        IUserService iUserService) {
        super(defaultDao);
        this.iShoppingBasketRepository = defaultDao;
        this.iItemService = iItemService;
        this.iUserService = iUserService;
    }

    @Override
    public ShoppingBasket update(Long id, ShoppingBasket entity) {
        findById(id);
        entity.setId(id);
        return create(entity);
    }

    @Override
    public ShoppingBasket getShoppingBasketByUserIdAndItemId(Long userId, Long itemId) {
        return iShoppingBasketRepository.findShoppingBasketByUserIdAndItemId(userId, itemId);
    }

    @Override
    public ShoppingBasket getShoppingBasketByIdAndUserId(Long addId, Long userId) {
        return iShoppingBasketRepository.findShoppingBasketByIdAndUserId(addId, userId);
    }

    @Override
    public List<ShoppingBasket> getItemByUserId(Long userId) {
        return iShoppingBasketRepository.findAllByUserId(userId);
    }

    @Override
    public void deleteAllByUserId(Long userId) {
        iShoppingBasketRepository.deleteAllByUserId(userId);
    }

    @Override
    public int getTotalPrice(List<ShoppingBasket> purchases) {
        int result = 0;
        for (ShoppingBasket purchase : purchases) {
            result += (iItemService.findById(purchase.getItemId())).getCost()
                    * (1 - 0.01 * iItemService.findById(purchase.getItemId()).getBrand().getSale())
                    * purchase.getAmount();
        }
        return result;
    }

    @Override
    public String createMessageForUser(List<ShoppingBasket> userPurchases, Long userId) {
        String userName = iUserService.findById(userId).getUsername();
        List<Item> userProducts = new ArrayList<>();
        for (ShoppingBasket purchase : userPurchases) {
            userProducts.add(purchase.getItem());
        }
        String result = "Здравствуйте, " + userName + ", ваш заказ:<br>";
        result = getStringOrder(userPurchases, userProducts, result);
        result += "Ждите звонка менеджера.";
        return result;
    }

    @Override
    public String createMessageForManager(User user,
                                           String address,
                                           String telephone,
                                           List<ShoppingBasket> userPurchases) {
        List<Item> userProducts = new ArrayList<>();
        for (ShoppingBasket purchase : userPurchases) {
            userProducts.add(purchase.getItem());
        }

        String result = "Информация о заказчике:<br>";
        result += "Почта: " + user.getEmail() + "<br>";
        result += "Имя пользователя: " + user.getUsername() + "<br>";
        result += "Телефон: " + telephone + "<br>";
        result += "Адрес: " + address + "<br>";
        result += "____________________________<br>";
        result += "Заказ:<br>";
        result = getStringOrder(userPurchases, userProducts, result);
        return result;
    }

    // TODO: 06.11.2022 добавить для письма скидку
    private String getStringOrder(List<ShoppingBasket> userPurchases, List<Item> userProducts, String result) {
        for (int i = 0; i < userProducts.size(); i++) {
            result +=
                    (i + 1) + ") " +
                            userProducts.get(i).getItemName() +
                            " (Количество: " +
                            userPurchases.get(i).getAmount() +
                            ", Стоимость: " +
                            (userProducts.get(i).getCost() * userPurchases.get(i).getAmount())
                            + " р.)" +
                            ", Цена по скидке: " +
                            (userProducts.get(i).getCost() * 0.01 * (100 - userProducts.get(i).getBrand().getSale()) * userPurchases.get(i).getAmount())
                            + " р.)" +
                            "<br>";
        }
        result += "Общая стоимость: " + getTotalPrice(userPurchases) + " р.<br>";
        return result;
    }
}
