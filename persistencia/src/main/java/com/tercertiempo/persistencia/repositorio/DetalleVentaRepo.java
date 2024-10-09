package com.tercertiempo.persistencia.repositorio;

import com.tercertiempo.persistencia.entities.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepo extends JpaRepository<DetalleVenta, Integer> {
}
