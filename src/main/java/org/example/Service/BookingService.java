package org.example.Service;

import org.example.Model.Reservation;
import org.example.Model.Room;
import org.example.Repository.ReservationRepository;
import org.example.Repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class BookingService {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    // Injeta os repositórios via construtor
    public BookingService(RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    /**
     * Faz uma reserva para um usuário em uma determinada sala.
     *
     * @param roomName Nome da sala onde a reserva será feita.
     * @param user Nome do usuário que está fazendo a reserva.
     */
    public void makeReservation(String roomName, String user) {
        Room room = roomRepository.findByName(roomName); // Busca a sala pelo nome no banco
        if (room != null) {
            Reservation reservation = new Reservation(room, user); // Cria a reserva
            reservationRepository.save(reservation); // Salva a reserva no banco de dados
            System.out.println("Reserva feita com sucesso!");
        } else {
            System.out.println("Sala não encontrada."); // Caso a sala não exista
        }
    }

    /**
     * Lista todas as reservas existentes no banco de dados.
     */
    public void listReservations() {
        List<Reservation> reservations = reservationRepository.findAll(); // Busca todas as reservas
        if (reservations.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada."); // Caso não haja reservas
        } else {
            reservations.forEach(System.out::println); // Imprime todas as reservas encontradas
        }
    }
    public Room createRoom(String name) {
        if (roomRepository.existsByName(name)) {
            throw new IllegalArgumentException("Room with this name already exists");
        }
        Room room = new Room();
        room.setName(name);
        return roomRepository.save(room);
    }

    /**
     * Cancela uma reserva específica, informada pelo nome da sala e do usuário.
     *
     * @param roomName Nome da sala da reserva a ser cancelada.
     * @param user Nome do usuário que deseja cancelar a reserva.
     */
    public void cancelReservation(String roomName, String user) {
        Reservation reservation = reservationRepository.findByRoomNameAndUser(roomName, user); // Busca a reserva
        if (reservation != null) {
            reservationRepository.delete(reservation); // Deleta a reserva se encontrada
            System.out.println("Reserva cancelada.");
        } else {
            System.out.println("Reserva não encontrada."); // Caso a reserva não exista
        }
    }
}
