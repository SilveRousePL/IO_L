package WYPOZ;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Category({Test_Entity.class})
@RunWith(Parameterized.class)
public class FilmTest {
    Dane dane;
    
    @Before
    public void SetUp(){
        dane = new Dane();
    }
    
    @Parameterized.Parameter
    public int numer1;
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{ {0}, {1}, {2}, {3} };
        return Arrays.asList(data1);
    }
    
    @Test
    public void testEquals() {
    if (numer1<dane.poprawne_dane_filmy){
        System.out.println("equals");
        for(int j=0; j<dane.poprawne_dane_filmy; j++)
            if(numer1==j){
                System.out.print(j+" == "+numer1+", ");
                assertTrue(dane.filmy[numer1].equals(dane.wzorce_filmy[j]));
            }
            else{
                assertFalse(dane.filmy[numer1].equals(dane.wzorce_filmy[j]));
                System.out.print(j+" != "+numer1+", ");
            }    
        System.out.print("\n");
        }
    }
    
    @Test
    public void test_get_id_filmu() {    
        if (numer1<dane.poprawne_dane_filmy){
            System.out.println("test_get_id_filmu");
            int result1 = dane.filmy[numer1].get_id_filmu();
            int result2 = dane.id_filmow[numer1];
            assertEquals(result1, result2);
        }
    }
    
    @Test
    public void test_get_tytul_filmu() {
        if (numer1<dane.poprawne_dane_filmy){
            System.out.println("test_get_tytul_filmu");
            String result1 = dane.filmy[numer1].get_tytul_filmu();
            String result2 = dane.tytuly_filmow[numer1];
            assertEquals(result1, result2);
        }
    }
    
    @Test
    public void test_rok_produkcji() {
        if (numer1<dane.poprawne_dane_filmy){
            System.out.println("test_rok_produkcji");
            String result1 = dane.filmy[numer1].get_rok_produkcji();
            String result2 = dane.lata_produkcji[numer1];
            assertEquals(result1, result2);            
        }
    }
    
    @Test
    public void test_get_kraj_produkcji() {
        if (numer1<dane.poprawne_dane_filmy){
            System.out.println("test_get_kraj_produkcji");  
            String result1 = dane.filmy[numer1].get_kraj_produkcji();
            String result2 = dane.kraje_produkcji[numer1];
            assertEquals(result1, result2);
        }
    }
    
    @Test
    public void test_get_rezyser() {
        if (numer1<dane.poprawne_dane_filmy){
            System.out.println("test_get_rezyser");
            String result1 = dane.filmy[numer1].get_rezyser();
            String result2 = dane.rezyserzy[numer1];
            assertEquals(result1, result2);
        }
    }
}