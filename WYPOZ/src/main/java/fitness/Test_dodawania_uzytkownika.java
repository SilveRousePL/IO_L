package fitness;

import fit.ColumnFixture;
import java.util.IllegalFormatCodePointException;

public class Test_dodawania_uzytkownika extends ColumnFixture {
    String dane[];

    public boolean dodaj_uzytkownika() throws IllegalFormatCodePointException {
        int s1=liczba_uzytkownikow();
        try {
            SetUp.app.dodaj_uzytkownika(dane);
            int s2=liczba_uzytkownikow();
            return s1!=s2;
        } catch(IllegalFormatCodePointException e) {
        }
        return false;
    }

    public int liczba_uzytkownikow() {
        return SetUp.app.getUzytkownicy().size();
    }
}