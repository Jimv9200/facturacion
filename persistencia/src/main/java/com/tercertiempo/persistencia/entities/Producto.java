package com.tercertiempo.persistencia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Producto implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    @Positive
    private Double precio;
    @Positive
    private Short cantidadDisponibles;
    private Date fechaCreacion;

    @OneToMany(mappedBy = "id")
    private List<DetalleVenta> detalleVenta;

}
