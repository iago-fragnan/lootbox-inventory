package dev.iagof.lootbox.services;


import dev.iagof.lootbox.helpers.RequestResponse;
import dev.iagof.lootbox.models.Inventory;
import dev.iagof.lootbox.models.RequestModel;
import dev.iagof.lootbox.repositories.InventoryItemsRepository;
import dev.iagof.lootbox.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryItemsServices {

    private final InventoryItemsRepository inventoryItemsRepository;

    public InventoryItemsServices(InventoryItemsRepository inventoryItemsRepository) {
        this.inventoryItemsRepository = inventoryItemsRepository;
    }
}
