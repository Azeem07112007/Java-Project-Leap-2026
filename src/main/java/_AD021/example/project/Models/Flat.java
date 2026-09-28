package _AD021.example.project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Flat {

    @Id
    @GeneratedValue
    private Long id;

    private String ownerName;
    private String location;
    private int capacity;

    @OneToMany(mappedBy = "flat")
    @JsonIgnore
    private List<Vehicle> vehicles;
}