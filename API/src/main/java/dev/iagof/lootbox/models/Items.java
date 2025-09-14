package dev.iagof.lootbox.models;


import dev.iagof.lootbox.enumerables.Rarity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;
    private Rarity rarity;
    private float chance;


}
