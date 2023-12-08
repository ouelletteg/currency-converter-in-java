package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlancMainWindows {
    // code de convert(nameCurrency1, nameCurrency2, currencies, amount);
    //01    public static Double convert(String currency1, String currency2, ArrayList<Currency> currencies, Double amount) {
    //02        String shortNameCurrency2 = null;
    //03        Double exchangeValue;
    //04        Double price = 0.0;
    //05
    //06        // Find shortname for the second currency
    //07        for (Integer i = 0; i < currencies.size(); i++) {
    //08            if (currencies.get(i).getName() == currency2) {
    //09                shortNameCurrency2 = currencies.get(i).getShortName();
    //10                break;
    //11            }
    //12        }
    //13
    //14        // Find exchange value and call convert() to calcul the new price
    //15        if (shortNameCurrency2 != null) {
    //16            for (Integer i = 0; i < currencies.size(); i++) {
    //17                if (currencies.get(i).getName() == currency1) {
    //18                    exchangeValue = currencies.get(i).getExchangeValues().get(shortNameCurrency2);
    //19                    price = Currency.convert(amount, exchangeValue);
    //20                    break;
    //21                }
    //22            }
    //23        }
    //24
    //25        return price;
    //26    }

    // A.
    // D1 = {(nameCurrency1, nameCurrency2, currencies, amount)| nameCurrency1 is in currency.names (but not the first), nameCurrency2 is in currency.names (but not the first)}, execute 01-26
    // Jeu de test: {('Japanese Yen', 'Swiss Franc', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount)}

    // B. avec Paint
    // D1 = {(nameCurrency1, nameCurrency2, currencies, amount)| nameCurrency2 is not in currency.names}, execute 01-07, 25-26
    // D2 = {(nameCurrency1, nameCurrency2, currencies, amount)| nameCurrency1 is in currency.names, nameCurrency2 is in currency.names}, execute 01-26
    // D3 = {(nameCurrency1, nameCurrency2, currencies, amount)| nameCurrency1 is not in currency.names, nameCurrency2 is in currency.names}, execute 01-16, 25-26
    // Jeu de test: {('Japanese Yen', 'x', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount), ('Japanese Yen', 'Swiss Franc', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount), ('x', 'Swiss Franc', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount)}

    // C.
    // A: Boucle for de 07-12, 3 choix:
    // A1 : {07,12}(skip A)
    // A2 : {07-08,11}(run A, ifA false)
    // A3 : {07-12}(run A, ifA true)
    // C: if de 15-22, 2 choix:
    // C1: 15-(22) (run C > go to B)
    // C2: 15,22 (skip C)
    // B: Boucle for de 16-22, 3 choix:
    // B1 : {16,22}(skip B)
    // B2 : {16-17,22}(run B, ifB false)
    // B3 : {16-22}(run B, ifB true)
    // Chemin 1 : 01-07, 12-15, 22-25 (skip A (A1), skip C (C2))
    // Chemin 2 (X): 01-07, 12-25 (skip A, run B) (impossible à cause du if du ligne 15 (pour lequel shortNameCurrency2 est toujours faux quand la ligne 9 n'est pas exécutée!))
    // Chemin 3 (X): 01-08, 11-15, 22-25 (run A , ifA false, skip B) (impossible, car si A run, B run aussi, car ils sont tous les deux sur currencies)
    // Chemin 4 (X): 01-15, 22-25 (run A, ifA true, skip B) (impossible, car si A run, B run aussi, car ils sont tous les deux sur currencies)
    // Chemin 5 : 01-25 (run A, ifA true, run C, run B, ifB true)
    // Chemin 6 : 01-16, 22-25 (run A, ifA true, run C, run B, ifB false)
    // Chemin 7 (X): 01-08, 11-25 (run A, ifA false, run C) (impossible à cause du if qui est toujours faux quand la ligne 9 n'est pas exécutée!)
    // Chemin 8 : 01-08, 11-15, 22-25 (run A , ifA false, skip C)
    // Jeu de test: {('Japanese Yen', 'Swiss Franc', currencies=null, amount), ('Japanese Yen', 'Swiss Franc', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount), ('x', 'Swiss Franc', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount), ('Japanese Yen', 'x', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount)}

    // D. Pas de conditions composées

    // E.
    // A: Boucle for de 07-12, 7 choix:
    // A1 : {07,12}(skip A)
    // A2 : {07-11}(run A une fois, ifA true)
    // A3 : {07-11}(run A deux fois, ifA true)
    // A4 : {07-11}(run A six fois, ifA true)
    // A5 : {07-08,11}(run A une fois, ifA toujours false)
    // A6 : {07-08,11}(run A deux fois, ifA toujours false)
    // A7 : {07-08,11}(run A six fois, ifA toujours false)
    // C: if de 15-22, 2 choix:
    // C1: 15-(22) (run C > go to B)
    // C2: 15,22 (skip C)
    // B: Boucle for de 16-22, 7 choix:
    // B1 : {16,22}(skip B)
    // B2 : {16-22}(run B une fois, ifB true)
    // B3 : {16-22}(run B deux fois, ifB true)
    // B4 : {16-22}(run B six fois, ifB true)
    // B5 : {16-17,22}(run B une fois, ifB toujours false)
    // B6 : {16-17,22}(run B deux fois, ifB toujours false)
    // B7 : {16-17,22}(run B six fois, ifB toujours false)
    // Sur la base des chemins valides trouvés en C.
    // Chemin 1 : 01-07, 12-15, 22-25 (skip A, skip C)
    // Chemin 5A : 01-25 (run A, ifA true, run C, run B, ifB true) (A 1 fois, B 1 fois)
    // Chemin 5B : 01-25 (run A, ifA true, run C, run B, ifB true) (A 1 fois, B 2 fois)
    // Chemin 5C : 01-25 (run A, ifA true, run C, run B, ifB true) (A 1 fois, B 6 fois)
    // Chemin 5D : 01-25 (run A, ifA true, run C, run B, ifB true) (A 2 fois, B 1 fois)
    // Chemin 5E : 01-25 (run A, ifA true, run C, run B, ifB true) (A 2 fois, B 2 fois)
    // Chemin 5F : 01-25 (run A, ifA true, run C, run B, ifB true) (A 2 fois, B 6 fois)
    // Chemin 5G : 01-25 (run A, ifA true, run C, run B, ifB true) (A 6 fois, B 1 fois)
    // Chemin 5H : 01-25 (run A, ifA true, run C, run B, ifB true) (A 6 fois, B 2 fois)
    // Chemin 5I : 01-25 (run A, ifA true, run C, run B, ifB true) (A 6 fois, B 6 fois)
    // Chemin 6A : 01-16, 22-25 (run A, ifA true, run C, run B, ifB false) (A 1 fois, B 1 fois)
    // Chemin 6B : 01-16, 22-25 (run A, ifA true, run C, run B, ifB false) (A 1 fois, B 2 fois)
    // Chemin 6C : 01-16, 22-25 (run A, ifA true, run C, run B, ifB false) (A 1 fois, B 6 fois)
    // Chemin 6D (X): 01-16, 22-25 (run A, ifA true, run C, run B, ifB false) (A 2 fois, B 1 fois) (B tourne jusqu'à currency.size = 2)
    // Chemin 6E : 01-16, 22-25 (run A, ifA true, run C, run B, ifB false) (A 2 fois, B 2 fois)
    // Chemin 6F : 01-16, 22-25 (run A, ifA true, run C, run B, ifB false) (A 2 fois, B 6 fois)
    // Chemin 6G (X): 01-16, 22-25 (run A, ifA true, run C, run B, ifB false) (A 6 fois, B 1 fois) (B tourne jusqu'à currency.size = 6)
    // Chemin 6H (X): 01-16, 22-25 (run A, ifA true, run C, run B, ifB false) (A 6 fois, B 2 fois) (B tourne jusqu'à currency.size = 6)
    // Chemin 6I : 01-16, 22-25 (run A, ifA true, run C, run B, ifB false) (A 6 fois, B 6 fois)
    // Chemin 8A : 01-08, 11-15, 22-25 (run A , ifA false, skip C) (A 1 fois)
    // Chemin 8B : 01-08, 11-15, 22-25 (run A , ifA false, skip C) (A 2 fois)
    // Chemin 8C : 01-08, 11-15, 22-25 (run A , ifA false, skip C) (A 6 fois)
    // Jeu de test:{
    // ('Japanese Yen', 'Swiss Franc', currencies=null, amount),
    // ('US Dollar', 'US Dollar', currencies={US Dollar}, amount),
    // ('Euro', 'US Dollar', currencies={US Dollar, Euro}, amount),
    // ('Japanese Yen', 'US Dollar', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
    // ('US Dollar', 'Euro', currencies={US Dollar, Euro}, amount),
    // ('Euro', 'Euro', currencies={US Dollar, Euro}, amount),
    // ('Japanese Yen', 'Euro', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
    // ('US Dollar', 'Japanese Yen', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
    // ('Euro', 'Japanese Yen', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
    // ('Japanese Yen', 'Japanese Yen', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
    // ('x', 'US Dollar', currencies={US Dollar}, amount),
    // ('x', 'US Dollar', currencies={US Dollar, Euro}, amount),
    // ('x', 'US Dollar', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
    // ('x', 'Euro', currencies={US Dollar, Euro}, amount),
    // ('x', 'Euro', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
    // ('x', 'Japanese Yen', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
    // ('US Dollar', 'x', currencies={US Dollar}, amount),
    // ('Euro', 'x', currencies={US Dollar, Euro}, amount),
    // ('Japanese Yen', 'x', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
    // }
    ArrayList<Currency> currencyListNull, currencyList1, currencyList2, currencyList6;
    String currencyName1 = "US Dollar";
    String currencyName2 = "Euro";
    String currencyName6 = "Japanese Yen";
    String currencyNameDontExist = "XXX";

    Double amount = 1.0;

    private void initiate(){
        currencyListNull = new ArrayList<>();
        currencyList1 = new ArrayList<>();
        currencyList1.add( new Currency("US Dollar", "USD") );
        for (Integer i =0; i < currencyList1.size(); i++) {
            currencyList1.get(i).defaultValues();
        }
        currencyList2 = new ArrayList<>();
        currencyList2.add( new Currency("US Dollar", "USD") );
        currencyList2.add( new Currency("Euro", "EUR") );
        for (Integer i =0; i < currencyList2.size(); i++) {
            currencyList2.get(i).defaultValues();
        }
        currencyList6 = Currency.init();
    }

    @Test
    public void testChemin1(){
        initiate();
        // Chemin 1 : ('Japanese Yen', 'Swiss Franc', currencies=null, amount),
        Double resChemin1 = MainWindow.convert(currencyName1, currencyName2, currencyListNull, amount);
        assertEquals(0, resChemin1);
    }

    @Test
    public void testChemin5A(){
        initiate();

        // Chemin 5A : ('US Dollar', 'US Dollar', currencies={US Dollar}, amount),
        Double resChemin5A = MainWindow.convert(currencyName1, currencyName1, currencyList1, amount);
        assertEquals(1, resChemin5A);
    }

    @Test
    public void testChemin5B(){
        initiate();

        // Chemin 5B : ('Euro', 'US Dollar', currencies={US Dollar, Euro}, amount),
        Double resChemin5B = MainWindow.convert(currencyName2, currencyName1, currencyList2, amount);
        assertEquals(1.07, resChemin5B);
    }

    @Test
    public void testChemin5C(){
        initiate();

        // Chemin 5C : ('Japanese Yen', 'US Dollar', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
        Double resChemin5C = MainWindow.convert(currencyName6, currencyName1, currencyList6, amount);
        assertEquals(0.01, resChemin5C);
    }

    @Test
    public void testChemin5D(){
        initiate();

        // Chemin 5D : ('US Dollar', 'Euro', currencies={US Dollar, Euro}, amount),
        Double resChemin5D = MainWindow.convert(currencyName1, currencyName2, currencyList2, amount);
        assertEquals(0.93, resChemin5D);
    }

    @Test
    public void testChemin5E(){
        initiate();

        // Chemin 5E : ('Euro', 'Euro', currencies={US Dollar, Euro}, amount),
        Double resChemin5E = MainWindow.convert(currencyName2, currencyName2, currencyList2, amount);
        assertEquals(1, resChemin5E);
    }

    @Test
    public void testChemin5F(){
        initiate();

        // Chemin 5F : ('Japanese Yen', 'Euro', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
        Double resChemin5F = MainWindow.convert(currencyName6, currencyName2, currencyList6, amount);
        assertEquals(0.01, resChemin5F);
    }

    @Test
    public void testChemin5G(){
        initiate();

        // Chemin 5G : ('US Dollar', 'Japanese Yen', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
        Double resChemin5G = MainWindow.convert(currencyName1, currencyName6, currencyList6, amount);
        assertEquals(123.54, resChemin5G);
    }

    @Test
    public void testChemin5H(){
        initiate();

        // Chemin 5H : ('Euro', 'Japanese Yen', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
        Double resChemin5H = MainWindow.convert(currencyName2, currencyName6, currencyList6, amount);
        assertEquals(132.57, resChemin5H);
    }

    @Test
    public void testChemin5I(){
        initiate();

        // Chemin 5I : ('Japanese Yen', 'Japanese Yen', currencies={US Dollar, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
        Double resChemin5I = MainWindow.convert(currencyName6, currencyName6, currencyList6, amount);
        assertEquals(1, resChemin5I);
    }

    @Test
    public void testChemin6A(){
        initiate();

        //Chemin 6A : ('x', 'US Dollar', currencies={US Dollar}, amount),
        Double resChemin6A = MainWindow.convert(currencyNameDontExist, currencyName1, currencyList1, amount);
        assertEquals(0, resChemin6A);
    }

    @Test
    public void testChemin6B(){
        initiate();

        // Chemin 6B : ('x', 'US Dollar', currencies={US Dollar, Euro}, amount),
        Double resChemin6B = MainWindow.convert(currencyNameDontExist, currencyName1, currencyList2, amount);
        assertEquals(0, resChemin6B);
    }

    @Test
    public void testChemin6C(){
        initiate();

        // Chemin 6C : ('x', 'US Dollar', currencies={USD, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
        Double resChemin6C = MainWindow.convert(currencyNameDontExist, currencyName1, currencyList6, amount);
        assertEquals(0, resChemin6C);
    }

    @Test
    public void testChemin6E(){
        initiate();

        // Chemin 6E : ('x', 'Euro', currencies={USD, Euro}, amount),
        Double resChemin6E = MainWindow.convert(currencyNameDontExist, currencyName2, currencyList2, amount);
        assertEquals(0, resChemin6E);
    }

    @Test
    public void testChemin6F(){
        initiate();

        // Chemin 6F : ('x', 'Euro', currencies={USD, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
        Double resChemin6F = MainWindow.convert(currencyNameDontExist, currencyName2, currencyList6, amount);
        assertEquals(0, resChemin6F);
    }

    @Test
    public void testChemin6I(){
        initiate();

        // Chemin 6I : ('x', 'Japanese Yen', currencies={USD, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
        Double resChemin6I = MainWindow.convert(currencyNameDontExist, currencyName6, currencyList6, amount);
        assertEquals(0, resChemin6I);
    }

    @Test
    public void testChemin8A(){
        initiate();

        // Chemin 8A : ('USD', 'x', currencies={USD}, amount),
        Double resChemin8A = MainWindow.convert(currencyName1, currencyNameDontExist, currencyList1, amount);
        assertEquals(0, resChemin8A);
    }

    @Test
    public void testChemin8B(){
        initiate();

        // Chemin 8B : ('Euro', 'x', currencies={USD, Euro}, amount),
        Double resChemin8B = MainWindow.convert(currencyName2, currencyNameDontExist, currencyList2, amount);
        assertEquals(0, resChemin8B);
    }

    @Test
    public void testChemin8C(){
        initiate();

        // Chemin 8C : ('Japanese Yen', 'x', currencies={USD, Euro, British Pound, Swiss Franc, Chinese Yuan Renminbi, Japanese Yen}, amount),
        Double resChemin8C = MainWindow.convert(currencyName6, currencyNameDontExist, currencyList6, amount);
        assertEquals(0, resChemin8C);

    }
}
