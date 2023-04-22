package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.Item;
import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.services.IItemService;
import com.example.rschircoursework.services.IItemTypeService;
import com.example.rschircoursework.services.IPetService;
import com.example.rschircoursework.services.IUserService;
import com.example.rschircoursework.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "http://localhost:3006")
public class UserApiController extends AbstractController<User, IUserService> {
    private IPetService iPetService;
    private IUserService iUserService;
    private IItemTypeService iItemTypeService;
    private IItemService iItemService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    protected UserApiController(IUserService service, IPetService iPetService,
                                IUserService iUserService, IItemTypeService iItemTypeService,
                                IItemService iItemService) {
        super(service);
        this.iPetService = iPetService;
        this.iUserService = iUserService;
        this.iItemService = iItemService;
        this.iItemTypeService = iItemTypeService;
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getProducts(//Authentication authentication,
                                  @RequestParam(name = "pId", required = false) Long petId,
                                  @RequestParam(name = "pTId", required = false) Long productTypeId,
                                  @RequestParam(name = "sId", required = false) Integer sortId) {
        Long IpetId = (petId == null) ? 0 : petId;
        Long IproductTypeId = (productTypeId == null) ? 0 : productTypeId;
        List<Item> items;

        if (IpetId == 0 && IproductTypeId == 0) {
            items = iItemService.getAllSorting(sortId, iItemService.getAll());
        } else if (IpetId == 0 && IproductTypeId != 0) {
            items = iItemService.getAllSorting(sortId, iItemService.getItemByItemType(productTypeId));
        } else if (IpetId != 0 && IproductTypeId == 0) {
            items = iItemService.getAllSorting(sortId, iItemService.getItemByPetId(petId));
        } else {
            items = iItemService.getAllSorting(sortId, iItemService.getItemByPetIdAndTypeId(petId, productTypeId));
        }

        return items;
    }

    @GetMapping("/list")
    public List<User> getAllUsers() { //Authentication authentication
        return service.getAll();
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        service.create(user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User existingUser = iUserService.findById(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        return service.update(id, existingUser);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);

    }
}
