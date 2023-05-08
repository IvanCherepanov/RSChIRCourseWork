package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.Item;
import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.services.IItemService;
import com.example.rschircoursework.services.IItemTypeService;
import com.example.rschircoursework.services.IPetService;
import com.example.rschircoursework.services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = {"http://frontpart:3000", "http://localhost:3000","http://frontpart:3006", "http://localhost:3006","http://51.250.100.37:3000"})
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
                                  @RequestParam(name = "bId", required = false) Long brandId,
                                  @RequestParam(name = "pTId", required = false) Long productTypeId,
                                  @RequestParam(name = "sId", required = false) Integer sortId) {
        Long IpetId = (petId == null) ? 0 : petId;
        Long IproductTypeId = (productTypeId == null) ? 0 : productTypeId;
        Long IbrandId = (brandId == null) ? 0 : brandId;
        List<Item> items;
        log.info("{}, {}, {}", IpetId, IproductTypeId, IbrandId);
        if (IpetId == 0 && IproductTypeId == 0 && IbrandId ==0) {
            System.out.println("000");
            items = iItemService.getAllSorting(sortId, iItemService.getAll());
        }else if (IpetId == 0 && IproductTypeId == 0 && IbrandId !=0){
            System.out.println("001");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByBrandId(IbrandId));
        }else if (IpetId == 0 && IproductTypeId != 0 && IbrandId ==0){
            System.out.println("010");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByItemType(IproductTypeId));
        }else if (IpetId == 0 && IproductTypeId != 0 && IbrandId !=0){
            System.out.println("011");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByItemTypeIdAndBrandId(IproductTypeId,IbrandId));
        }else if (IpetId != 0 && IproductTypeId == 0 && IbrandId ==0){
            System.out.println("100");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByPetId(IpetId));
        }else if (IpetId != 0 && IproductTypeId == 0 && IbrandId !=0){
            System.out.println("101");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByPetIdAndBrandId(IpetId,IbrandId));
        }else if (IpetId != 0 && IproductTypeId != 0 && IbrandId ==0){
            System.out.println("110");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByPetIdAndTypeId(IpetId,IproductTypeId));
        }
        else{
            System.out.println("111");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByPetIdAndTypeIdAndBrandId(IpetId,IproductTypeId,IbrandId));
        }
//        else if (IpetId == 0 && IproductTypeId != 0) {
//            items = iItemService.getAllSorting(sortId, iItemService.getItemByItemType(productTypeId));
//        } else if (IpetId != 0 && IproductTypeId == 0) {
//            items = iItemService.getAllSorting(sortId, iItemService.getItemByPetId(petId));
//        } else {
//            items = iItemService.getAllSorting(sortId, iItemService.getItemByPetIdAndTypeId(petId, productTypeId));
//        }

        return items;
    }

    @GetMapping(value = "/products_pag", produces = MediaType.APPLICATION_JSON_VALUE)
    public PaginationData getProducts(//Authentication authentication,
                                      @RequestParam(name = "page", defaultValue = "0") int page,
                                      @RequestParam(name = "size", defaultValue = "10") int size,
                                      @RequestParam(name = "pId", required = false) Long petId,
                                      @RequestParam(name = "bId", required = false) Long brandId,
                                      @RequestParam(name = "pTId", required = false) Long productTypeId,
                                      @RequestParam(name = "sId", required = false) Integer sortId,
                                      @RequestParam(name = "itemName", required = false) String itemName) {
        Long IpetId = (petId == null) ? 0 : petId;
        Long IproductTypeId = (productTypeId == null) ? 0 : productTypeId;
        Long IbrandId = (brandId == null) ? 0 : brandId;
        List<Item> items;
        log.info("{}, {}, {}", IpetId, IproductTypeId, IbrandId);
        if (IpetId == 0 && IproductTypeId == 0 && IbrandId ==0) {
            System.out.println("000");
            items = iItemService.getAllSorting(sortId, iItemService.getAll());
        }else if (IpetId == 0 && IproductTypeId == 0 && IbrandId !=0){
            System.out.println("001");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByBrandId(IbrandId));
        }else if (IpetId == 0 && IproductTypeId != 0 && IbrandId ==0){
            System.out.println("010");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByItemType(IproductTypeId));
        }else if (IpetId == 0 && IproductTypeId != 0 && IbrandId !=0){
            System.out.println("011");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByItemTypeIdAndBrandId(IproductTypeId,IbrandId));
        }else if (IpetId != 0 && IproductTypeId == 0 && IbrandId ==0){
            System.out.println("100");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByPetId(IpetId));
        }else if (IpetId != 0 && IproductTypeId == 0 && IbrandId !=0){
            System.out.println("101");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByPetIdAndBrandId(IpetId,IbrandId));
        }else if (IpetId != 0 && IproductTypeId != 0 && IbrandId ==0){
            System.out.println("110");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByPetIdAndTypeId(IpetId,IproductTypeId));
        }
        else{
            System.out.println("111");
            items = iItemService.getAllSorting(sortId,
                    iItemService.getItemByPetIdAndTypeIdAndBrandId(IpetId,IproductTypeId,IbrandId));
        }
        if (itemName != null){
            System.out.println("Search");
            items = searchItemByName(items, itemName);
        }
        // Calculate start and end index for the items on the requested page
        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, items.size());
        System.out.println(Integer.toString(startIndex) +  Integer.toString(endIndex));
        if (startIndex >= items.size()) {
            // Requested page is out of range, return an empty list
            PaginationData paginationData = new PaginationData(Collections.emptyList(), 0);
            return paginationData;
        } else {
            System.out.println(items);
            System.out.println(items.size());
            PaginationData paginationData = new PaginationData(items.subList(startIndex, endIndex), items.size());
            System.out.println(paginationData.getAmount());
            System.out.println(paginationData.getItem());
            // Return the items on the requested page
            return paginationData;
        }
    }

    private static class PaginationData{
        private List<Item> item;
        private int amount;

        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        private PaginationData(List<Item> item, int amount) {
            this.item = item;
            this.amount = amount;
        }
    }

    public List<Item> searchItemByName(List<Item> items, String searchName) {
        List<Item> result = new ArrayList<>();
        String lowerSearchName = searchName.toLowerCase();
        for (Item item : items) {
            if (item.getItemName().toLowerCase().contains(lowerSearchName)) {
                result.add(item);
            }
        }
        return result;
    }


    @GetMapping("/list")
    public List<User> getAllUsers() { //Authentication authentication
        return service.getAll();
    }

    @PostMapping("/create")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public void createUser(@RequestBody User user) {
        service.create(user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
    }

    @PutMapping("/{id}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public User update(@PathVariable Long id, @RequestBody User user) {
        User existingUser = iUserService.findById(id);
        existingUser.setUsername(user.getUsername());
        //existingUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        existingUser.setEmail(user.getEmail());
        //existingUser.setRole(user.getRole());
        return service.update(id, existingUser);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/username")
    public User findByUsername(@RequestParam(name = "userName") String username){
        User user = iUserService.findUserByUsername(username);
        return user;
    }
}
