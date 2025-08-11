package SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping({"/hello", "/hola", "/goku"})
    public String HelloWorld(){
        System.out.println("Solicitud ejecutada!!");
        return "Hello World!!";
    }
}
