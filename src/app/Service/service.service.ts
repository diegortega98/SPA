import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Persona } from "../Modelo/Persona";
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  persona:Persona[];
  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/apiv1/personas';

  getPersonas(){
    return this.http.get<Persona[]>(this.Url);
  }

  createPersona(persona:Persona){
    return this.http.post<Persona>(this.Url,persona);
  }

  getPersonaid(id: number){
    return this.http.get<Persona>(this.Url+"/"+id);
  }


  updatePersona(employe:Persona) {
    return this.http.put(this.Url+"/"+employe.id, employe);
  }

  

  deletePersona(employe:Persona) {
    return this.http.delete(this.Url+"/"+employe.id);
  }
}
