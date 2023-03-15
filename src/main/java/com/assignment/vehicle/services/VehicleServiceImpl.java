package com.assignment.vehicle.services;


import com.assignment.vehicle.entity.VehicleEntity;
import com.assignment.vehicle.model.Vehicle;
import com.assignment.vehicle.repository.VehicleRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = new VehicleEntity();

        BeanUtils.copyProperties(vehicle, vehicleEntity);
        vehicleRepository.save(vehicleEntity);
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        List<VehicleEntity> vehicleEntities
                = vehicleRepository.findAll();

        List<Vehicle> vehicles = vehicleEntities
                .stream()
                .map(emp -> new Vehicle(
                        emp.getVin(),
                        emp.getMake(),
                        emp.getModel(),
                        emp.getYear(),
                        emp.getRedLineRpm(),
                emp.getMaxFuelVolume(),
                emp.getLastServiceDate()))
                .collect(Collectors.toList());
        return vehicles;
    }

    @Override
    public boolean deleteVehicle(Long vin) {
        VehicleEntity employee = vehicleRepository.findById(vin).get();
        vehicleRepository.delete(employee);
        return true;
    }

    @Override
    public Vehicle getVehicleById(Long vin) {
        VehicleEntity vehicleEntity
                = vehicleRepository.findById(vin).get();
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(vehicleEntity, vehicle);
        return vehicle;
    }

    @Override
    public Vehicle updateVehicle(Long vin, Vehicle vehicle) {
        VehicleEntity vehicleEntity
                = vehicleRepository.findById(vin).get();
        vehicleEntity.setVin(vehicle.getVin());
        vehicleEntity.setMake(vehicle.getMake());
        vehicleEntity.setModel(vehicle.getModel());
        vehicleEntity.setYear(vehicle.getYear());
        vehicleEntity.setRedLineRpm(vehicle.getRedLineRpm());
        vehicleEntity.setMaxFuelVolume(vehicle.getMaxFuelVolume());
        vehicleEntity.setLastServiceDate(vehicle.getLastServiceDate());

        vehicleRepository.save(vehicleEntity);
        return vehicle;
    }
}
