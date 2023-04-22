package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.ItemType;
import com.example.rschircoursework.services.IItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/item_type")
@CrossOrigin(origins = "http://localhost:3006")
public class ItemTypeApiController extends AbstractController<ItemType, IItemTypeService> {
    @Autowired
    protected ItemTypeApiController(IItemTypeService service) {
        super(service);
    }

    @GetMapping("/list")
    public List<ItemType> getAllItemTypes() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ItemType read(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public ItemType createItemType(@RequestBody ItemType itemType) {
        return service.create(itemType);
    }

    @PutMapping("/{id}")
    public ItemType update(@PathVariable Long id, @RequestBody ItemType itemType) {
        ItemType existingItemType = service.findById(id);
        existingItemType.setItemTypeName(itemType.getItemTypeName());
        return service.update(id, existingItemType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
