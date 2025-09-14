package dev.iagof.lootbox.models;

import jakarta.persistence.*;

// Inventory
// Cada registro é um inventario vinculado a um usuário
// Usuário poderá só ter um inventario

@Entity
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long UserID;

    public Inventory(long userID) {
        UserID = userID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserID() {
        return UserID;
    }

    public void setUserID(long userID) {
        UserID = userID;
    }
}
