package org.example.Model;

import jakarta.persistence.*;

@Entity // ✅ Torna a classe uma entidade gerenciada pelo JPA
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Gera o ID automaticamente
    private Long id;

    @Column(nullable = false, unique = true) // ✅ O nome da sala não pode ser nulo e deve ser único
    private String name;

    public Room() {} // ✅ Construtor vazio exigido pelo JPA

    public Room(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
