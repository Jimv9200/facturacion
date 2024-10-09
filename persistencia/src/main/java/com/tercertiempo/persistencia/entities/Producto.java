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
@ToString
public class Producto implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    @Positive
    @Column(nullable = false)
    private Double precioCompra;
    @Positive
    @Column(nullable = false)
    private Double precioVenta;
    @Positive
    @Column(nullable = false)
    private Short cantidadDisponibles;
    @Column(nullable = false)
    private Date fechaCreacion;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<DetalleVenta> detalleVenta;

    @ManyToMany()
    @ToString.Exclude
    private List<Proveedor> proveedores;

}
