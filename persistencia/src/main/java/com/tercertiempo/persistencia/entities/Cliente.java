package com.tercertiempo.persistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@ToString(callSuper = true)
public class Cliente extends Persona implements Serializable{
    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<Venta> venta;

    public Cliente(String cedula, String nombre, String apellido, String direccion, Map<String, String> telefono, String email) {
        super(cedula, nombre, apellido, direccion, telefono, email);

    }


    public Cliente() {
        super();
    }
}
