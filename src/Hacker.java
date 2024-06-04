import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Hacker {


    private static int dlugoscAlfabetu = 26;
    private static List<Character> literyWgCzestosci = List.of(
            'E', 'T', 'A', 'O',
            'I', 'N', 'S', 'H', 'R', 'D',
            'L', 'C', 'U', 'M', 'W', 'F',
            'G', 'Y', 'P', 'B', 'V', 'K',
            'J', 'X', 'Q', 'Z');


    private final char[] tekst;
    private Map<Character,Integer> wystapienia = null;
    private Integer przesuniecie = null;


    public Hacker(String tekst) {
        this.tekst = tekst.toCharArray();
        this.wystapienia = new HashMap<>();
        for (char litera : Hacker.literyWgCzestosci)
            this.wystapienia.put(litera,0);
    }


    private void policzWystapienia() {
        for (char litera : this.tekst) {
            int ileRazy;
            if (litera >= 'a' && litera <= 'z') {
                ileRazy = this.wystapienia.get(Character.toUpperCase(litera));
                this.wystapienia.put(Character.toUpperCase(litera),++ileRazy);
            }
            if (litera >= 'A' && litera <= 'Z') {
                ileRazy = this.wystapienia.get(litera);
                this.wystapienia.put(litera,++ileRazy);
            }
        }
    }


    private List<Character> literyWTekscieOdNajczestszych() {

        if (this.wystapienia == null)
            this.policzWystapienia();

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(this.wystapienia.entrySet());
        list.sort(Map.Entry.comparingByValue());

        List<Character> wynik = new ArrayList<>(Hacker.dlugoscAlfabetu);
        for (Map.Entry<Character,Integer> para : list)
            wynik.add(para.getKey());

        return wynik;

    }//literyWTekscieOdNajczestszych


    public int znajdzPrzesuniecie() {

        if (this.przesuniecie != null)
            return this.przesuniecie;

        List<Character> najczestsze = this.literyWTekscieOdNajczestszych();

        int sumaPrzesuniec = 0;
        for (int i = 0; i < Hacker.dlugoscAlfabetu; ++i) {
            sumaPrzesuniec += Hacker.literyWgCzestosci.get(i);
            sumaPrzesuniec -= najczestsze.get(i);
        }

        return (int)((sumaPrzesuniec+0.5) / Hacker.dlugoscAlfabetu);

    }//znajdzPrzesuniecie


}//class Hacker
