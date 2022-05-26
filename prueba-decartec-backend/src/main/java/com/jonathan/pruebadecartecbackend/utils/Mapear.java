package com.jonathan.pruebadecartecbackend.utils;

import com.jonathan.pruebadecartecbackend.dto.PaisDto;
import com.jonathan.pruebadecartecbackend.entity.PaisOrigen;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapear {

    @Autowired
    private ModelMapper modelMapper;

    public PaisDto mapearDtoToEntity (PaisOrigen paisOrigen){
        return  this.modelMapper.map(paisOrigen,PaisDto.class);
    }

    public PaisOrigen mapearEntityToDto (PaisDto paisDto){
        return this.modelMapper.map(paisDto,PaisOrigen.class);
    }
}
