package dev.iagof.lootbox.repositories;

import dev.iagof.lootbox.models.Inventory;
import dev.iagof.lootbox.models.InventoryItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryItemsRepository extends JpaRepository<InventoryItems, Long> {

}
