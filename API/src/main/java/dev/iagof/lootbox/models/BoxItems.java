package dev.iagof.lootbox.models;

import jakarta.persistence.*;

@Entity
@Table
public class BoxItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "boxes")
    public Boxes boxId;

    @ManyToOne
    @JoinColumn(name = "items")
    public Items itemId;
}
