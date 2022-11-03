package com.example.rschircoursework.controllers;

import com.example.rschircoursework.model.entity.Brand;
import com.example.rschircoursework.model.entity.Pet;
import com.example.rschircoursework.services.IBrandService;
import com.example.rschircoursework.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="/brand")
public class BrandController extends AbstractController<Brand, IBrandService>{
    @Autowired
    protected BrandController(IBrandService service) {
        super(service);
    }


    @GetMapping("/list")
    public String readingAll(Model model) {
        model.addAttribute("brands", service.getAll());
        System.out.println(123);
        return "admin/admin-brand";
    }

    @GetMapping("/new")
    public String createPet(Model model) {
        // create student object to hold student form data
        Brand brand = new Brand();
        model.addAttribute("brand", brand);
        return "admin/admin-brand-add";

    }

    @PostMapping("/create")
    public String savePet(@ModelAttribute("brand") Brand brand) {
        service.create(brand);
        return "redirect:/brand/list";
    }

    @GetMapping("/edit/{id}")
    public String editPet(@PathVariable Long id, Model model) {
        model.addAttribute("brand", service.findById(id));
        return "admin/admin-brand-edit";
    }

    @PostMapping("/{id}")
    public String updatePet(@PathVariable Long id,
                            @ModelAttribute("brand") Brand brand,
                            Model model) {

        // get pet from database by id
        Brand existingBrand = service.findById(id);
        existingBrand.setId(id);
        existingBrand.setBrandName(brand.getBrandName());
        existingBrand.setSale(brand.getSale());

        // save updated pet object
        service.update(id, existingBrand);
        return "redirect:/brand/list";
    }

    // handler method to handle delete student request

    @GetMapping("del/{id}")
    public String deletePet(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/brand/list";
    }
}
