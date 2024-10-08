package com.tercertiempo.persistencia.entities;

import jakarta.persistence.*;
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
    @Column(nullable = false)
    private Double precio;
    @Positive
    @Column(nullable = false)
    private Short cantidadDisponibles;
    @Column(nullable = false)
    private Date fechaCreacion;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalleVenta;

    @ManyToMany()
    private List<Proveedor> proveedores;

}
