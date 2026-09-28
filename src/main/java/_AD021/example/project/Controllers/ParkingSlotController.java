package _AD021.example.project.Controllers;


import _AD021.example.project.Models.ParkingSlot;
import _AD021.example.project.Models.Vehicle;
import _AD021.example.project.Services.ParkingSlotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/parking/")
public class ParkingSlotController {
    @Autowired
    ParkingSlotServices parkingSlotServices;

    @GetMapping("/getall")
    ResponseEntity<List<ParkingSlot>> getall() {
        return new ResponseEntity<>(parkingSlotServices.getall(),HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<ParkingSlot> addslot(
            @RequestBody ParkingSlot parkingSlot) {

        return new ResponseEntity<>(parkingSlotServices.addslot(parkingSlot),HttpStatus.CREATED);
    }

    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getslotbyid(@PathVariable long id) {
        try {
            ParkingSlot response = parkingSlotServices.getslotbyid(id);

            return new ResponseEntity<>(response,HttpStatus.OK);

        } catch (RuntimeException exception) {
            return new ResponseEntity<>("Parking slot not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/available")
    ResponseEntity<List<ParkingSlot>> getAvailableSlots() {

        return new ResponseEntity<>(parkingSlotServices.getAvailableSlots(),HttpStatus.OK
        );
    }

    @PutMapping("/update")
    ResponseEntity<?> updateSlot(
            @RequestBody ParkingSlot parkingSlot) {
        try {
            ParkingSlot response=parkingSlotServices.updateSlot(parkingSlot);
            return new ResponseEntity<>(response,HttpStatus.OK);

        } catch (RuntimeException exception) {

            return new ResponseEntity<>("Parking slot not found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteSlot(@PathVariable long id) {
        try {
            parkingSlotServices.deleteSlot(id);

            return new ResponseEntity<>("Parking slot deleted successfully",HttpStatus.OK);

        } catch (RuntimeException exception) {

            return new ResponseEntity<>("Parking slot not found",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{slotId}/assign/{vehicleId}")
    ResponseEntity<?> assignSlot(@PathVariable long slotId,@PathVariable long vehicleId) {
        try {
            Vehicle response = parkingSlotServices.assignSlot(vehicleId, slotId);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException exception) {
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/release/{vehicleId}")
    ResponseEntity<?> releaseSlot(@PathVariable long vehicleId) {
        try {
            parkingSlotServices.releaseSlot(vehicleId);
            return new ResponseEntity<>("Parking slot released successfully", HttpStatus.OK);
        } catch (RuntimeException exception) {

            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
