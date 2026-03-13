package com.example.springbootproject.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carName;
    
    private String carOwner;
    
    private Character fuelType;

	public Cars(Long id, String carName, String carOwner, Character fuelType) {
		super();
		this.id = id;
		this.carName = carName;
		this.carOwner = carOwner;
		this.fuelType = fuelType;
	}

	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarOwner() {
		return carOwner;
	}

	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}

	public Character getFuelType() {
		return fuelType;
	}

	public void setFuelType(Character fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Cars [id=" + id + ", carName=" + carName + ", carOwner=" + carOwner + ", fuelType=" + fuelType + "]";
	}
    
    

}
