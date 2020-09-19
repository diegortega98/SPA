import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarComponent } from './Persona/listar/listar.component';
import { EditarComponent } from './Persona/editar/editar.component';
import { AgregarComponent } from './Persona/agregar/agregar.component';
import { ServiceService } from "./Service/service.service";
import { HttpClientModule } from "@angular/common/http";
import {FormsModule} from '@angular/forms'
@NgModule({
  declarations: [
    AppComponent,
    ListarComponent,
    EditarComponent,
    AgregarComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
