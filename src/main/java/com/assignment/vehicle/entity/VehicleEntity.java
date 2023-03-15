package com.assignment.vehicle.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vin;
    private String make;
    private String model;
    private long year;
    private long redLineRpm;
    private long maxFuelVolume;
    private long lastServiceDate;
}
