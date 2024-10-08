package com.tercertiempo.persistencia.entities;


import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.*;


import java.util.Map;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {
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
    private Map<String,String> telefono;
    @Email
    private String email;

}
