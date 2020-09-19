import { Component, OnInit } from '@angular/core';
import { Persona } from "src/app/Modelo/Persona";
import { Router } from "@angular/router";
import { ServiceService } from "src/app/Service/service.service";
@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {
  
  personas:Persona[];
  constructor(private service:ServiceService, private router:Router ) { }

  ngOnInit(): void {
    this.service.getPersonas()
    .subscribe(data=>{
       this.personas = data;
    }) 
  }
  Edit(personas:Persona):void{
    localStorage.setItem("id",personas.id.toString());
    this.router.navigate(["edit"]);

  }  

  Delete(persona:Persona){
    this.service.deletePersona(persona)
    .subscribe(data=>{
      this.personas= this.personas.filter(p=>p!==persona);
      alert("Persona eliminada");
    })
  }

}