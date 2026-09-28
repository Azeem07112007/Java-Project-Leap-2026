package _AD021.example.project.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ParkingSlot {

    @Id
    @GeneratedValue
    private Long id;

    private int laneNo;
    private String name;
    private int amount;
    private boolean status;
}