package test;


import org.junit.jupiter.api.Test;

import currencyConverter.Currency;

import static org.junit.jupiter.api.Assertions.*;

public class TestCurrency {

    @Test
    public void testDevises(){

        //Seulement USD, CAD et AUD sont testés car ils ont échoué dans MainWindowConvertTest
        //Ces tests sont représentatifs des autres devises, car il suffit de remplacer exchange 
        //value par celle d'une autre devise. 
        
        //Test USD to CAD
        assertEquals(6.8, Currency.convert(5.00, 1.36));

        //Test CAD to USD
        assertEquals(3.7, Currency.convert(5.00, 0.74));

        //Test USD TO AUD
        assertEquals(7.6, Currency.convert(5.00, 1.52));

        //Test AUD to USD
        assertEquals(3.3, Currency.convert(5.00, 0.66));
    }

    @Test
    public void testLimites(){

        //Montant < 0
        assertEquals(-0.66, Currency.convert(-1.00, 0.66));

        //Ce test devrait donner null ou retourner un message d'erreur

        //Montant > 1 000 000
        assertEquals(3300000, Currency.convert(5000000.00, 0.66));

        //Ce test devrait aussi échouer.
    }
    
}
