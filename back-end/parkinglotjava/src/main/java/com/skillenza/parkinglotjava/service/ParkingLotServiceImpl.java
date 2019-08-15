package com.skillenza.parkinglotjava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillenza.parkinglotjava.ParkingLot;
import com.skillenza.parkinglotjava.dao.ParkingLotDao;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{

	@Autowired
	private ParkingLotDao parkingLotDao;
	
	@Override
	@Transactional
	public List<ParkingLot> findAll() {
		return parkingLotDao.findAll();
	}

	@Override
	@Transactional
	public void save(ParkingLot parkingLotModel) {
		parkingLotDao.save(parkingLotModel);
	}

}
