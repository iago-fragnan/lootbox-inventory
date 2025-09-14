package dev.iagof.lootbox.services;

import dev.iagof.lootbox.helpers.RequestResponse;
import dev.iagof.lootbox.models.InventoryItems;
import dev.iagof.lootbox.models.RequestModel;
import dev.iagof.lootbox.repositories.InventoryRepository;

import java.util.UUID;

public class InventoryServices {

    private final InventoryRepository inventoryRepository;

    public InventoryServices(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public RequestModel getInventoryByUserID(long id){
        RequestResponse response = new RequestResponse();
        try{
            return response.SetSuccess("SE-0002", inventoryRepository.findByUserID(id));
        }
        catch (Exception e){
            return response.SetFailed("SE-0001", e.getMessage());
        }
    }

}
