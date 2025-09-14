package dev.iagof.lootbox.controllers;

import dev.iagof.lootbox.helpers.RequestResponse;
import dev.iagof.lootbox.models.RequestModel;
import dev.iagof.lootbox.models.UserInventory;
import dev.iagof.lootbox.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryServices inventoryServices;

    public InventoryController(InventoryServices inventoryServices) {
        this.inventoryServices = inventoryServices;
    }

    @PostMapping("/get-inventory-by-id")
    public RequestModel getInventory(@RequestBody long id){
        return inventoryServices.getInventoryByUserID(id);
    }
}
