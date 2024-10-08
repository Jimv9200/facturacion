package com.tercertiempo.persistencia.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;
    @Column(nullable = false)
    private String nombre;
    @ElementCollection
    private Map<String,String> telefonos;

    @ManyToMany(mappedBy = "proveedores")
    private List<Producto> productos;
}
