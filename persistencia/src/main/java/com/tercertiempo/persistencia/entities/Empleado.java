package com.tercertiempo.persistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Empleado extends Persona implements Serializable  {
    @OneToMany(mappedBy = "empleado")
    private List<Venta> venta;

}
