package _AD021.example.project.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Flat {
    @Id
    @GeneratedValue

    long Id;
    String ownerName;
    String location;
    long Capacity;
    long flatNo;

    @OneToMany(mappedBy = "flat")
    List<Vehicle> vehicles;

}
