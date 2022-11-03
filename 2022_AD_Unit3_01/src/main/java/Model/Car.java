/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author joange
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Car")
public class Car implements Serializable {

    public Car(String plate, String brand, int year) {
        this.plate = plate;
        this.brand = brand;
        this.year = year;
    }

    static final long serialVersionUID = 137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCar;

    @Column
    private String plate;

    @Column(name = "marca")
    private String brand;
    
    @Column
    private int year;

}
