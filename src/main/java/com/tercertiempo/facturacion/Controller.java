package com.tercertiempo.facturacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String index(){
        return "hola mundo ya son las 11";
    }
}
