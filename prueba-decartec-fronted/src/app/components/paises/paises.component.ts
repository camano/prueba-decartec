import { Component, OnInit } from '@angular/core';
import { Pais } from 'src/app/models/Pais';
import { PaiserviceService } from 'src/app/service/paiservice.service';

@Component({
  selector: 'app-paises',
  templateUrl: './paises.component.html',
  styleUrls: ['./paises.component.css']
})
export class PaisesComponent implements OnInit {
public paises:Pais[]=[];
public nombrePais:string='';
public ip:string='';
  constructor(private paisServices : PaiserviceService) { }

  ngOnInit(): void {
    this.getPaisesAll();
  }

  getPaisesAll():void{
    this.paisServices.getPaisesAll().subscribe(
      (res)=>{
        console.log('Respuesta ::', res);
        this.paises=res
      },
      (err)=>{
        console.error('Error :: ', err);
      }
    );
  }

  getPaisesFindNombre():void{
      this.paisServices.getFindByNombrePais(this.nombrePais).subscribe(
        (res)=>{
          console.log('Respuesta :: ',res)
          this.paises=res
        },
        (err)=>{
          console.error('Error :: ', err);
          
        }
      );    
  }

  savePaises():void{
    let nombreIp={
      ip :this.ip
    }
    this.paisServices.savePais(nombreIp).subscribe(
      (res)=>{
        console.log("Respuesta :: ", res);
        this.getPaisesAll();
      },
      (err)=>{
        console.error('Error :: ', err);
        alert("No se encontro la dirrecion ip")
      }
    );
  }

}
