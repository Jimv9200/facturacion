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
@ToString(onlyExplicitlyIncluded = true)
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(updatable = false)
    @ToString.Include
    private Integer id;
    @Future
    @Column(nullable = false)
    @ToString.Include
    private Date fecha;
    @Column(nullable = false)
    @ToString.Include
    private String estado;
    @Positive
    @Column(nullable = false)
    @ToString.Include
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
