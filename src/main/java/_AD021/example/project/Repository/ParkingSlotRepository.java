package _AD021.example.project.Repository;

import _AD021.example.project.Models.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot,Long> {
}
