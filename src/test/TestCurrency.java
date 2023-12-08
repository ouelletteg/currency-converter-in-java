//Sara Gair (20216922) Geneviève Ouellette (20141307)

package test;


import org.junit.jupiter.api.Test;

import currencyConverter.Currency;

import static org.junit.jupiter.api.Assertions.*;

public class TestCurrency {

    @Test
    public void testDevises(){

        //Seulement USD et CAD sont testés car les tests deviennent trop répétitifs.
        //Ces tests sont représentatifs des autres devises, car il suffit de remplacer exchange 
        //value par celle d'une autre devise exemple EURO à GBP mettre 0.71. 

        //Les devises CAD et AUD sont prises sur Google.com en date du 7 décembre.
        //Les autres devises sont les mêmes que dans le fichier Currency.java.

        //Test avec USD, amount to convert = 5.00$ USD

        //USD to CAD
        assertEquals(6.8, Currency.convert(5.00, 1.36));

        //USD to GBP
        assertEquals(3.3, Currency.convert(5.00, 0.66));

        //USD to EUR
        assertEquals(4.65, Currency.convert(5.00, 0.93));

        //USD to CHF
        assertEquals(5.05, Currency.convert(5.00, 1.01));

        //USD to AUD
        assertEquals(7.6, Currency.convert(5.00, 1.52));


        //Tests CAD

        //CAD to USD
        assertEquals(3.7, Currency.convert(5.00, 0.74));

        //CAD to GBP
        assertEquals(2.95, Currency.convert(5.00, 0.59));

        //CAD to EUR
        assertEquals(3.4, Currency.convert(5.00, 0.68));

        //CAD to CHF
        assertEquals(3.25, Currency.convert(5.00, 0.65));

        //CAD to AUD
        assertEquals(5.6, Currency.convert(5.00, 1.12));

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
