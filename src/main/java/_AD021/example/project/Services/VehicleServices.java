package _AD021.example.project.Services;

import _AD021.example.project.Models.Flat;
import _AD021.example.project.Models.Vehicle;
import _AD021.example.project.Repository.FlatRepository;
import _AD021.example.project.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServices  {

        @Autowired
        VehicleRepository vehicleRepository;

        @Autowired
        FlatRepository flatRepository;

        public List<Vehicle> getall() {
            return vehicleRepository.findAll();
        }

        public Vehicle addvehicle(Vehicle vehicle) {
            return vehicleRepository.save(vehicle);
        }

        public Vehicle getvehiclebyid(long id) {
            return vehicleRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        }

        public Vehicle updateVehicle(Vehicle vehicle) {

            Vehicle existingVehicle = vehicleRepository.findById(vehicle.getId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));

            existingVehicle.setType(vehicle.getType());
            existingVehicle.setBrand(vehicle.getBrand());
            existingVehicle.setVehicleNo(vehicle.getVehicleNo());
            existingVehicle.setOwnerName(vehicle.getOwnerName());

            return vehicleRepository.save(existingVehicle);
        }

        public void deleteVehicle(long id) {

            if (!vehicleRepository.existsById(id)) {
                throw new RuntimeException("Vehicle not found");
            }

            vehicleRepository.deleteById(id);
        }

        public Vehicle assignVehicleToFlat(long vehicleId, long flatId) {

            Vehicle vehicle = vehicleRepository.findById(vehicleId)
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));

            Flat flat = flatRepository.findById(flatId)
                    .orElseThrow(() -> new RuntimeException("Flat not found"));

            vehicle.setFlat(flat);

            return vehicleRepository.save(vehicle);
        }
}
