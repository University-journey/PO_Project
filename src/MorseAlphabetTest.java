import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MorseAlphabetTest {

    @Test
    void encryptText() {
        MorseAlphabet t1 = new MorseAlphabet("help");
        assertEquals(".... . .-.. .--.", t1.encrypt());
    }

    @Test
    void decryptText(){
        MorseAlphabet t2 = new MorseAlphabet("... --- ...");
        assertEquals("sos", t2.decrypt());
    }


    @Test
    void cryptBothWays(){
        MorseAlphabet t3 = new MorseAlphabet("test");
        String encrypted = t3.encrypt();
        MorseAlphabet t4 = new MorseAlphabet(encrypted);
        assertEquals("test", t4.decrypt());

        MorseAlphabet t5 = new MorseAlphabet("morse");
        String encrypted2 = t5.encrypt();
        MorseAlphabet t6 = new MorseAlphabet(encrypted2);
        assertEquals("morse", t6.decrypt());
    }
}