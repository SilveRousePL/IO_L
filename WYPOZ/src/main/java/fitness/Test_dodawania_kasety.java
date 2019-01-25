package fitness;

import fit.ColumnFixture;
import java.util.IllegalFormatCodePointException;

public class Test_dodawania_kasety extends ColumnFixture {
    String id_filmu, dane[];

    public boolean dodaj_kasete() throws IllegalFormatCodePointException {
        int s1=liczba_kaset();
        try {
        SetUp.app.dodaj_kasete(id_filmu, dane);
            int s2=liczba_kaset();
            return s1!=s2;
        } catch(IllegalFormatCodePointException e) {
        }
        return false;
    }

    public int liczba_kaset() {
        try {
            int tmp = SetUp.app.pobierz_ilosc_kaset(id_filmu);
            return tmp;
        } catch(IllegalFormatCodePointException e) {
        }
        return 0;
    }
}