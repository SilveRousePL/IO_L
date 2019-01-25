package fitness;

import fit.ColumnFixture;
import java.util.IllegalFormatCodePointException;

public class Test_dodawania_filmu extends ColumnFixture {
    String dane[];

    public boolean dodaj_film() throws IllegalFormatCodePointException {
        int s1=liczba_filmow();
        try {
            SetUp.app.dodaj_film(dane);
            int s2=liczba_filmow();
            return s1!=s2;
        } catch(IllegalFormatCodePointException e) {
        }
        return false;
    }

    public int liczba_filmow() {
        return SetUp.app.getFilmy().size();
    }
}