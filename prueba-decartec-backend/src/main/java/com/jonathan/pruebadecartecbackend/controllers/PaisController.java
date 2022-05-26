package com.jonathan.pruebadecartecbackend.controllers;

import com.jonathan.pruebadecartecbackend.dto.ApiDto;
import com.jonathan.pruebadecartecbackend.services.PaisOrigenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pais")
@CrossOrigin(origins = "*")
public class PaisController {

    @Autowired
    private PaisOrigenService paisOrigenService;

    @PostMapping("/registro/ip")
    ResponseEntity<?> registroIp(@RequestBody ApiDto ip) {
        return new ResponseEntity<>(paisOrigenService.registrarPais(ip.getIp()), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    ResponseEntity<?> listar() {
        return new ResponseEntity<>(paisOrigenService.listarPaises(), HttpStatus.OK);
    }

    @GetMapping("/consulta/{nombre_pais}")
    ResponseEntity<?> consultarNombrePais(@PathVariable("nombre_pais") String nombrePais) {
        return new ResponseEntity<>(paisOrigenService.consultarNomrePais(nombrePais), HttpStatus.OK);
    }
}
