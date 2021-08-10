package com.yashen.store.controllers;

import com.yashen.store.models.Items;
import com.yashen.store.repositories.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemsRepo itemsRepo;

    @PostMapping("/post")
    public String postItem(@RequestBody Items items){
    itemsRepo.save(items);
    return "200 Ok";
    }

    @PostMapping("/postall")
    public String postAll(@RequestBody List<Items> allItems){
        itemsRepo.saveAll(allItems);
        return "200 Ok";
    }

    @GetMapping("/get")
    public @ResponseBody List<Items> allItems(){
        return itemsRepo.findAll();
    }

    @GetMapping("/getone/{id}")
    public Optional<Items> findOneItem(@PathVariable Long id){
        return itemsRepo.findById(id);
    }

    @PutMapping("/update/{id}")
    public String updateItem(@RequestBody Items items){
        itemsRepo.save(items);
        return "204 Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable long id) {
        itemsRepo.deleteById(id);
        return "204 Deleted";
    }


}
