export class Pais {
    idPais?:number;
    horaConsulta;
    isoPais :string;
    dirrecionIp :string;
    nombrePais :string;
    constructor(horaConsulta:string,isoPais :string,dirrecionIp:string,nombrePais:string){
        this.horaConsulta=horaConsulta;
        this.isoPais=isoPais;
        this.dirrecionIp=dirrecionIp;
        this.nombrePais=nombrePais;
    }

}