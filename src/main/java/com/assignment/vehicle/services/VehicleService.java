package com.assignment.vehicle.services;



import com.assignment.vehicle.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle createVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicle();

    boolean deleteVehicle(Long vin);

    Vehicle getVehicleById(Long vin);

    Vehicle updateVehicle(Long vin, Vehicle vehicle);
}
