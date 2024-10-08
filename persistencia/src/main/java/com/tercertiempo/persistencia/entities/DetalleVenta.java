package com.tercertiempo.persistencia.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;


import java.io.Serializable;


@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Min(value = 1)
    @Column(nullable = false)
    private Integer cantidad;
    @PositiveOrZero
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Double descuento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Venta venta;

}
