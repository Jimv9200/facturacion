package com.tercertiempo.persistencia;

import com.tercertiempo.persistencia.entities.Producto;
import com.tercertiempo.persistencia.repositorio.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
    private ProductoRepo productoRepo;

    @Test
    public void registrarProductoTest(){
        Producto p = new Producto();
        p.setCodigo("4556622");
        p.setNombre("Gomitas");
        p.setDescripcion("Gomitas de sabores");
        p.setFechaCreacion(new Date());
        p.setPrecioCompra(1500.0);
        p.setPrecioVenta(2700.0);
        p.setCantidadDisponibles((short) 10);
        Producto p2 = productoRepo.save(p);
        Assertions.assertNotNull(p2);

    }

    @Test
    public void actualizarProductoTest(){
        Producto p = new Producto();
        p.setCodigo("4556622");
        p.setNombre("Gomitas");
        p.setDescripcion("Gomitas de sabores");
        p.setFechaCreacion(new Date());
        p.setPrecioCompra(1500.0);
        p.setPrecioVenta(2700.0);
        p.setCantidadDisponibles((short) 10);
        Producto p2 = productoRepo.save(p);
        p2.setNombre("gomitas de café");
        productoRepo.save(p2);
        Producto p3 = productoRepo.findById("4556622").orElse(null);
        Assertions.assertNotNull(p3);

    }

    @Test
    public void eliminarProductoTest(){
        Producto p = new Producto();
        p.setCodigo("4556622");
        p.setNombre("Gomitas");
        p.setDescripcion("Gomitas de sabores");
        p.setFechaCreacion(new Date());
        p.setPrecioCompra(1500.0);
        p.setPrecioVenta(2700.0);
        p.setCantidadDisponibles((short) 10);
        Producto p2 = productoRepo.save(p);
        productoRepo.delete(p2);
        Producto productoBuscado = productoRepo.findById("4556622").orElse(null);
        Assertions.assertNull(productoBuscado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosTest(){
        productoRepo.findAll().forEach(System.out::println);
    }
}
