package _AD021.example.project.Models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue

    long Id;
    String type;
    String brand;
    Long vehicleNo;
    String ownerName;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    Flat flat;

    @OneToOne
    @JoinColumn(name = "parking_slot_id")
    ParkingSlot parkingSlot;



}
