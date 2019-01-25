package WYPOZ;

import java.util.ArrayList;
import java.util.Arrays;

public class Uzytkownik {

    private final int ID_klienta;
    private String imie;
    private String nazwisko;
    private String adres;
    private String pesel;
    private final ArrayList<Zamowienie> zamowienia = new ArrayList();

    Uzytkownik(String[] dane){
        ID_klienta = Integer.parseInt(dane[0]);
        if (dane.length==5){
            imie=dane[1];
            nazwisko=dane[2];
            adres=dane[3];
            pesel=dane[4];
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Uzytkownik other = (Uzytkownik) obj;
        return this.ID_klienta == other.ID_klienta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.ID_klienta;
        return hash;
    }

    public int getID_klienta() {
        return ID_klienta;
    }
    public Zamowienie znajdz_zamowienie(String id_zamowienia) {
        int index = zamowienia.indexOf(TFactory.utworz_wzorzec_zamowienia(id_zamowienia));
        if (index != -1) {
            return zamowienia.get(index);
        } else {
            return null;
        }
    }
    
    public Zamowienie znajdz_zamowienie(Zamowienie zamowienie) {
        int index = zamowienia.indexOf(zamowienie);
        if (index != -1) {
            return zamowienia.get(index);
        } else {
            return null;
        }
    }
    
    public Zamowienie dodaj_zamowienie(Kaseta kaseta) {
        Zamowienie z = new Zamowienie(this,kaseta);
        Zamowienie istnieje = this.znajdz_zamowienie(z);
        if (istnieje==null){
            this.zamowienia.add(z);
            return z;          
        }
        return null;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" + "ID_klienta=" + ID_klienta + ", imie=" + imie + ", nazwisko=" + nazwisko + ", adres=" + adres + ", pesel=" + pesel + ", zamowienia=" + zamowienia + '}';
    }
    
    public String[] zamowienia_do_wyslaniaToStrArray() {
        ArrayList<String> o = new ArrayList<>();
        zamowienia.forEach((zz) ->{
                if (zz.do_wysylki()) {
                String[] str = new String[4];
                str[0] = imie;
                str[1] = nazwisko;
                str[2] = adres;
                str[3]=zz.kasetaStr();
                o.add(Arrays.deepToString(str));
        }});
        return (String[])o.toArray(new String[o.size()]);
    }
    
    public String[] zamowienia_do_ponagleniaToStrArray() {
        ArrayList<String> o = new ArrayList<>();
        zamowienia.forEach((zz) ->{
             if (zz.do_oddania()) {
                String[] str = new String[4];
                str[0] = imie;
                str[1] = nazwisko;
                str[2] = adres;
                str[3]=zz.kasetaStr();
                o.add(Arrays.deepToString(str));
        }});
        return (String[])o.toArray(new String[o.size()]);
    }

    public String[] toStrArray() {
        String str[] = new String[3];
        str[0] = imie;
        str[1] = nazwisko;
        str[2] = adres;
        return str;
    }
  
    int zakoncz(Zamowienie zamowienie) {
        int index = zamowienia.indexOf(zamowienie);
        if (index != -1) {
            Zamowienie zz = zamowienia.get(index);
            zz.zakoncz();
            zamowienia.remove(index);
            return zz.oblicz_kare();
        }
        return -1;
    }
    
    int ilosc_zamowien(){
        return zamowienia.size();
    }

    String get_imie() {
        return imie;
    }

    String get_nazwisko() {
        return nazwisko;
    }

    String get_adres() {
        return adres;
    }

    ArrayList<Zamowienie> get_zamowienia() {
        return zamowienia;
    }
}
