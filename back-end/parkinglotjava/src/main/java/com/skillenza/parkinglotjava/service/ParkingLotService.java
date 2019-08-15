package com.skillenza.parkinglotjava.service;

import java.util.List;

import com.skillenza.parkinglotjava.ParkingLot;

public interface ParkingLotService {

	public List<ParkingLot> findAll();
	
	public void save(ParkingLot parkingLotModel);
}
