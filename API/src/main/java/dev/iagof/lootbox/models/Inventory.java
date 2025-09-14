package dev.iagof.lootbox.models;

import jakarta.persistence.*;

import java.util.UUID;

// Inventory
// Cada registro é um inventario vinculado a um usuário
// Usuário poderá só ter um inventario

@Entity
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID UserID;

    public Inventory(UUID userID) {
        UserID = userID;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserID() {
        return UserID;
    }

    public void setUserID(UUID userID) {
        UserID = userID;
    }
}
