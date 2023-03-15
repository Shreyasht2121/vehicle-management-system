package com.assignment.vehicle.controller;

import com.assignment.vehicle.model.Vehicle;
import com.assignment.vehicle.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicle")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @GetMapping("/vehicle")
    public List<Vehicle> getAllVehicle() {
        return  vehicleService.getAllVehicle();
    }

    @DeleteMapping("/vehicle/{vin}")
    public ResponseEntity<Map<String,Boolean>> deleteVehicle(@PathVariable Long vin) {
        boolean deleted = false;
        deleted = vehicleService.deleteVehicle(vin);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/vehicle/{vin}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long vin) {
        Vehicle vehicle = null;
        vehicle = vehicleService.getVehicleById(vin);
        return ResponseEntity.ok(vehicle);
    }

    @PutMapping("/vehicle/{vin}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long vin,
                                                  @RequestBody Vehicle vehicle) {
        vehicle = vehicleService.updateVehicle(vin, vehicle);
        return ResponseEntity.ok(vehicle);
    }

}
