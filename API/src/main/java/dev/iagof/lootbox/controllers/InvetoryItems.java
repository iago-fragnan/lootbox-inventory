package dev.iagof.lootbox.controllers;

import dev.iagof.lootbox.helpers.JWTHelper;
import dev.iagof.lootbox.models.Items;
import dev.iagof.lootbox.models.RequestModel;
import dev.iagof.lootbox.models.User;
import dev.iagof.lootbox.services.InventoryServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory-items")
public class InvetoryItems {

    InventoryServices inventoryServices;

    public InvetoryItems(InventoryServices inventoryServices) {
        this.inventoryServices = inventoryServices;
    }

    @GetMapping
    public RequestModel getInventoryItems(@RequestHeader("X-Auth-Token") String token){
        User user = JWTHelper.getUserByToken(token);
        return inventoryServices.getInventoryById(user.getId());
    }


    // Not working
    @PostMapping("/add/{id}")
    public RequestModel getInventoryItems(@RequestBody Items item, @PathVariable("id") String uid) {
        User user = JWTHelper.getUserByToken(uid);
        return inventoryServices.addItem(item, user);
    }

}
