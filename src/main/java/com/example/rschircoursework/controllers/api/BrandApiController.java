package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.Brand;
import com.example.rschircoursework.services.IBrandService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Api(tags = "Brands")
@RequestMapping(value="/api/brand")
@CrossOrigin(origins = {"http://frontpart:3000", "http://localhost:3000","http://frontpart:3006", "http://localhost:3006","http://51.250.100.37:3000"})
public class BrandApiController extends AbstractController<Brand, IBrandService> {
    @Autowired
    protected BrandApiController(IBrandService service) {
        super(service);

    }

    @GetMapping("/list")
    //@ApiOperation(value = "Create bar", notes = "Creates a new bar object")
    public List<Brand> getAllBrands() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Brand read(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public Brand createBrand(@RequestBody Brand brand) {
        return service.create(brand);
    }

    @PutMapping("/{id}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public Brand update(@PathVariable Long id, @RequestBody Brand brand) {
        return service.update(id, brand);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
