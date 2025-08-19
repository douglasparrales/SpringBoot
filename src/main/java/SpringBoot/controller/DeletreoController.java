package SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletreoController {

    @GetMapping({"/deletrear/{word}", "/deletreo/{word}"})
    public String[] Deletreo(@PathVariable String word){
        String[] letras = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letras[i] = String.valueOf(word.charAt(i));
        }
        return letras;
    }
}