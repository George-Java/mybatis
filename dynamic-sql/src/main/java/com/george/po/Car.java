package com.george.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int id;
    private String brand;
    private double price;
    private LocalDate produceTime;
    private String carType;
}
