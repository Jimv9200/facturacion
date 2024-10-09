package com.tercertiempo.persistencia;

import com.tercertiempo.persistencia.entities.Empleado;
import com.tercertiempo.persistencia.repositorio.EmpleadoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmpleadoTest {

    @Autowired
    private EmpleadoRepo empleadoRepo;
    @Test
    public void registrarClienteTest(){
        Map<String,String> telefono = new HashMap<>();
        telefono.put("celular","3216371746");
        telefono.put("casa","6067495589");
        telefono.put("oficina","3215896545");
        Empleado empleado = new Empleado("1094908237","Jorge Iván","Martínez Vargas","Calle 24n #13-30 apto 209",telefono,"jimv9200@gmail.com","clave123");
        Empleado e = empleadoRepo.save(empleado);
        Assertions.assertNotNull(e);


    }

    @Test
    public void actualizarClienteTest(){
        Map<String,String> telefono = new HashMap<>();
        telefono.put("celular","3216371746");
        telefono.put("casa","6067495589");
        telefono.put("oficina","3215896545");
        Empleado empleado = new Empleado("1094908237","Jorge Iván","Martínez Vargas","Calle 24n #13-30 apto 209",telefono,"jimv9200@gmail.com", "clave123");
        Empleado c=empleadoRepo.save(empleado);
        Assertions.assertNotNull(c);
        c.setNombre("juanito");
        empleadoRepo.save(c);
        Empleado e2= empleadoRepo.findById("1094908237").orElse(null);
        Assertions.assertEquals("juanito",e2.getNombre());

    }
    @Test
    public void eliminarClienteTest(){
        Map<String,String> telefono = new HashMap<>();
        telefono.put("celular","3216371746");
        telefono.put("casa","6067495589");
        telefono.put("oficina","3215896545");
        Empleado empleado = new Empleado("1094908237","Jorge Iván","Martínez Vargas","Calle 24n #13-30 apto 209",telefono,"jimv9200@gmail.com","clave123");
        Empleado e=empleadoRepo.save(empleado);
        empleadoRepo.delete(e);
        Empleado clienteBucado= empleadoRepo.findById("1094908237").orElse(null);
        Assertions.assertNull(clienteBucado);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientesTest(){
        empleadoRepo.findAll().forEach(System.out::println);
    }
}
