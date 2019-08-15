import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import {Parking} from '../models/parking'
import { ParkingService } from './services/parking.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  // your code goes here
  vehicleForm: FormGroup
  parkings: Parking[];
  parking: Parking = new Parking;
  value=0;
  constructor(private parkingService: ParkingService,private route: ActivatedRoute, private router: Router) {
    this.vehicleForm = this.createFormGroup()
  }
  createFormGroup() {
    return new FormGroup({
      vehicleLot: new FormControl(),  
      vehicleNumber: new FormControl(),
      vehicleDuration: new FormControl(),
      vehicleAmount: new FormControl(),
      })
     
  }

  calculateAmount($event){
    if(this.vehicleForm.value.vehicleDuration<60){
    this.value=20;
   this.vehicleForm.controls['vehicleAmount'].setValue(this.value);
    }
   else{
     this.value=(this.vehicleForm.value.vehicleDuration-60)*.33;
     this.vehicleForm.controls['vehicleAmount'].setValue(this.value+20);
   }
  }

  ngOnInit() {
    this.parkingService.getAllParking().subscribe(data => {
      this.parkings = data;
    });
  }
  onSubmit(){
    this.parking.lot=this.vehicleForm.value.vehicleLot;
    this.parking.vehicleNumber=this.vehicleForm.value.vehicleNumber;
    this.parking.parkingDuration=this.vehicleForm.value.vehicleDuration;
    this.parking.parkingAmount=this.vehicleForm.value.vehicleAmount;
    this.parkingService.parkNewvehicle(this.parking).subscribe(result => this.gotoUserList());
    this.parkingService.getAllParking().subscribe(data => {
      this.parkings = data;
    });
  }
  gotoUserList() {
    this.router.navigate(['parking']);
  }
}
