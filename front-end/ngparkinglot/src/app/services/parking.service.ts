import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Parking } from 'src/models/parking';

@Injectable()
export class ParkingService{
    private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/parkings';
  }
  public getAllParking(): Observable<Parking[]> {
    return this.http.get<Parking[]>(this.usersUrl);
  }

  public parkNewvehicle(parking: Parking) {
    return this.http.post<Parking>(this.usersUrl, parking);
  }
}