import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/Modelo/Persona';
import { CompileDirectiveMetadata } from '@angular/compiler';
@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {



  persona:Persona = new Persona();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
    this.Edit();
  }


  Edit(){
    let id=localStorage.getItem("id");
    this.service.getPersonaid(+id)
    .subscribe(data=>{
      this.persona=data;
    })
  }

  Actulizar(persona:Persona){
    this.service.updatePersona(persona)
    .subscribe(data=>{
      alert("se actulizo con exito....!!");
      this.router.navigate(["listar"]);
    })

  }


}