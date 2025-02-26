package org.example.Repository;

import org.example.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Alterando para utilizar roomName, pois é a propriedade correta
    Reservation findByRoomNameAndUser(String roomName, String user);
}
