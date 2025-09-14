package dev.iagof.lootbox.models;


import jakarta.persistence.*;

// InventoryItems
// Cria um vinculo de multiplos itens da tabela Items
// com o id do inventario

@Entity
@Table(name = "inventoryitems")
public class InventoryItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long itemId;

    public InventoryItems() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
}
