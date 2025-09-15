package dev.iagof.lootbox.services;


import dev.iagof.lootbox.helpers.RequestResponse;
import dev.iagof.lootbox.models.Inventory;
import dev.iagof.lootbox.models.RequestModel;
import dev.iagof.lootbox.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryServices {

    private final InventoryRepository inventoryRepository;

    public InventoryServices(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void create(Inventory model){
        try{
            inventoryRepository.save(model);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public RequestModel getInventoryById(UUID uid){
        RequestResponse response = new RequestResponse();
        try{
            return response.SetSuccess("SE-0002", inventoryRepository.findById(uid));
        } catch (Exception e) {
            return response.SetFailed("SE-0001", e.getMessage());
        }
    }

}
