import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Pais } from '../models/Pais';

@Injectable({
  providedIn: 'root'
})
export class PaiserviceService {

  URLBACKEND=environment.backendUrl;
  constructor(private httpClient:HttpClient) { }

  getPaisesAll():Observable<Pais[]>{
    return this.httpClient.get<Pais[]>(this.URLBACKEND + 'pais/listar')
  }
  
  getFindByNombrePais(nombre:string):Observable<Pais[]>{
    return this.httpClient.get<Pais[]>(this.URLBACKEND + 'pais/consulta/' + nombre)
  }

  savePais(ip:any):Observable<Pais>{
    return this.httpClient.post<any>(this.URLBACKEND + 'pais/registro/ip',ip)
  }
}
