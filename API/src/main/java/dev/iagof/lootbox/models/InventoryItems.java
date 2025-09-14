package dev.iagof.lootbox.models;


import jakarta.persistence.*;

import java.util.UUID;

// InventoryItems
// Cria um vinculo de multiplos itens da tabela Items
// com o id do inventario

@Entity
@Table(name = "inventoryitems")
public class InventoryItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID itemId;
    private UUID inventoryId;

    public InventoryItems() {
    }

    public UUID getId() {
        return id;
    }


    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }
}
