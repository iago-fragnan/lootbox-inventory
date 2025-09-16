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
    @Column(name = "user_id")
    private UUID userId;

    public Inventory() {
    }

    public Inventory(UUID UserId) {
        userId = UserId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserID() {
        return userId;
    }

    public void setUserID(UUID UserId) {
        userId = UserId;
    }
}
