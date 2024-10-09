package com.tercertiempo.persistencia.repositorio;

import com.tercertiempo.persistencia.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, String> {
}
