package com.jonathan.pruebadecartecbackend.cliente;

import com.jonathan.pruebadecartecbackend.dto.ApiDto;

public interface ApiClienteService {

    ApiDto consultarApi(String ip);

}
