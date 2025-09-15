package dev.iagof.lootbox.repositories;

import dev.iagof.lootbox.models.Inventory;
import dev.iagof.lootbox.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
}
