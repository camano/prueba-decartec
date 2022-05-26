package com.jonathan.pruebadecartecbackend.dto;

public class ApiDto {

    private String ip;
    private String region_name;

    private String country_code;


    public ApiDto() {
    }

    public ApiDto(String region_name, String country_code) {
        this.region_name = region_name;
        this.country_code = country_code;

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

   

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    @Override
    public String toString() {
        return "ApiDto [country_code=" + country_code + ", ip=" + ip + ", region_name=" + region_name + "]";
    }

    
}
