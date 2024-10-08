package com.tercertiempo.persistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Cliente extends Persona implements Serializable{
    @OneToMany(mappedBy = "id")
    private List<Venta> venta;

}
