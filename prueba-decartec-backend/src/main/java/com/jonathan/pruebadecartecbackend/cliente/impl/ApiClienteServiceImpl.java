package com.jonathan.pruebadecartecbackend.cliente.impl;

import com.jonathan.pruebadecartecbackend.cliente.ApiClienteService;
import com.jonathan.pruebadecartecbackend.dto.ApiDto;
import com.jonathan.pruebadecartecbackend.utils.ConstantesGlobales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiClienteServiceImpl implements ApiClienteService {

    private final static Logger logger = LoggerFactory.getLogger(ApiClienteServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("app.access_key")
    private String accesKey;

    @Override
    public ApiDto consultarApi(String ip) {
        try {
            logger.info("Acces key :: " + accesKey);
            HttpEntity<ApiDto> entity = new HttpEntity<ApiDto>(getHeaders());
            ResponseEntity<ApiDto> responseEntity = restTemplate.exchange(
                    ConstantesGlobales.URLAPI + ip + "?access_key=cfecd68018d2e636348daf7ef9510596", HttpMethod.GET,
                    entity, ApiDto.class);
            logger.info("Respuesta :: " + responseEntity.getBody());
            return responseEntity.getBody();
        } catch (RestClientException k) {
            logger.error("Hubo un error en el cliente: " + k.getMessage());
            return null;

        }

    }

    private HttpHeaders getHeaders() {

        return new HttpHeaders();
    }
}
