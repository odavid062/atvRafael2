package org.example.Repository;

import org.example.Model.Reservation;
import org.example.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation ,Integer> {
    Reservation findByRoom_NameAndUser(String roomName, String user);
}
