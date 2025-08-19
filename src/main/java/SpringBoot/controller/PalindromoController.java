package SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromoController {

    @GetMapping({"/palindromo/{word}","/validar-palindromo/{word}"})
    public String Palindromo(@PathVariable String word){
        int lenght = word.length();
        
        return "";
    }
}
