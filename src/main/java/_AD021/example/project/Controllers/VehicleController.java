package _AD021.example.project.Controllers;

import _AD021.example.project.Models.Vehicle;
import _AD021.example.project.Services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicle")
public class VehicleController {
    @Autowired
    VehicleServices vehicleServices;

    @GetMapping("/getall")
    ResponseEntity<List<Vehicle>> getall() {

        return new ResponseEntity<>(vehicleServices.getall(), HttpStatus.OK
        );
    }

    @PostMapping("/create")
    ResponseEntity<Vehicle> addvehicle(@RequestBody Vehicle vehicle) {

        return new ResponseEntity<>(vehicleServices.addvehicle(vehicle), HttpStatus.CREATED
        );
    }

    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getvehiclebyid(@PathVariable long id) {
        try {
            Vehicle response = vehicleServices.getvehiclebyid(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("Vehicle not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle response = vehicleServices.updateVehicle(vehicle);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("Vehicle not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteVehicle(@PathVariable long id) {
        try {
            vehicleServices.deleteVehicle(id);
            return new ResponseEntity<>("Vehicle deleted successfully",HttpStatus.OK
            );

        } catch (RuntimeException exception) {

            return new ResponseEntity<>("Vehicle not found", HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/{vehicleId}/flat/{flatId}")
    ResponseEntity<?> assignVehicleToFlat(@PathVariable long vehicleId, @PathVariable long flatId) {
        try {
            Vehicle response = vehicleServices.assignVehicleToFlat(vehicleId, flatId);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException exception) {
            return new ResponseEntity<>(
                    exception.getMessage(),
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
