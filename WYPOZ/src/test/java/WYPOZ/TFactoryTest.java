package WYPOZ;

import java.util.IllegalFormatCodePointException;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

@Category({Test_Control.class, Test_Entity.class})
public class TFactoryTest {
    Dane dane;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void SetUp(){
        dane = new Dane();
    }
    
    @After
    public void After(){   
        System.out.print("\n");
    }

    @Test
    public void test_utworz_film() {
        System.out.println("Utworz film");
        for (int i = 0; i < dane.dane_filmow.length; i++) {
            exception.expect(IllegalFormatCodePointException.class);
            exception.expectMessage("Code point = 0x2");
            Film result = TFactory.utworz_film(dane.dane_filmow[i]);
            assertEquals(dane.filmy[i], result);     
            System.out.print("id="+dane.dane_filmow[i][0]+",");
        }
    }
    
    @Test
    public void test_utworz_kasete() {
        System.out.println("Utworz kasete");
        for (int i = 0; i < dane.dane_kaset.length; i++) {
            exception.expect(IllegalFormatCodePointException.class);
            exception.expectMessage("Code point = 0x3");
            Kaseta result = TFactory.utworz_kasete(dane.dane_kaset[i], dane.wzorce_filmy[0]);
            assertEquals(dane.kasety[i], result);     
            System.out.print("id="+dane.dane_kaset[i][0]+",");
        }
    }
}