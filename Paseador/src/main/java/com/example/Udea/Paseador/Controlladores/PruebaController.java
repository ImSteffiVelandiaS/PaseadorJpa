package com.example.Udea.Paseador.Controlladores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class PruebaController {

    @PostMapping(value = "welcome")
    public String welcome(){
        return "Bienvenido el End point desde SECURITY";
    }
}
