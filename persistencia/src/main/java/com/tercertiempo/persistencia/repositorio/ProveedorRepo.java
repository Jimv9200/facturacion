package com.tercertiempo.persistencia.repositorio;

import com.tercertiempo.persistencia.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepo extends JpaRepository<Proveedor, Integer> {
}
