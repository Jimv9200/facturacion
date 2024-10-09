package com.tercertiempo.persistencia.repositorio;


import com.tercertiempo.persistencia.entities.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VentaRepo extends JpaRepository<Venta, Integer> {

    @Query("select v from Venta v where v.estado='FINALIZADA'")
    List<Venta> listarVentasFinalizadas();

    //Consulta que muestra las ventas de determinado cliente
    @Query("select v from Venta v where v.cliente.cedula=:cedula")
    List<Venta> listarVentasPorCliente(String cedula);

    @Query("select v from Cliente c, In(c.venta) v where c.cedula=:cedula")
    List<Venta> listarVentasPorCedula(String cedula);

}
