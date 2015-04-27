package org.equipe21.projetsession;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DollarTest {
    
    Dollar montant1;    // 18.29$
    Dollar montant2;    // 103.34$
    Dollar montant3;    // 10.29$
    Dollar montant4;    // 18.29$
    
    
    public DollarTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @Before
    public void setUp() {
        montant1 = new Dollar("18.29$");
        montant2 = new Dollar(103.34);
        montant3 = new Dollar(10.29);
        montant4 = new Dollar(18.29);
    }
    
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testGetTotalCents() {
        assertEquals(montant1.getTotalCents(), 1829);
        assertEquals(montant2.getTotalCents(), 10334);
    }
    
    
    @Test
    public void testGetDollars() {
        assertEquals(montant1.getDollars(), 18);
        assertEquals(montant2.getDollars(), 103);
    }
    
    
    @Test
    public void testGetCents() {
        assertEquals(montant1.getCents(), 29);
        assertEquals(montant2.getCents(), 34);
    }
    
    
    @Test
    public void testMontantToString() {
        montant1.toString();
        montant2.toString();
    }
    
    
    @Test
    public void testDollarToDouble() {
        Double d = 18.29;
        assertEquals(d, montant1.dollarToDouble());
        d = 103.34;
        assertEquals(d, montant2.dollarToDouble());
    }
    
    
    @Test
    public void testAdditionDoubleDansDollar() {
        Double d = 23.80;
        montant1.addition(d);
        montant2.addition(d);
        assertEquals(4209, montant1.getTotalCents());
        assertEquals(12714, montant2.getTotalCents());
    }
    
    
    @Test
    public void testAdditionDollarDansDollar() {
        montant1.addition(montant3);
        montant2.addition(montant3);
        assertEquals(2858, montant1.getTotalCents());
        assertEquals(11363, montant2.getTotalCents());
    }
    
    
    @Test
    public void testSoustractionDoubleDansDollar() {
        Double d = 10.29;
        montant1.soustraction(d);
        montant2.soustraction(d);
        assertEquals(800, montant1.getTotalCents());
        assertEquals(9305, montant2.getTotalCents());
    }
    
    
    @Test
    public void testSoustractionDollarDansDollar() {
        montant1.soustraction(montant3);
        montant2.soustraction(montant3);
        assertEquals(800, montant1.getTotalCents());
        assertEquals(9305, montant2.getTotalCents());
    }

    
    @Test
    public void testMultiplicationIntDansDollar() {
        montant1.multiplication(3);
        montant2.multiplication(3);
        assertEquals(5487, montant1.getTotalCents());
        assertEquals(31002, montant2.getTotalCents());
    }
    
    
    @Test
    public void testMultiplicationDollarDansDollar() {
        montant1.multiplication(montant3);
        montant2.multiplication(montant3);
        assertEquals(18820, montant1.getTotalCents());
        assertEquals(106336, montant2.getTotalCents());
    }
    
  
    @Test
    public void testDivisionIntDansDollar() {
        montant1.division(3);
        montant2.division(3);
        assertEquals(609, montant1.getTotalCents());
        assertEquals(3444, montant2.getTotalCents());
    }
    
    
    @Test
    public void testDivisionDollarDansDollar() {
        montant1.division(montant3);
        montant2.division(montant3);
        assertEquals(177, montant1.getTotalCents());
        assertEquals(1004, montant2.getTotalCents());
    }
        
 
    @Test
    public void testEstEgal() {
        assertTrue(montant1.estEgal(montant4));
        assertFalse(montant1.estEgal(montant2));
    }
    
    
    @Test
    public void testEstPlusPetit() {
        assertTrue(montant1.estPlusPetit(montant2));
        assertFalse(montant2.estPlusPetit(montant1));
    }
    
    
    @Test
    public void testEstPlusPetitOuEgal() {
        assertTrue(montant1.estPlusPetitOuEgal(montant4));
        assertTrue(montant1.estPlusPetitOuEgal(montant2));
        assertFalse(montant2.estPlusPetitOuEgal(montant1));
    }
    
    
    @Test
    public void testEstPlusGrand() {
        assertTrue(montant2.estPlusGrand(montant1));
        assertFalse(montant1.estPlusGrand(montant2));
    }
    
    
    @Test
    public void testEstPlusGrandOuEgal() {
        assertTrue(montant1.estPlusGrandOuEgal(montant4));
        assertTrue(montant2.estPlusGrandOuEgal(montant1));
        assertFalse(montant1.estPlusGrandOuEgal(montant2));
    }
    
    
    @Test
    public void testGetPourcentage() {
        assertEquals(182, montant1.getPourcentage(10).getTotalCents());
    }


    @Test
    public void testEquals_Null() {
        Object objetNouveau = null;
        Dollar dollar = new Dollar();
        assertFalse(dollar.equals(objetNouveau));
    }
    

    @Test
    public void testEquals_NonEgal() {
        Dollar unDollar = new Dollar("1.00$");
        Dollar zeroDollar = new Dollar();
        assertFalse(unDollar.equals(zeroDollar));
    }
    
    
    @Test
    public void testEquals_DifferentClass() {
        Dollar unDollar = new Dollar("1.00$");
        Double unHuard = 1.00;
        assertFalse(unDollar.equals(unHuard));
    }
    
    
    @Test
    public void testEquals_Egal() {
        Dollar unDollar = new Dollar("1.00$");
        Dollar unHuard = new Dollar("1.00$");
        assertEquals(unHuard, unDollar);
    }
    
    @Test
    public void testToString() {
        Dollar dollar = new Dollar();
        String chaineDollar = "0.00$";
        assertEquals(chaineDollar, dollar.toString());
    }
}
