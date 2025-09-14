package dev.iagof.lootbox.models;


import dev.iagof.lootbox.enumerables.ItemsType;
import dev.iagof.lootbox.enumerables.Rarity;
import jakarta.persistence.*;



// Items
// aqui vai ficar registrado todos os itens existentes
// juntamente com nome, raridade, chance etc. para ser adicionado
// ao inventário de um usuário

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Rarity rarity;
    private float chance;
    private ItemsType type; // it can be a box or an item

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public float getChance() {
        return chance;
    }

    public void setChance(float chance) {
        this.chance = chance;
    }

    public ItemsType getType() {
        return type;
    }

    public void setType(ItemsType type) {
        this.type = type;
    }
}
