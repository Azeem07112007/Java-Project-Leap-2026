package _AD021.example.project.Controllers;


import _AD021.example.project.Models.Flat;
import _AD021.example.project.Services.FlatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flat")
public class FlatController {
    @Autowired
    public FlatServices flatServices;

    @GetMapping("getall")
    ResponseEntity<List<Flat>> getall(){
        return new ResponseEntity<>(flatServices.getall(), HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Flat> addflat(@RequestBody Flat flat){
        return new ResponseEntity<>(flatServices.addflat(flat),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getbyid/{id}")
    ResponseEntity<?>getflatbyid(@PathVariable long id){
        try {
            Flat response=flatServices.getflatbyid(id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (RuntimeException exception){
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }


    }
    @PutMapping("/update")
    ResponseEntity<Flat>updateFlat( @RequestBody Flat flat){
        return new ResponseEntity<>(flatServices.updateFlat(flat),HttpStatus.ACCEPTED);

    }


}
