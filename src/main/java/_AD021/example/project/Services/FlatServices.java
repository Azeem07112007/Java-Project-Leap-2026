package _AD021.example.project.Services;
import _AD021.example.project.Models.Flat;
import _AD021.example.project.Repository.FlatRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatServices {
    @Autowired
    private FlatRepository flatRepository;

    public Flat addflat(Flat flat){
        Flat result= flatRepository.save(flat);
        return result;
    }

    public Flat getflatbyid(long id){
        return flatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flat not found"));
    }
    public List<Flat> getall(){
        return flatRepository.findAll();
     }

    public Flat updateFlat(Flat flat) {
        Flat existingFlat = flatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flat not found"));
        existingFlat.setOwnerName(flat.getOwnerName());
        existingFlat.setLocation(flat.getLocation());
        existingFlat.setCapacity(flat.getCapacity());

        return flatRepository.save(existingFlat);
    }
    public void delete(long id){
        if(!flatRepository.existsById(id)){
            throw new RuntimeException("Flat not existed");
        }
        flatRepository.deleteById(id);
    }



}
