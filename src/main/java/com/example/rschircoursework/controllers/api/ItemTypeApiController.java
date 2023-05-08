package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.ItemType;
import com.example.rschircoursework.services.IItemTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/item_type")
@CrossOrigin(origins = {"http://frontpart:3000", "http://localhost:3000","http://frontpart:3006", "http://localhost:3006","http://51.250.100.37:3000"})
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
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public ItemType createItemType(@RequestBody ItemType itemType) {
        return service.create(itemType);
    }

    @PutMapping("/{id}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public ItemType update(@PathVariable Long id, @RequestBody ItemType itemType) {
        ItemType existingItemType = service.findById(id);
        existingItemType.setItemTypeName(itemType.getItemTypeName());
        return service.update(id, existingItemType);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
