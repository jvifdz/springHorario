package com.javierfernandez.springboot.horariointerceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    //Value para inyectar cosas del properties
    @Value("${config.horario.apertura}")
    private Integer apertura;
    @Value("${config.horario.cierre}")
    private Integer cierre;


    @GetMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("titulo","Bienvendio al horario de atención a clientes");
        return "index";
    }
    @GetMapping("/cerrado")
    public String cerrrado(Model model){
        //apend para concatenar en el String builder
        StringBuilder mensaje = new StringBuilder("Cerrado, por favor visítenos desde las ");
        mensaje.append(apertura);
        mensaje.append(" y las ");
        mensaje.append(cierre);
        mensaje.append(" hrs. Gracias ");
        model.addAttribute("titulo","Fuera del horario de atención");
        model.addAttribute("mensaje", mensaje);
        return "cerrado";

    }
}
