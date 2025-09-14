package dev.iagof.lootbox.models;


import jakarta.persistence.*;

@Entity
@Table(name = "inventoryitems")
public class InventoryItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    private Inventory inventoryID;
    private Items itemsID;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Inventory getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Inventory inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Items getItemsID() {
        return itemsID;
    }

    public void setItemsID(Items itemsID) {
        this.itemsID = itemsID;
    }
}
