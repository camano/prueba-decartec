package com.jonathan.pruebadecartecbackend.services.impl;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jonathan.pruebadecartecbackend.cliente.ApiClienteService;
import com.jonathan.pruebadecartecbackend.dto.ApiDto;
import com.jonathan.pruebadecartecbackend.dto.PaisDto;
import com.jonathan.pruebadecartecbackend.entity.PaisOrigen;
import com.jonathan.pruebadecartecbackend.excepciones.PaisException;
import com.jonathan.pruebadecartecbackend.repository.PaisOrigenRepository;
import com.jonathan.pruebadecartecbackend.services.PaisOrigenService;
import com.jonathan.pruebadecartecbackend.utils.Mapear;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PaisOrigenServiceImpl implements PaisOrigenService {

    private final static Logger logger = LoggerFactory.getLogger(PaisOrigenServiceImpl.class);

    @Autowired
    private PaisOrigenRepository paisOrigenRepository;

    @Autowired
    private ApiClienteService apiClienteService;

    @Autowired
    private Mapear mapear;

    @Override
    public List<PaisDto> listarPaises() {
        List<PaisOrigen> listaPaises= paisOrigenRepository.findAll();

        return listaPaises.stream().map(paisOrigen -> mapear.mapearDtoToEntity(paisOrigen)).collect(Collectors.toList());
    }

    @Override
    public PaisDto registrarPais(String ip) {
        try {
            ApiDto consultarApi = apiClienteService.consultarApi(ip);

            if(consultarApi.getIp() == null){
                logger.error("No se encontro ningun dirrecion");
                throw new PaisException(HttpStatus.BAD_REQUEST,"No se encontro ninguna dirrecion");
            }
            logger.info("Resultado  :: "+ consultarApi);
            PaisOrigen paisOrigen = new PaisOrigen();
            paisOrigen.setNombrePais(consultarApi.getRegion_name());
            paisOrigen.setDirrecionIp(consultarApi.getIp());
            paisOrigen.setIsoPais(consultarApi.getCountry_code());
            paisOrigen.setHoraConsulta(LocalTime.now());
            PaisOrigen registarPais=paisOrigenRepository.save(paisOrigen);
            logger.info("Datos registrados " + registarPais);
            return mapear.mapearDtoToEntity(registarPais);
        }catch (DataIntegrityViolationException sqlExceptionHelper){
            throw new PaisException(HttpStatus.BAD_REQUEST, "Hubo un error en registrar el pais");
        }

    }

    @Override
    public List<PaisDto> consultarNomrePais(String nombrePais) {
        logger.info("Nombre pais :: "+nombrePais);
        List<PaisOrigen> listarNombrePais=paisOrigenRepository.findAll();
        logger.info("lista de paises :: "+listarNombrePais);
        return listarNombrePais.stream()
                .map(paisOrigen -> mapear.mapearDtoToEntity(paisOrigen))
                .filter(paisDto -> paisDto.getNombrePais().equalsIgnoreCase(nombrePais))
                .collect(Collectors.toList());
    }

}
