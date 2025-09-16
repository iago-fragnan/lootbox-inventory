package dev.iagof.lootbox.models;

import jakarta.persistence.*;

@Entity
@Table
public class Boxes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
}
