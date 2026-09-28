package _AD021.example.project.Controllers;


import _AD021.example.project.Models.Flat;
import _AD021.example.project.Services.FlatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flat/")
public class FlatController {
    @Autowired
    FlatServices flatServices;

    @GetMapping("/getall")
    ResponseEntity<List<Flat>> getall() {
        return new ResponseEntity<>(flatServices.getall(),HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Flat> addflat(@RequestBody Flat flat) {
        return new ResponseEntity<>(flatServices.addflat(flat),HttpStatus.CREATED);
    }

    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getflatbyid(@PathVariable long id) {
        try {
            Flat response = flatServices.getflatbyid(id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("Flat not found",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    ResponseEntity<?> updateFlat(@RequestBody Flat flat) {
        try {
            Flat response = flatServices.updateFlat(flat);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("Flat not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteFlat(@PathVariable long id) {
        try {
            flatServices.deleteFlat(id);
            return new ResponseEntity<>("Flat deleted successfully",HttpStatus.OK);
        } catch (RuntimeException exception) {

            return new ResponseEntity<>("Flat not found",HttpStatus.NOT_FOUND);
        }
    }


}
