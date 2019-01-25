package fitness;

import fit.ColumnFixture;
import java.util.IllegalFormatCodePointException;

public class Test_zamawiania extends ColumnFixture {
    String id_uzytkownika, id_filmu;

    public boolean zamow() throws IllegalFormatCodePointException {
        int s1=liczba_zamowien();
        try {
            SetUp.app.wypozyczenie(id_filmu, id_uzytkownika);
            int s2=liczba_zamowien();
            return s1!=s2;
        } catch(IllegalFormatCodePointException e) {
        }
        return false;
    }

    public int liczba_zamowien() {
        try {
            int tmp = SetUp.app.pobierz_ilosc_zamowien(id_uzytkownika);
            return tmp;
        } catch(IllegalFormatCodePointException e) {
        }
        return 0;
    }
}