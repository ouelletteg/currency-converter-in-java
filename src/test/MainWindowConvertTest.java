package test;


import currencyConverter.Currency;
import currencyConverter.MainWindow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class MainWindowConvertTest {
    
    private ArrayList<Currency> currencies = Currency.init();
    MainWindow mainWindow = new MainWindow();
    String usa = currencies.get(0).getName();
    String euro = currencies.get(1).getName();
    String england = currencies.get(2).getName();
    String swiss = currencies.get(3).getName();
    String china = currencies.get(4).getName();
    String japan = currencies.get(5).getName();
    
    
    @Test
    public void normalBounderiesTest(){

        Double amount = 5.00;

        //USD TEST 

        assertEquals(4.65, MainWindow.convert(usa, euro, currencies, amount));
        assertEquals(3.30, MainWindow.convert(usa, england, currencies, amount));
        assertEquals(5.05, MainWindow.convert(usa, swiss, currencies, amount));
        assertEquals(31.80, MainWindow.convert(usa, china, currencies, amount));
        assertEquals(617.70, MainWindow.convert(usa, japan, currencies, amount));

        //EURO TEST
        assertEquals(5.37, MainWindow.convert(euro, usa, currencies, amount));
        assertEquals(3.55, MainWindow.convert(euro, england, currencies, amount));
        assertEquals(5.40, MainWindow.convert(euro, swiss, currencies, amount));
        assertEquals(34.15, MainWindow.convert(euro, china, currencies, amount));
        assertEquals(662.85, MainWindow.convert(euro, japan, currencies, amount));

        //British Pund Test
        assertEquals(7.55, MainWindow.convert(england, usa, currencies, amount));
        assertEquals(7.05, MainWindow.convert(england, euro, currencies, amount));
        assertEquals(7.60, MainWindow.convert(england, swiss, currencies, amount));
        assertEquals(48.00, MainWindow.convert(england, china, currencies, amount));
        assertEquals(932.05, MainWindow.convert(england, japan, currencies, amount));
      
        //Swiss Franc Test
        assertEquals(4.95, MainWindow.convert(swiss, usa, currencies, amount));
        assertEquals(4.65, MainWindow.convert(swiss, euro, currencies, amount));
        assertEquals(3.30, MainWindow.convert(swiss, england, currencies, amount));
        assertEquals(31.65, MainWindow.convert(swiss, china, currencies, amount));
        assertEquals(614.2, MainWindow.convert(swiss, japan, currencies, amount));

        //Chinese Yuan Renminbi Test
        assertEquals(0.80, MainWindow.convert(china, usa, currencies, amount));
        assertEquals(0.75, MainWindow.convert(china, euro, currencies, amount));
        assertEquals(0.55, MainWindow.convert(china, england, currencies, amount));
        assertEquals(0.80, MainWindow.convert(china, swiss, currencies, amount));
        assertEquals(97.05, MainWindow.convert(china, japan, currencies, amount));

        //Japanese Yen
        assertEquals(0.04, MainWindow.convert(japan, usa, currencies, amount));
        assertEquals(0.04, MainWindow.convert(japan, euro, currencies, amount));
        assertEquals(0.03, MainWindow.convert(japan, england, currencies, amount));
        assertEquals(0.04, MainWindow.convert(japan, swiss, currencies, amount));
        assertEquals(0.26, MainWindow.convert(japan, china, currencies, amount));
    
    
    }

    @Test

    public void OutOfBounderiesTest(){

        //Limite gauche soit 0
        assertEquals(0.00, MainWindow.convert(usa, japan, currencies, 0.00));

        //Avant la limite gauche, chiffre negatif
         assertEquals(-247.08, MainWindow.convert(usa, japan, currencies, -2.00));

        //Limite droite 1 000 000
        assertEquals(930000.00, MainWindow.convert(usa, euro, currencies, 1000000.00));

        //Après limite droite
        assertEquals(1395000, MainWindow.convert(usa, euro, currencies, 1500000.00));

    }
}


