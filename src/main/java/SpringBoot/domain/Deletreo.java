package SpringBoot.domain;

/**
 * CLASS DELETREO
 */
public class Deletreo {

    /**
     * Method deletreo words
     * @param word palabra a deletrear
     * @return palabra deltreada
     */
    public String[] deletreo(String word){
        String[] letras = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letras[i] = String.valueOf(word.charAt(i));
        }
        return letras;
    }
}
