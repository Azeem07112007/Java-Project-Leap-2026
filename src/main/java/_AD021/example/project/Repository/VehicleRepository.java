package _AD021.example.project.Repository;

import _AD021.example.project.Models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
