package com.example.rschircoursework.controllers.api;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.Pet;
import com.example.rschircoursework.services.IPetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api/pet")
@CrossOrigin(origins = {"http://frontpart:3000", "http://localhost:3000","http://frontpart:3006", "http://localhost:3006","http://51.250.100.37:3000"})
public class PetApiController extends AbstractController<Pet, IPetService> {
    @Autowired
    protected PetApiController(IPetService service) {
        super(service);
    }


    @GetMapping("/list")
    public List<Pet> getAllPets() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Pet read(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public Pet createPet(@RequestBody Pet pet) {
        return service.create(pet);
    }

    @PutMapping("/{id}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public Pet update(@PathVariable Long id, @RequestBody Pet pet) {
        Pet existingPet = service.findById(id);
        existingPet.setPetName(pet.getPetName());
        return service.update(id, existingPet);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "apikeyAuth"))
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
