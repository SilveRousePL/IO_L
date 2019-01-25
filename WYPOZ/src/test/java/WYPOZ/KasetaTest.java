package WYPOZ;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Category({Test_Entity.class})
@RunWith(Parameterized.class)
public class KasetaTest {
    Dane dane;
    
    @Before
    public void SetUp(){
        dane = new Dane();
    }
    
    @Parameterized.Parameter
    public int numer1;
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{ {0}, {1}, {2}, {3}, {4} };
        return Arrays.asList(data1);
    }
    
    @Test
    public void testEquals() {
        if (numer1<dane.poprawne_dane_kasety){
            System.out.println("equals");
            for(int j=0; j<dane.poprawne_dane_kasety; j++)
                if(numer1==j){
                    System.out.print(j+" == "+numer1+", ");
                    assertTrue(dane.kasety[numer1].equals(dane.wzorce_kasety[j]));
                }
                else{
                    assertFalse(dane.kasety[numer1].equals(dane.wzorce_kasety[j]));
                    System.out.print(j+" != "+numer1+", ");
                }    
            System.out.print("\n");
            }
    }
    
    @Test
    public void testZwolnij(){
        if (numer1<dane.poprawne_dane_kasety){ 
            System.out.println("zwolnij");
            dane.kasety[numer1].zwolnij();
            assertTrue(dane.kasety[numer1].czy_wolna());
        }   
    }
    
    @Test
    public void testWypozyczona(){
        if (numer1<dane.poprawne_dane_kasety){
            System.out.println("wypozyczona");
            dane.kasety[numer1].wypozycz();
            assertFalse(dane.kasety[numer1].czy_wolna());
        }   
    }   
}