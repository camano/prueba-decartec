package com.jonathan.pruebadecartecbackend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "paisOrigen")
public class PaisOrigen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    private LocalTime horaConsulta;
    private String nombrePais;
    private String isoPais;
    private String dirrecionIp;

    public PaisOrigen() {
    }

    public PaisOrigen(LocalTime horaConsulta, String nombrePais, String isoPais, String dirrecionIp) {
        this.horaConsulta = horaConsulta;
        this.nombrePais = nombrePais;
        this.isoPais = isoPais;
        this.dirrecionIp = dirrecionIp;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getIsoPais() {
        return isoPais;
    }

    public void setIsoPais(String isoPais) {
        this.isoPais = isoPais;
    }

    public String getDirrecionIp() {
        return dirrecionIp;
    }

    public void setDirrecionIp(String dirrecionIp) {
        this.dirrecionIp = dirrecionIp;
    }

    @Override
    public String toString() {
        return "PaisOrigen{" + "idPais=" + idPais + ", horaConsulta=" + horaConsulta + ", nombrePais='" + nombrePais + '\'' + ", isoPais='" + isoPais + '\'' + ", dirrecionIp='" + dirrecionIp + '\'' + '}';
    }
}
