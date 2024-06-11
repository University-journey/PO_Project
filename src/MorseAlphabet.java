import java.util.HashMap;
import java.util.Map;

public class MorseAlphabet {

    protected String textToCrypt;
    private Map<Character, String> toMorse = new HashMap<>();
    private Map<String, Character> toLetters = new HashMap<>();

    public String getText() {
        return textToCrypt;
    }
    public MorseAlphabet(String str){
        textToCrypt = str;
        fillTranslation();
    }

    private void fillTranslation() {
        toMorse.put('a', ".-");
        toMorse.put('b', "-...");
        toMorse.put('c', "-.-.");
        toMorse.put('d', "-..");
        toMorse.put('e', ".");
        toMorse.put('f', "..-.");
        toMorse.put('g', "--.");
        toMorse.put('h', "....");
        toMorse.put('i', "..");
        toMorse.put('j', ".---");
        toMorse.put('k', "-.-");
        toMorse.put('l', ".-..");
        toMorse.put('m', "--");
        toMorse.put('n', "-.");
        toMorse.put('o', "---");
        toMorse.put('p', ".--.");
        toMorse.put('q', "--.-");
        toMorse.put('r', ".-.");
        toMorse.put('s', "...");
        toMorse.put('t', "-");
        toMorse.put('u', "..-");
        toMorse.put('v', "...-");
        toMorse.put('w', ".--");
        toMorse.put('x', "-..-");
        toMorse.put('y', "-.--");
        toMorse.put('z', "--..");
        toMorse.put('1', ".----");
        toMorse.put('2', "..---");
        toMorse.put('3', "...--");
        toMorse.put('4', "....-");
        toMorse.put('5', ".....");
        toMorse.put('6', "-....");
        toMorse.put('7', "--...");
        toMorse.put('8', "---..");
        toMorse.put('9', "----.");
        toMorse.put('0', "-----");

        // tworzenie odwrotnego Hashmap
        for (Map.Entry<Character, String> entr : toMorse.entrySet()) {
            toLetters.put(entr.getValue(), entr.getKey());
        }
    }

    public String encrypt() {
        String encrypted = "";
        for (int i = 0; i < textToCrypt.length(); i++) {
            char character = textToCrypt.charAt(i);
            String morseCode = toMorse.get(character);
            if (morseCode != null) {
                encrypted += morseCode + " ";
            }
        }
        return encrypted.toString().trim();         // pozbycie się zbędnych spacji (do assertEquals)
    }

    public String decrypt() {
        String decrypted = "";
        for (String morseCode : textToCrypt.split(" ")) {
            Character character = toLetters.get(morseCode);
            if (character != null) {
                decrypted += character;
            }
        }
        return decrypted;
    }
}