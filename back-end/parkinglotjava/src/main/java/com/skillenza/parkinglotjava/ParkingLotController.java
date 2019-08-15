package com.skillenza.parkinglotjava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillenza.parkinglotjava.service.ParkingLotService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ParkingLotController {

	
	@Autowired
	private ParkingLotService parkingLotService;
	@GetMapping("/parkings")
	public List<ParkingLot> findAll(){
		return parkingLotService.findAll();
	}
	
	
	@PostMapping("/parkings")
	public ParkingLot saveParkingLotDetail(@RequestBody ParkingLot pl)
	{
		parkingLotService.save(pl);
		return pl;
	}
}

