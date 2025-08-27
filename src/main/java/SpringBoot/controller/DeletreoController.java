package SpringBoot.controller;

import SpringBoot.domain.Deletreo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para deletrear una palabra
 */
@RestController
public class DeletreoController {

    //ANTES DE SABER ANOTACIONES DE SPRING, CON JAVA PURO:
    private Deletreo msj = new Deletreo();//mala práctica

    /**
     * Endpoint para deletrear una palabra
     *
     * @param word la palabra a deletrar
     * @return array de cada letra de la palabra
     */
    @GetMapping({"/deletrear/{word}", "/deletreo/{word}"})
    public String[] deletreo(@PathVariable String word) {
        return msj.deletreo(word);
    }
}