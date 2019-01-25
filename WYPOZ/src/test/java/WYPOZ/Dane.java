package WYPOZ;

public class Dane {
    public String dane_filmow[][] = new String[][] {
        {"1", "Tytanic", "1997", "USA", "James Cameron"},
        {"2", "Avatar", "2009", "USA", "James Cameron"},
        {"3", "Pojutrze", "2004", "USA", "Roland Emmerich"},
        {"4", "2012", "2009", "USA", "Roland Emmerich"},
        {"5", "Czas surferów", "nie data", "Polska", "Jacek Gasiorowski"},
        {"nie id", "Job, czyli ostatnia szara komórka", "2006", "Polska", "Konrad Niewolski"}
    };
    public String dane_kaset[][] = new String[][] {
        {"11",  "1484696046"},
        {"234", "1484696046"},
        {"311", "1484696046"},
        {"423", "1484696046"},
        {"555", "1484696046"},
        {"555", "1484696046"},
        {"5x",  "1484696046"},
        {"525", "14846x2046"}
    };
    public int poprawne_dane_filmy = 4;
    public int poprawne_dane_kasety = 5;
    public Film wzorce_filmy[] = new Film[] {
        TFactory.utworz_wzorzec_filmu("1"),
        TFactory.utworz_wzorzec_filmu("2"),
        TFactory.utworz_wzorzec_filmu("3"),
        TFactory.utworz_wzorzec_filmu("4"),
        TFactory.utworz_wzorzec_filmu("5"),
        TFactory.utworz_wzorzec_filmu("6"),
    };    
    public Kaseta wzorce_kasety[] = new Kaseta[] {
        TFactory.utworz_wzorzec_kasety("11"),
        TFactory.utworz_wzorzec_kasety("234"),
        TFactory.utworz_wzorzec_kasety("311"),
        TFactory.utworz_wzorzec_kasety("423"),
        TFactory.utworz_wzorzec_kasety("555"),
        TFactory.utworz_wzorzec_kasety("555"),
    }; 
    public Kaseta kasety[] = new Kaseta[] {
        TFactory.utworz_kasete(dane_kaset[0],wzorce_filmy[0]),
        TFactory.utworz_kasete(dane_kaset[1],wzorce_filmy[0]),
        TFactory.utworz_kasete(dane_kaset[2],wzorce_filmy[0]),
        TFactory.utworz_kasete(dane_kaset[3],wzorce_filmy[0]),
        TFactory.utworz_kasete(dane_kaset[4],wzorce_filmy[0]),
        TFactory.utworz_kasete(dane_kaset[5],wzorce_filmy[0]),
    };      
    public Film filmy[] = new Film[] {
        TFactory.utworz_film(dane_filmow[0]),
        TFactory.utworz_film(dane_filmow[1]),
        TFactory.utworz_film(dane_filmow[2]),
        TFactory.utworz_film(dane_filmow[3]),
        //TFactory.utworz_film(dane_filmow[4]),
        //TFactory.utworz_film(dane_filmow[5]),
    };
    
    public int id_kaset[] = new int[] {
        11,234,311,423,555
    };
    
    public int daty_kaset[] = new int[] {
        1484696046,1484696046,1484696046,1484696046,1484696046,1484696046
    };
    
    public int id_filmow[] = new int[] {
        1,2,3,4,5
    };
    
    public String tytuly_filmow[] = new String[] {
        "Tytanic", "Avatar", "Pojutrze", "2012", "Czas surferów", "Job, czyli ostatnia szara komórka"
    };
    
    public String lata_produkcji[] = new String[] {
        "1997", "2009", "2004", "2009", "2005", "2006"
    };
    
    public String kraje_produkcji[] = new String[] {
        "USA", "USA", "USA", "USA", "Polska", "Polska"
    };
    
    public String rezyserzy[] = new String[] {
        "James Cameron", "James Cameron", "Roland Emmerich", "Roland Emmerich","Jacek Gasiorowski", "Konrad Niewolski"
    };
}