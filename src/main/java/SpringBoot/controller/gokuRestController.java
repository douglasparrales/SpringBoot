package SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class gokuRestController {

    @GetMapping({"/saludo"})
    public String Goku(){
        System.out.println("Solicitud de Goku Ejecutada");
        return "Hola soy Goku!";
    }
}
