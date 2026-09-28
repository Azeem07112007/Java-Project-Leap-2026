package _AD021.example.project.Services;

import _AD021.example.project.Models.ParkingSlot;
import _AD021.example.project.Models.Vehicle;
import _AD021.example.project.Repository.ParkingSlotRepository;
import _AD021.example.project.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSlotServices {
    @Autowired
    ParkingSlotRepository parkingSlotRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    public List<ParkingSlot> getall() {
        return parkingSlotRepository.findAll();
    }

    public ParkingSlot addslot(ParkingSlot parkingSlot) {
        parkingSlot.setStatus(false);
        return parkingSlotRepository.save(parkingSlot);
    }

    public ParkingSlot getslotbyid(long id) {
        return parkingSlotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking slot not found"));
    }

    public ParkingSlot updateSlot(ParkingSlot parkingSlot) {
        ParkingSlot existingSlot =
                parkingSlotRepository.findById(parkingSlot.getId())
                        .orElseThrow(() -> new RuntimeException("Parking slot not found"));
        existingSlot.setLaneNo(parkingSlot.getLaneNo());
        existingSlot.setName(parkingSlot.getName());
        existingSlot.setAmount(parkingSlot.getAmount());
        existingSlot.setStatus(parkingSlot.isStatus());

        return parkingSlotRepository.save(existingSlot);
    }

    public void deleteSlot(long id) {
        if (!parkingSlotRepository.existsById(id)) {
            throw new RuntimeException("Parking slot not found");
        }

        parkingSlotRepository.deleteById(id);
    }

    public List<ParkingSlot> getAvailableSlots() {

        return parkingSlotRepository.findAll().stream()
                .filter(slot -> !slot.isStatus()).toList();
    }

    public Vehicle assignSlot(long vehicleId, long slotId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                        .orElseThrow(() ->new RuntimeException("Vehicle not found"));

        ParkingSlot slot =
                parkingSlotRepository.findById(slotId)
                        .orElseThrow(() -> new RuntimeException("Parking slot not found"));

        if (slot.isStatus()) {
            throw new RuntimeException("Parking slot is already occupied");
        }

        if (vehicle.getParkingSlot() != null) {
            throw new RuntimeException("Vehicle already has a parking slot");
        }

        vehicle.setParkingSlot(slot);

        slot.setStatus(true);

        vehicleRepository.save(vehicle);
        parkingSlotRepository.save(slot);

        return vehicle;
    }

    public void releaseSlot(long vehicleId) {

        Vehicle vehicle =
                vehicleRepository.findById(vehicleId)
                        .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        ParkingSlot slot =vehicle.getParkingSlot();

        if (slot == null) {
            throw new RuntimeException("Vehicle is not parked");
        }

        vehicle.setParkingSlot(null);
        slot.setStatus(false);
        vehicleRepository.save(vehicle);
        parkingSlotRepository.save(slot);
    }
}