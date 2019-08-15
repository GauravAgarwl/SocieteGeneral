package com.skillenza.parkinglotjava;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parkinglots",
uniqueConstraints = @UniqueConstraint(columnNames = {"lot", "vehicle_number"}))
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ParkingLot {
	
	
	
	@Basic(optional = false)
	@CreationTimestamp
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
	
    private int lot;
    
    private int parkingDuration;
    private int parkingAmount;
    

    
    @UpdateTimestamp
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @Column(name="vehicle_number")
    private int vehicleNumber;
    

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public int getParkingAmount() {
		return parkingAmount;
	}

	public void setParkingAmount(int parkingAmount) {
		this.parkingAmount = parkingAmount;
	}

	public int getParkingDuration() {
		return parkingDuration;
	}

	public void setParkingDuration(int parkingDuration) {
		this.parkingDuration = parkingDuration;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		 this.updatedAt=updatedAt;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
    
}
