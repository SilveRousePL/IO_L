package WYPOZ;

import java.util.ArrayList;

public class Film {
    private final int id_filmu;
    private String tytul_filmu;
    private String rok_produkcji;
    private String kraj_produkcji;
    private String rezyser;
    private ArrayList<Kaseta> kasety = new ArrayList<>();

    public Film(String[] dane) {
        id_filmu = Integer.parseInt(dane[0]);
        if (dane.length==5){
            tytul_filmu=dane[1];
            rok_produkcji=dane[2];
            kraj_produkcji=dane[3];
            rezyser=dane[4];
        }
    }
    
    // na potrzeby testów
    public int get_id_filmu() { return id_filmu; }
    public String get_tytul_filmu() { return tytul_filmu; }
    public String get_rok_produkcji() { return rok_produkcji; }
    public String get_kraj_produkcji() { return kraj_produkcji; }
    public String get_rezyser() { return rezyser; };
    public ArrayList<Kaseta> getKasety() { return kasety; };

    public Kaseta znajdz_wolna_kasete() {
        for (Kaseta k : kasety) {
            if (k.czy_wolna()) {
                return k;
            }
        }
        return null;
    }

    public Kaseta znajdz_kasete(Kaseta kaseta) {
        int index = kasety.indexOf(kaseta);
        if (index != -1) {
            kasety.get(index);
        }
        return null;
    }

    public boolean dodaj_kasete(String[] data) {
        Kaseta kaseta = TFactory.utworz_kasete(data, this);
        if (znajdz_kasete(kaseta) == null && kaseta != null) {
            this.kasety.add(kaseta);
            return true;
        }
        return false;
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
        final Film other;
        other = (Film) obj;
        return this.id_filmu == other.id_filmu;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id_filmu;
        return hash;
    }
    
    public int ilosc_kaset()
    {
        return kasety.size();
    }

    @Override
    public String toString() {
        return "Film{" + "id_filmu=" + id_filmu + ", tytul_filmu=" + tytul_filmu + ", rok_produkcji=" + rok_produkcji + ", kraj_produkcji=" + kraj_produkcji + ", rezyser=" + rezyser + ", kasety=" + kasety + '}';
    }
    
    public String[] toStrArray(){
        String[] str = new String[5];
        str[0] = String.valueOf(id_filmu);
        str[1] = tytul_filmu;
        str[2] = rok_produkcji;
        str[3] = kraj_produkcji;
        str[4] = rezyser;
        return str;
    }
    
}