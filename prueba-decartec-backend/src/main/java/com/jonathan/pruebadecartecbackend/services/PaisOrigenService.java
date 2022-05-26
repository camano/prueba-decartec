package com.jonathan.pruebadecartecbackend.services;

import com.jonathan.pruebadecartecbackend.dto.PaisDto;

import java.util.List;

public interface PaisOrigenService {

     List<PaisDto> listarPaises();

     PaisDto registrarPais(String ip);

     List<PaisDto> consultarNomrePais(String nombrePais);

}
