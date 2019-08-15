package com.skillenza.parkinglotjava.dao;

import java.util.List;

import com.skillenza.parkinglotjava.ParkingLot;

public interface ParkingLotDao {

	public List<ParkingLot> findAll();
	
	public void save(ParkingLot parkingLotModel);
}
