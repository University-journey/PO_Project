import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class Szyfr_Cezara_testy {
    @Test
    void cipher26(){
        Szyfr_Cezara a = new Szyfr_Cezara("abcdefg");
        Szyfr_Cezara b = new Szyfr_Cezara("abcdefg");
        b.cipher(26);
        assertEquals(a.getText(), b.getText());
    }
    @Test
    void cipher_decipher(){
        Szyfr_Cezara a = new Szyfr_Cezara("vjsdfkksdghfjkas");
        String x = a.getText();
        a.cipher(123);
        a.decipher(123);
        assertEquals(x, a.getText());
    }
    @Test
    void cipher4(){
        Szyfr_Cezara a = new Szyfr_Cezara("abcd");
        a.cipher(3);
        assertEquals(a.getText(), "defg");
    }
}
