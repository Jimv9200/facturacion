package com.tercertiempo.persistencia;

import com.tercertiempo.persistencia.entities.Cliente;
import com.tercertiempo.persistencia.entities.Empleado;
import com.tercertiempo.persistencia.entities.Venta;
import com.tercertiempo.persistencia.repositorio.ClienteRepo;
import com.tercertiempo.persistencia.repositorio.EmpleadoRepo;
import com.tercertiempo.persistencia.repositorio.VentaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

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
}
