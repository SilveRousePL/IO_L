package WYPOZ;

import java.util.IllegalFormatCodePointException;
import java.util.regex.Pattern;


public class TFactory {

    public static Zamowienie utworz_zamowienie(Uzytkownik klient, Kaseta kaseta) {
        Zamowienie z = klient.dodaj_zamowienie(kaseta);
        return z;
    }
 
    public static Kaseta utworz_kasete(String[] dane, Film film) throws IllegalFormatCodePointException{
        if(!Pattern.compile("[0-9]+").matcher(dane[0]).matches())
            throw new IllegalFormatCodePointException(3); 
        if( dane.length>1 && !Pattern.compile("[0-9]+").matcher(dane[1]).matches())
            throw new IllegalFormatCodePointException(4); 
        Kaseta k = new Kaseta(dane,film);
        return k;
    }
   
    public static Film utworz_film(String[] dane) throws IllegalFormatCodePointException{
        if(!Pattern.compile("[0-9]+").matcher(dane[0]).matches())
            throw new IllegalFormatCodePointException(1);
        if(!Pattern.compile("[0-9]+").matcher(dane[2]).matches())
            throw new IllegalFormatCodePointException(2);   
        Film f = new Film(dane);
        return f;
    }
  
    public static Uzytkownik utworz_uzytkownika(String[] dane) {
        if(!Pattern.compile("[0-9]+").matcher(dane[0]).matches())
            throw new IllegalFormatCodePointException(1);
        if(!Pattern.compile("[0-9]+").matcher(dane[4]).matches())
            throw new IllegalFormatCodePointException(1);
        Uzytkownik u = new Uzytkownik(dane);
        return u;
    }

    public static Uzytkownik utworz_wzorzec_uzytkownika(String dane) {
        if(!Pattern.compile("[0-9]+").matcher(dane).matches())
            throw new IllegalFormatCodePointException(1);
        String[] daneArray = new String[1];
        daneArray[0]=dane;
        Uzytkownik u = new Uzytkownik(daneArray);
        return u;
    }

    public static Film utworz_wzorzec_filmu(String dane) {
        if(!Pattern.compile("[0-9]+").matcher(dane).matches())
            throw new IllegalFormatCodePointException(1);
        String[] daneArray = new String[1];
        daneArray[0]=dane;
        Film f = new Film(daneArray);
        return f;
    }
    
    public static Zamowienie utworz_wzorzec_zamowienia(String dane) {
        if(!Pattern.compile("[0-9]+").matcher(dane).matches())
            throw new IllegalFormatCodePointException(1);
        Zamowienie z = new Zamowienie(dane);
        return z;
    }
    
    public static Kaseta utworz_wzorzec_kasety(String dane) {
        if(!Pattern.compile("[0-9]+").matcher(dane).matches())
            throw new IllegalFormatCodePointException(1);
        Kaseta k = new Kaseta(dane);
        return k;
    }
}
