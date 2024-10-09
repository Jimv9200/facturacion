package com.tercertiempo.persistencia.repositorio;

import com.tercertiempo.persistencia.entities.Producto;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, String> {
}
