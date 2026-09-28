package _AD021.example.project.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ParkingSlot {
    @Id
    @GeneratedValue

    long Id;
    int laneNo;
    String name;
    int amount;
    boolean status;

    @OneToOne(mappedBy = "parkingSlot")
    Vehicle vehicle;


}
