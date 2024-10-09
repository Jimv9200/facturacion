package com.tercertiempo.persistencia.repositorio;


import com.tercertiempo.persistencia.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VentaRepo extends JpaRepository<Venta, Integer> {

}
