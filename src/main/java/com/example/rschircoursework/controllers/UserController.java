package com.example.rschircoursework.controllers;

import com.example.rschircoursework.model.entity.Item;
import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.services.IItemService;
import com.example.rschircoursework.services.IItemTypeService;
import com.example.rschircoursework.services.IPetService;
import com.example.rschircoursework.services.IUserService;
import com.example.rschircoursework.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

@Controller
@RequestMapping(value = "/user")
public class UserController extends AbstractController<User, IUserService> {
    private IPetService iPetService;
    private IUserService iUserService;
    private IItemTypeService iItemTypeService;
    private IItemService iItemService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    protected UserController(IUserService service, IPetService iPetService,
                             IUserService iUserService, IItemTypeService iItemTypeService,
                             IItemService iItemService) {
        super(service);
        this.iPetService = iPetService;
        this.iUserService = iUserService;
        this.iItemService = iItemService;
        this.iItemTypeService = iItemTypeService;
    }

    @GetMapping("/home")
    public String getHome(Authentication authentication,
                          Model model) {
        model.addAttribute("userTypeRole", iUserService.getUserRole(authentication));
        return "index";
    }

    @GetMapping("/admin")
    public String getAdmin(Authentication authentication,
                          Model model) {
        model.addAttribute("userTypeRole", iUserService.getUserRole(authentication));
        return "admin/admin-start";
    }

    @GetMapping("/products")
    public String products(Authentication authentication,
                           @RequestParam(name = "pId", required = false) Long IpetId,
                           @RequestParam(name = "pTId", required = false) Long IproductTypeId,
                           @RequestParam(name = "sId", required = false) Integer sortId,
                           Model model) {
        model.addAttribute("userRole", iUserService.getUserRole(authentication));
        model.addAttribute("userId", iUserService.getUserId(authentication));
        Long petId = (IpetId == null) ? 0 : IpetId;
        Long productTypeId = (IproductTypeId == null) ? 0 : IproductTypeId;

        model.addAttribute("pets", iPetService.getAll());
        //iPetService.getAll().stream().forEach(x -> System.out.println(x.getPetName()));
        model.addAttribute("pId", petId);
        model.addAttribute("pTId", productTypeId);
        model.addAttribute("types", iItemTypeService.getAll());

        if (petId == 0 && productTypeId == 0) {
            model.addAttribute("items", iItemService.getAllSorting(sortId, iItemService.getAll()));
        }
        else if (petId == 0 && productTypeId != 0) {
            model.addAttribute("items",iItemService.getAllSorting(sortId, iItemService.getItemByItemType(productTypeId)));
        }
        else if (petId != 0 && productTypeId == 0) {
            model.addAttribute("items", iItemService.getAllSorting(sortId,iItemService.getItemByPetId(petId)));
        } else {
            model.addAttribute("items", iItemService.getAllSorting(sortId,iItemService.getItemByPetIdAndTypeId(petId, productTypeId)));
        }
        model.addAttribute("sortItemsByName", Comparator.comparing(Item::getItemName));
        model.addAttribute("sortItemsByCost", Comparator.comparing(Item::getCost));
        return "products";
    }

    @GetMapping("/list")
    public String readingAll(Authentication authentication,
                             Model model) {
        model.addAttribute("users", service.getAll());
        model.addAttribute("userRole", iUserService.getUserRole(authentication));
        model.addAttribute("userId", iUserService.getUserId(authentication));
        System.out.println(456);
        return "admin/admin-user";
    }

    @GetMapping("/new")
    public String createUser(Model model) {
        // create student object to hold student form data
        User user = new User();
        model.addAttribute("users", service.getAll());
        model.addAttribute("user", user);
        return "admin/admin-user-add";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") User user) {
        service.create(user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "admin/admin-user-edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id,
                             @ModelAttribute("user") User user,
                             Model model) {

        // get pet from database by id
        User existingUser = ((User) (((UserServiceImpl) iUserService).loadUserByUsername(user.getUsername())));
        existingUser.setId(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());


        // save updated pet object
        service.update(id, existingUser);
        return "redirect:/user/list";
    }

    // handler method to handle delete student request

    @GetMapping("del/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/user/list";
    }
}
