package com.tercertiempo.persistencia.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;


import java.io.Serializable;
import java.util.Map;


@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
@ToString(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10, updatable = false)
    @ToString.Include
    private String cedula;
    @Column(length = 200, nullable = false)
    @ToString.Include
    private String nombre;
    @Column(length = 200, nullable = false)
    @ToString.Include
    private String apellido;
    @ToString.Include
    private String direccion;
    @ElementCollection
    @Column(nullable = false)
    private Map<String,String> telefono;
    @Email
    @ToString.Include
    private String email;

    public Persona(String cedula, String nombre, String apellido, String direccion, Map<String, String> telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    public Persona() {}


}
