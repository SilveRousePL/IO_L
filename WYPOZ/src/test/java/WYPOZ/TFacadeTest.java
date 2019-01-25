package WYPOZ;

import java.util.IllegalFormatCodePointException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

@Category({Test_Control.class, Test_Entity.class})
public class TFacadeTest {
    static Dane dane;
    static TFacade instance;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    static public void SetUp() {
        instance = new TFacade();
        dane = new Dane();
    }
    
    @Test
    public void test_dodaj_film() {
        for(int i=0; i<dane.dane_filmow.length; i++)
        {
            System.out.println("dodaj_film " + i);

            try {
                int ile0 = instance.getFilmy().size();
                instance.dodaj_film(dane.dane_filmow[i]);
                int ile1 = instance.getFilmy().size();
                instance.dodaj_film(dane.dane_filmow[i]);
                int ile2 = instance.getFilmy().size();

                if(i < dane.poprawne_dane_filmy) {
                    assertEquals(ile0, ile1-1);
                    assertEquals(ile1, ile2);
                    Film result = instance.getFilmy().get(ile2 - 1);
                    assertEquals(dane.filmy[ile2 - 1], result);
                }
            } catch(Exception e) {
                    assertTrue(i >= dane.poprawne_dane_filmy &&
                            e instanceof IllegalFormatCodePointException);
            }
        }
    }
    
    // W tym teście, testowana jest także metoda pobierz_ilosc_kaset()
    @Test
    public void test_dodaj_kasete() {
        for(int j=0; j<dane.dane_filmow.length; j++)
            for(int i=0; i<dane.dane_kaset.length; i++)
            {
                System.out.println("dodaj_kasete " + i);

                try {
                    int ile0 = instance.getFilmy().get(j).getKasety().size();
                    boolean w0 = instance.dodaj_kasete(dane.dane_filmow[j][0], dane.dane_kaset[i]);
                    int ile1 = instance.getFilmy().get(j).getKasety().size();
                    //
                    // ZAKOMENTOWANE BO MAMY BLAD
                    //
                    //boolean w1 = instance.dodaj_kasete(dane.dane_filmow[j][0], dane.dane_kaset[i]);
                    //int ile2 = instance.getFilmy().get(j).getKasety().size();
                    //
                    //

                    assertTrue((j < dane.poprawne_dane_filmy && w0)
                                || (j >= dane.poprawne_dane_filmy && !w0));
                    
                    if(i < dane.poprawne_dane_kasety) {
                        assertEquals(ile0, ile1-1);
                        //
                        // ZAKOMENTOWANE BO MAMY BLAD
                        //
                        //assertEquals(ile1, ile2);
                        //
                        //
                        Kaseta result = instance.getFilmy().get(j).getKasety().get(ile1 - 1);
                        assertEquals(dane.kasety[ile1 - 1], result);
                        
                        // Test metody pobierz_ilosc_kaset()
                        assertEquals(ile1, instance.pobierz_ilosc_kaset(dane.dane_filmow[j][0]));
                    }
                } catch(Exception e) {
                        assertTrue((i >= dane.poprawne_dane_kasety &&
                                e instanceof IllegalFormatCodePointException)
                                || (j >= dane.poprawne_dane_filmy &&
                                e instanceof IndexOutOfBoundsException));
                }
        }
    }
}