import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/Modelo/Persona';


@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponent implements OnInit {

  persona: Persona = new Persona();

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
  }
  
  Guardar(){
    this.service.createPersona(this.persona)
    .subscribe(data=>{
      alert("se agrego con exito...!!!");
      this.router.navigate(["listar"]);
    })

  }

}