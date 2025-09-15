package dev.iagof.lootbox.models;

import dev.iagof.lootbox.enumerables.Roles;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private UUID id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Lob
    @Column(name = "session", unique = true, nullable = true, length = 512)
    private String sessionId;
    private Roles role = Roles.user;

    public User() {
    }

    public User(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
