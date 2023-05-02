package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.Item;
import com.example.rschircoursework.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/item")
@CrossOrigin(origins = {"http://frontpart:3000", "http://localhost:3000","http://frontpart:3006", "http://localhost:3006"})
public class ItemApiController extends AbstractController<Item, IItemService> {
    private IPetService iPetService;
    private IItemTypeService iItemTypeService;
    private IUserService iUserService;
    private IItemService iItemService;
    private IBrandService iBrandService;

    @Autowired
    protected ItemApiController(IItemService service,
                                IPetService iPetService,
                                IItemTypeService iItemTypeService,
                                IUserService iUserService,
                                IItemService iItemService,
                                IBrandService iBrandService) {
        super(service);
        this.iPetService = iPetService;
        this.iItemTypeService = iItemTypeService;
        this.iUserService = iUserService;
        this.iItemService = iItemService;
        this.iBrandService = iBrandService;
    }


    @GetMapping(value = "/name")
    public List<Item> getItemsByName(@RequestParam(name = "itemName") String itemName) {
        return iItemService.getItemContainingItemName(itemName);
    }

    @GetMapping(value = "/type/{item_type_id}")
    public List<Item> getItemsByItemType(@PathVariable(name = "item_type_id") Long itemTypeId) {
        return iItemService.getItemByItemType(itemTypeId);
    }

    @GetMapping("/list")
    public List<Item> readingAll() {
        return iItemService.getAll();
    }

    @PostMapping("/create")
    public Item saveItem(@RequestBody Item item) {
        return iItemService.create(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id,
                           @RequestBody Item item) {
        Item existingItem = iItemService.findById(id);
        existingItem.setId(id);
        existingItem.setCost(item.getCost());
        existingItem.setDescription(item.getDescription());
        existingItem.setImagePath(item.getImagePath());
        existingItem.setItemName(item.getItemName());
        existingItem.setItemTypeId(item.getItemTypeId());
        existingItem.setPetTypeId(item.getPetTypeId());
        existingItem.setBrandId(item.getBrandId());
        return iItemService.update(id, existingItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iItemService.delete(id);
    }
}
