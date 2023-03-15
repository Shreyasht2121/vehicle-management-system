package com.assignment.vehicle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private long vin;
    private String make;
    private String model;
    private long year;
    private long redLineRpm;
    private long maxFuelVolume;
    private long lastServiceDate;
}
