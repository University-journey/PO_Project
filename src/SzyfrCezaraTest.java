import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class SzyfrCezaraTest {

    @Test
    void cipher_decipher(){
        SzyfrCezara a = new SzyfrCezara("vjsdfkksdghfjkas");
        String x = a.getText();
        a.cipher(123);
        a.decipher(123);
        assertEquals(x, a.getText());
    }
    @Test
    void cipher3(){
        SzyfrCezara a = new SzyfrCezara("abcd");
        a.cipher(3);
        assertEquals(a.getText(), "defg");
    }
    @Test
    void ignorespaces(){
        SzyfrCezara a = new SzyfrCezara("abc cba");
        a.cipher(2);
        assertEquals(a.getText(), "cde edc");
    }
}
