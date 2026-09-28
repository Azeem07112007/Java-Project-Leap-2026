package _AD021.example.project.Services;
import _AD021.example.project.Models.Flat;
import _AD021.example.project.Repository.FlatRepository;
import jakarta.persistence.Id;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatServices {
    @Autowired
    FlatRepository flatRepository;

    public List<Flat> getall() {
        return flatRepository.findAll();
    }

    public Flat addflat(Flat flat) {
        return flatRepository.save(flat);
    }

    public Flat getflatbyid(long id) {
        return flatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flat not found"));
    }

    public Flat updateFlat(@NonNull Flat flat) {

        Flat existingFlat = flatRepository.findById(flat.getId())
                .orElseThrow(() -> new RuntimeException("Flat not found"));

        existingFlat.setOwnerName(flat.getOwnerName());
        existingFlat.setLocation(flat.getLocation());
        existingFlat.setCapacity(flat.getCapacity());

        return flatRepository.save(existingFlat);
    }

    public void deleteFlat(long id) {

        if (!flatRepository.existsById(id)) {
            throw new RuntimeException("Flat not found");
        }

        flatRepository.deleteById(id);
    }

}
