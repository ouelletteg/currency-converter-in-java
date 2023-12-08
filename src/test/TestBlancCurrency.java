//Sara Gair (20216922) Geneviève Ouellette (20141307)
package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlancCurrency {
    //01 currencyConverter.Currency.convert(Double, Double)
    //02    public static Double convert(Double amount, Double exchangeValue) {
    //03        Double price;
    //04        price = amount * exchangeValue;
    //05        price = Math.round(price * 100d) / 100d;
    //06
    //07        return price;
    //08    }

    //A. D1 = {(x, y)|x est dans R (les réels) et y est dans R} 01-08
    // Jeu de test : {(5,5)}
    //B. Aucun if, pas de changement
    //C. Aucune boucle, pas de changement
    //D. Aucune boucle, pas de changement
    //E. Aucune boucle, pas de changement


    @Test
    public void testConvert(){
        Double result = currencyConverter.Currency.convert(5.0, 5.0);
        assertEquals(25, result);

        Double result2 = currencyConverter.Currency.convert(10.0, 0.25);
        assertEquals(2.5, result2);
    }

}
