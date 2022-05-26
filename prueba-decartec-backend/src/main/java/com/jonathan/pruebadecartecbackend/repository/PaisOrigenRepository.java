package com.jonathan.pruebadecartecbackend.repository;

import com.jonathan.pruebadecartecbackend.entity.PaisOrigen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisOrigenRepository extends JpaRepository<PaisOrigen,Long> {
}
