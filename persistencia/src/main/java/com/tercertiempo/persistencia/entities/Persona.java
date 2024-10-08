package com.tercertiempo.persistencia.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;


import java.io.Serializable;
import java.util.Map;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10, updatable = false)
    private String cedula;
    @Column(length = 200, nullable = false)
    private String nombre;
    @Column(length = 200, nullable = false)
    private String apellido;
    private String direccion;
    @ElementCollection
    @Column(nullable = false)
    private Map<String,String> telefono;
    @Email
    private String email;

}
