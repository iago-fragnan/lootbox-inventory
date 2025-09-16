package dev.iagof.lootbox.services;


import dev.iagof.lootbox.helpers.RequestResponse;
import dev.iagof.lootbox.models.*;
import dev.iagof.lootbox.repositories.InventoryItemsRepository;
import dev.iagof.lootbox.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryServices {

    private final InventoryRepository inventoryRepository;
    private final InventoryItemsRepository inventoryItemsRepository;

    public InventoryServices(InventoryRepository inventoryRepository, InventoryItemsRepository inventoryItemsRepository) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryItemsRepository = inventoryItemsRepository;
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
            return response.SetSuccess("SE-0002", inventoryRepository.findByUserId(uid));
        } catch (Exception e) {
            return response.SetFailed("SE-0001", e.getMessage());
        }
    }
    public RequestModel addItem(Items item, User user){
        RequestResponse response = new RequestResponse();
        try{
            InventoryItems ItemInv = new InventoryItems();
            ItemInv.setInventoryId(inventoryRepository.findByUserId(user.getId()));
            ItemInv.setItemId(item);
            return response.SetSuccess("SE-0002", inventoryItemsRepository.save(ItemInv));
        } catch (Exception e) {
            return response.SetFailed("SE-0001", e.getMessage());
        }
    }


}
