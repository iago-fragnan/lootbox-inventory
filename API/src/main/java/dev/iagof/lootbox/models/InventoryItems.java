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

    @ManyToOne
    @JoinColumn(name = "items")
    private Items itemId;

    @ManyToOne
    @JoinColumn(name = "inventories")
    private Inventory inventoryId;

    public InventoryItems() {
    }

    public Items getItemId() {
        return itemId;
    }

    public void setItemId(Items itemId) {
        this.itemId = itemId;
    }

    public Inventory getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Inventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
