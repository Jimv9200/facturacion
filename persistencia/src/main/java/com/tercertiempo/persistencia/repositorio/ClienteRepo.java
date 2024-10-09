package com.tercertiempo.persistencia.repositorio;

import com.tercertiempo.persistencia.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {
    Page<Cliente> findAll(Pageable pageable);
}
