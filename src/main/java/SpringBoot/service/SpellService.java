package SpringBoot.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * CLASS SPELL
 */
@Lazy
@Service
public class SpellService {

    /**
     * Method spell words
     * @param word palabra a spelled
     * @return palabra spelled
     */

    public SpellService(){
        System.out.println("Instance de la class SpellService");
    }

    public String[] spell(String word){
        String[] letter = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letter[i] = String.valueOf(word.charAt(i));
        }
        return letter;
    }
}
