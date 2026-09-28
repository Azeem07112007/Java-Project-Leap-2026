package _AD021.example.project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String brand;
    private Long vehicleNo;
    private String ownerName;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    @JsonIgnore
    private Flat flat;

    @OneToOne
    @JoinColumn(name = "parking_slot_id")
    @JsonIgnore
    private ParkingSlot parkingSlot;

    @JsonProperty("flatId")
    public Long getFlatId() {
        return flat != null ? flat.getId() : null;
    }

    @JsonProperty("parkingSlotId")
    public Long getParkingSlotId() {
        return parkingSlot != null ? parkingSlot.getId() : null;
    }
}