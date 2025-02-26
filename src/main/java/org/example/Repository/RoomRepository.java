package org.example.Repository;

import ch.qos.logback.classic.model.RootLoggerModel;
import org.example.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findByName(String name);

    boolean existsByName(String name);
}
