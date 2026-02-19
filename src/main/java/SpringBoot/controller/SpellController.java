package SpringBoot.controller;

import SpringBoot.service.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para deletrear una palabra
 */
@RestController
@RequestMapping({"/spell", "/deletreo"})
public class SpellController {

    //ANTES DE SABER ANNOTATION DE SPRING, CON JAVA PURO:
    //private SpellService msj = new SpellService();//mala practice

    //I know the annotation service and autowired now:
    @Autowired
    @Lazy
    private SpellService spellService;

    /**
     * Endpoint para deletrear una palabra
     *
     * @param word la palabra a deletrar
     * @return array de cada letra de la palabra
     */
    @GetMapping("/{word}")
    public ResponseEntity<?> spell(@PathVariable String word) {
        return ResponseEntity.ok().body(spellService.spell(word));
    }
}