package com.tercertiempo.persistencia;

import com.tercertiempo.persistencia.entities.Cliente;
import com.tercertiempo.persistencia.entities.Empleado;
import com.tercertiempo.persistencia.entities.Venta;
import com.tercertiempo.persistencia.repositorio.ClienteRepo;
import com.tercertiempo.persistencia.repositorio.EmpleadoRepo;
import com.tercertiempo.persistencia.repositorio.VentaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VentaTest {
    @Autowired
    private VentaRepo ventaRepo;
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private EmpleadoRepo empleadoRepo;
    @Test
    public void crearVentaTest() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Cliente");
        cliente.setApellido("Apellido");
        cliente.setDireccion("Direccion");
        cliente.setEmail("email@email.com");
        cliente.setCedula("123456789");
        clienteRepo.save(cliente);
        Empleado empleado = new Empleado();
        empleado.setNombre("Empleado");
        empleado.setApellido("Apellido");
        empleado.setDireccion("Direccion");
        empleado.setEmail("email@email.com");
        empleado.setCedula("987654321");
        empleado.setPassword("clave123");
        empleadoRepo.save(empleado);
        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setEmpleado(empleado);
        venta.setEstado("EN_PROCESO");
        venta.setFecha(new Date(2024));
        venta.setTotal(0.0);
        ventaRepo.save(venta);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarVentasTest(){
        ventaRepo.findAll().forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarVentasFinalizadasTest(){
        ventaRepo.listarVentasFinalizadas().forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarVentasPorClienteTest(){
        List<Venta> ventaList= ventaRepo.listarVentasPorCliente("1094908238");
        ventaList.forEach(System.out::println);
        Assertions.assertEquals(2, ventaList.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarVentasPorCedulaTest(){
        List<Venta> ventaList= ventaRepo.listarVentasPorCedula("1094908238");
        ventaList.forEach(System.out::println);
        Assertions.assertEquals(2, ventaList.size());
    }
}
