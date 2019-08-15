package com.skillenza.parkinglotjava.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skillenza.parkinglotjava.ParkingLot;

@Repository
public class ParkingLotDaoImpl implements ParkingLotDao{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<ParkingLot> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<ParkingLot> theQuery = 
				currentSession.createQuery("from ParkingLot" , ParkingLot.class);
		
		List<ParkingLot> parkingLotModel =theQuery.getResultList();
		return parkingLotModel;
	}

	@Override
	public void save(ParkingLot parkingLotModel) {

		Session currentSession= entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(parkingLotModel);
		
	}

	
}
