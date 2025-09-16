package dev.iagof.lootbox.controllers;

import dev.iagof.lootbox.helpers.JWTHelper;
import dev.iagof.lootbox.models.RequestModel;
import dev.iagof.lootbox.models.User;
import dev.iagof.lootbox.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    InventoryServices inventoryServices;

    public InventoryController(InventoryServices inventoryServices) {
        this.inventoryServices = inventoryServices;
    }

    @GetMapping
    public RequestModel getInventory(@RequestHeader("X-Auth-Token") String token) {
        //User user = JWTHelper.getUserByToken(token);
        return inventoryServices.getInventoryById(JWTHelper.getUserByToken(token).getId());
    }

}
