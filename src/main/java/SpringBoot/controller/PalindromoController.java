package SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase controladora que verifica si una palabra es palindormo
 */
@RestController
public class PalindromoController {

    /**
     * Endpoint para verificar si una palabra es palindromo
     * @param word palabra a verificar
     * @return "SI" si la palabra es palindromo, "NO" en caso contrario
     */
    @GetMapping({"/palindromo/{word}","/validar-palindromo/{word}"})
    public String Palindromo(@PathVariable String word){
        if (isPalindromo(word)){
            return "La palabra " + word + " es un palindromo";
        }
        return "La palabra " + word + " NO es un palindromo";
    }

    /**
     * Metodo que verifica si una palabra es un palindromo
     * @param word palabra a verificar
     * @return "true" si es palindromo, "false" en caso contrario.
     */
    private boolean isPalindromo(String word){
        int lenght = word.length();
        for (int i = 0; i < lenght/2; i++) {
            if (word.charAt(i) != word.charAt(lenght - i - 1)){
                return false;
            }
        }
        return true;
    }
}
