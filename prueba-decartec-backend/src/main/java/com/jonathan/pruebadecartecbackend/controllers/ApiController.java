package com.jonathan.pruebadecartecbackend.controllers;

import com.jonathan.pruebadecartecbackend.cliente.ApiClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prueba")
public class ApiController {

    @Autowired
    private ApiClienteService apiClienteService;

    @GetMapping("/consultar/{ip}")
    public ResponseEntity<?> resultado(@PathVariable("ip") String ip) {
        return new ResponseEntity<>(apiClienteService.consultarApi(ip), HttpStatus.ACCEPTED);
    }

}
