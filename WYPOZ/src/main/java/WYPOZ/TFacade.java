package WYPOZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class TFacade {

    private ArrayList<Uzytkownik> uzytkownicy = new ArrayList();
    private ArrayList<Zamowienie> zamowienia = new ArrayList();
    private ArrayList<Film> filmy = new ArrayList();

    private Uzytkownik znajdz_uzytkownika(Uzytkownik uzyt) {
        int index = uzytkownicy.indexOf(uzyt);
        if (index != -1) {
           return uzytkownicy.get(index);
        }
        return null;
    }

    public boolean dodaj_uzytkownika(String[] dane) {
        Uzytkownik uzyt = TFactory.utworz_uzytkownika(dane);
        if (znajdz_uzytkownika(uzyt) == null) {
            uzytkownicy.add(uzyt);
            return true;
        }
        return false;
    }
    
    private Film znajdz_film(Film film) {
        int index = filmy.indexOf(film);
        if (index != -1) {
          return filmy.get(index);
        }
        return null;
    }

    public boolean dodaj_film(String[] dane) throws IllegalFormatCodePointException {
        Film ff = TFactory.utworz_film(dane);
        if (znajdz_film(ff) == null) {
            return filmy.add(ff);
        }
        return false;
    }

    public boolean dodaj_kasete(String id_filmu, String[] dane_kasety) throws IllegalFormatCodePointException {
        Film ff = TFactory.utworz_wzorzec_filmu(id_filmu);
        Film szuk_film = znajdz_film(ff);    
        if (szuk_film == null) {
            return false;
        }
        return szuk_film.dodaj_kasete(dane_kasety);
    }
    
    public int pobierz_ilosc_kaset(String id_filmu) throws IllegalFormatCodePointException {
        Film ff = TFactory.utworz_wzorzec_filmu(id_filmu);
        Film szuk_film = znajdz_film(ff);    
        if (szuk_film == null) {
            return 0;
        }
        return szuk_film.ilosc_kaset();
    }
    
    public int pobierz_ilosc_zamowien(String id_uzytkownika) throws IllegalFormatCodePointException {
        Uzytkownik uu = TFactory.utworz_wzorzec_uzytkownika(id_uzytkownika);
        Uzytkownik szuk_uzyt = znajdz_uzytkownika(uu);    
        if (szuk_uzyt == null) {
            return 0;
        }
        return szuk_uzyt.ilosc_zamowien();
    }

    public String[][] wylistuj_filmy() {
        int size = filmy.size();
        String[][] o = new String[size][5];
        for (int i = 0; i < filmy.size(); i++) {
            Film ff = filmy.get(i);
            o[i] = ff.toStrArray();
        }
        return o;
    }

    public boolean wypozyczenie(String ID_filmu, String ID_uzytkownika) {
        Uzytkownik wzor_uzytkownik = TFactory.utworz_wzorzec_uzytkownika(ID_uzytkownika);
        Uzytkownik uzytkownik = znajdz_uzytkownika(wzor_uzytkownik);
        if (uzytkownik == null) {
            System.err.println("Brak uzyt");
            return false;
        }
        Film wzor_film = TFactory.utworz_wzorzec_filmu(ID_filmu);
        Film film = znajdz_film(wzor_film);
        if (film == null) {
            System.err.println("Brak filmu");
            return false;
        }
        Kaseta kaseta = film.znajdz_wolna_kasete();
        if (kaseta == null) {
            System.err.println("Brak kasety");
            return false;
        }
        Zamowienie zamowienie = uzytkownik.dodaj_zamowienie(kaseta);
        kaseta.wypozycz();
        zamowienia.add(zamowienie);
        return true;
    }

    public int przyjmowanie_zwrotu(int ID_klienta, int ID_zamowienia) {
        Uzytkownik u = TFactory.utworz_wzorzec_uzytkownika(Integer.toString(ID_klienta));
        Uzytkownik uzytkownik = znajdz_uzytkownika(u);
        if (uzytkownik == null) {
            System.err.println("Brak uzyt");
            return 0;
        }
        Zamowienie zamowienie = uzytkownik.znajdz_zamowienie(""+ID_zamowienia);
        if (zamowienie == null) {
            System.err.println("Brak zam");
            return 0;
        }
        return uzytkownik.zakoncz(zamowienie);
        //kaseta.zwolnij() -> zamowienie.zakoncz();
    }

    public String[][] generowanie_listy_ponaglen() {
        if (uzytkownicy == null) {
            uzytkownicy = new ArrayList<>();
        }
        ArrayList<String[]> o = new ArrayList<>();
        uzytkownicy.forEach((uu) -> {
            o.add( uu.zamowienia_do_ponagleniaToStrArray());
        });
        return (String[][]) o.toArray(new String[o.size()][5]);
    }

    public String[][] generuj_liste_zamowien_do_wysylki() {
        if (uzytkownicy == null) {
            uzytkownicy = new ArrayList<>();
        }
        ArrayList<String[]> o = new ArrayList<>();
        uzytkownicy.forEach((uu) -> {
            o.add(uu.zamowienia_do_wyslaniaToStrArray());
        });
        return (String[][]) o.toArray(new String[o.size()][4]);
    }

    // tylko do testów
    public ArrayList<Uzytkownik> getUzytkownicy() {
        return uzytkownicy;
    }
    
    // tylko do testów
    public ArrayList<Film> getFilmy() {
        return filmy;
    }

    public static void main(String t[]) throws IllegalFormatCodePointException {
        TFacade app = new TFacade();
        app.wylistuj_filmy();
        String film1[] = { "1", "Tytanic", "1997", "USA", "James Cameron"};
        String film2[] = { "2", "Avatar", "2009", "USA", "James Cameron"};
        app.dodaj_film(film1);
        app.dodaj_film(film2);
        app.dodaj_film(film2);
        System.out.println(app.getFilmy());
        String kaseta1[] = {"1337"};
        String kaseta2[] = {"2321"};
        String kaseta3[] = {"1327"};
        String kaseta4[] = {"2341"};
        app.dodaj_kasete(film1[0], kaseta1);
        app.dodaj_kasete(film1[0], kaseta2);
        app.dodaj_kasete(film2[0], kaseta3);
        app.dodaj_kasete(film2[0], kaseta4);
        System.out.println(app.getFilmy());
        //System.out.println(app.getFilmy().get(0).getKasety());
        //System.out.println(app.getFilmy().get(1).getKasety());
        String uzyt[] = {"1", "jan", "nowak", "borowska 14", "9901010111"};
        app.dodaj_uzytkownika(uzyt);
        app.dodaj_uzytkownika(uzyt);
        System.out.println(app.getUzytkownicy());
        app.wypozyczenie("1", "1");
        app.wypozyczenie("1", "1");
        app.wypozyczenie("1", "1"); //tylko dwie wolne kasety tego filmu powinno wyswietlic tylko 2 wyniki
        System.out.println(app.getUzytkownicy().get(0).get_zamowienia().get(0).toString());
        app.getUzytkownicy().get(0).get_zamowienia().get(0).wyslano();
        System.out.println(Arrays.deepToString(app.generuj_liste_zamowien_do_wysylki()));
        System.out.println("===");
        /*for (int i =0; i<655000000; i++){  
            Thread.sleep(655000000);      
        }*/
        System.out.println(Arrays.deepToString(app.generowanie_listy_ponaglen()));
        System.out.println("Kara: "+app.przyjmowanie_zwrotu(1,1));
        System.out.println("===");
        System.out.println(Arrays.deepToString(app.generowanie_listy_ponaglen()));
    }
}
