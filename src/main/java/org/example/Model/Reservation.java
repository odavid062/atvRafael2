package org.example.Model;

import jakarta.persistence.*;

@Entity // Define esta classe como uma entidade JPA
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente o ID da reserva
    private Long id;

    private String roomName; // Nome da sala reservada

    @Column(name = "username") // Evita conflitos com a palavra reservada 'user' no PostgreSQL
    private String user; // Nome do usuário que fez a reserva

    // Construtor padrão exigido pelo JPA
    public Reservation() {}

    /**
     * Construtor que inicializa uma reserva com o nome da sala e do usuário.
     *
     * @param roomName Nome da sala reservada.
     * @param user Nome do usuário que fez a reserva.
     */
    public Reservation(String roomName, String user) {
        this.roomName = roomName;
        this.user = user;
    }

    /**
     * Construtor que recebe um objeto Room e um usuário.
     *
     * @param room Objeto da sala reservada.
     * @param user Nome do usuário que fez a reserva.
     */
    public Reservation(Room room, String user) {
        this.roomName = room.getName(); // Obtém o nome da sala do objeto Room
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Reserva para " + user + " na sala " + roomName;
    }
}
