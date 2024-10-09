package com.tercertiempo.persistencia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Empleado extends Persona implements Serializable  {
    @OneToMany(mappedBy = "empleado")
    private List<Venta> venta;

    @Column(nullable = false)
    private String password;

    public Empleado(String cedula, String nombre, String apellido, String direccion, Map<String, String> telefono, String email, String password) {
        super(cedula, nombre, apellido, direccion, telefono, email);
        this.password = password;
    }
}
