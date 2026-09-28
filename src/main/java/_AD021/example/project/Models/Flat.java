package _AD021.example.project.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Entity
@Setter
public class Flat {
    @Id
    @GeneratedValue

    long Id;
    String ownerName;
    String location;
    long Capacity;
    long flatNo;

    @OneToMany(mappedBy = "flat")
    @JsonIgnore
    List<Vehicle> vehicles;

}
