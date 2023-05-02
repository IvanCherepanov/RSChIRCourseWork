package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.Brand;
import com.example.rschircoursework.services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/brand")
@CrossOrigin(origins = {"http://frontpart:3000", "http://localhost:3000","http://frontpart:3006", "http://localhost:3006"})
public class BrandApiController extends AbstractController<Brand, IBrandService> {
    @Autowired
    protected BrandApiController(IBrandService service) {
        super(service);

    }

    @GetMapping("/list")
    public List<Brand> getAllBrands() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Brand read(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Brand createBrand(@RequestBody Brand brand) {
        return service.create(brand);
    }

    @PutMapping("/{id}")
    public Brand update(@PathVariable Long id, @RequestBody Brand brand) {
        return service.update(id, brand);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
