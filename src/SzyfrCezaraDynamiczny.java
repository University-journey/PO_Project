public class SzyfrCezaraDynamiczny extends SzyfrCezara {

    // przy szyfrowaniu, co każdy znak shift będzie zwiększony o dynamiczność
    // (np. co dziesiąty znak, dla dynamicznosc == 0.1)
    private double dynamicznosc;

    public SzyfrCezaraDynamiczny(String s, double dynamicznosc) {
        super(s);
        this.dynamicznosc = dynamicznosc;
    }

    @Override
    public void cipher(int shift) {

        double additionalShift = 0;
        int dlugoscTekstu = super.text.length();
        int ileSubstringow = (int) Math.round(
                dlugoscTekstu * Math.max(this.dynamicznosc, 1)
        );
        int dlugoscSubstringu = dlugoscTekstu / ileSubstringow;
        
       String ciphredText = "", substring;
       SzyfrCezara temp;
       for (int i = 0; i <= dlugoscTekstu; i += dlugoscSubstringu) {
           substring = super.text.substring(i, i+dlugoscSubstringu);
           temp = new SzyfrCezara(substring);
           temp.cipher(shift + (int)additionalShift);
           ciphredText += temp.text;
           additionalShift += this.dynamicznosc;
       }

       super.text = ciphredText;

    }//cipher

}//class SzyfrCezaraDynamiczny
