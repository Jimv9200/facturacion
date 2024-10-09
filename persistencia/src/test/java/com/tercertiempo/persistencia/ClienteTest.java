package com.tercertiempo.persistencia;

import com.tercertiempo.persistencia.entities.Cliente;

import com.tercertiempo.persistencia.repositorio.ClienteRepo;
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
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;



    @Test
    public void registrarClienteTest(){
        Map<String,String> telefono = new HashMap<>();
        telefono.put("celular","3216371746");
        telefono.put("casa","6067495589");
        telefono.put("oficina","3215896545");
        Cliente cliente = new Cliente("1094908237","Jorge Iván","Martínez Vargas","Calle 24n #13-30 apto 209",telefono,"jimv9200@gmail.com");
        Cliente c=clienteRepo.save(cliente);
        Assertions.assertNotNull(c);


    }

    @Test
    public void actualizarClienteTest(){
        Map<String,String> telefono = new HashMap<>();
        telefono.put("celular","3216371746");
        telefono.put("casa","6067495589");
        telefono.put("oficina","3215896545");
        Cliente cliente = new Cliente("1094908237","Jorge Iván","Martínez Vargas","Calle 24n #13-30 apto 209",telefono,"jimv9200@gmail.com");
        Cliente c=clienteRepo.save(cliente);
        Assertions.assertNotNull(c);
        c.setNombre("juanito");
        clienteRepo.save(c);
        Cliente c2= clienteRepo.findById("1094908237").orElse(null);
        Assertions.assertEquals("juanito",c2.getNombre());

    }
    @Test
    public void eliminarClienteTest(){
        Map<String,String> telefono = new HashMap<>();
        telefono.put("celular","3216371746");
        telefono.put("casa","6067495589");
        telefono.put("oficina","3215896545");
        Cliente cliente = new Cliente("1094908237","Jorge Iván","Martínez Vargas","Calle 24n #13-30 apto 209",telefono,"jimv9200@gmail.com");
        Cliente c=clienteRepo.save(cliente);
        clienteRepo.delete(c);
        Cliente clienteBucado= clienteRepo.findById("1094908237").orElse(null);
        Assertions.assertNull(clienteBucado);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientesTest(){
        clienteRepo.findAll().forEach(System.out::println);
    }
}
