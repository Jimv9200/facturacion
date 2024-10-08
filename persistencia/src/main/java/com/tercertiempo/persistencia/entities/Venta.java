package com.tercertiempo.persistencia.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(updatable = false)
    private Integer id;
    @Future
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private String estado;
    @Positive
    @Column(nullable = false)
    private Double total;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalles;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Empleado empleado;

}
