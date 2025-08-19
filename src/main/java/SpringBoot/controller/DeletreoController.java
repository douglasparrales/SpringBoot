package SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para deletrear una palabra
 */
@RestController
public class DeletreoController {

    /**
     * Endpoint para deletrear una palabra
     * @param word la palabra a deletrar
     * @return array de cada letra de la palabra
     */
    @GetMapping({"/deletrear/{word}", "/deletreo/{word}"})
    public String[] Deletreo(@PathVariable String word){
        String[] letras = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letras[i] = String.valueOf(word.charAt(i));
        }
        return letras;
    }
}