package dev.iagof.lootbox.models;

import dev.iagof.lootbox.enumerables.Rarity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "boxes")
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private Rarity rarity;

}
