
package org.equipe21.projetsession;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ValidateurTest {

    Validateur validateurDesDonnees;
    
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    
    @Before
    public void setUp() {
        validateurDesDonnees = new Validateur();
    }
    

    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testValiderLettreContrat() {
        char lettreTest = 'A';
        assertTrue(validateurDesDonnees.validerLettreContrat(lettreTest));
    }

    
    @Test
    public void testValiderLettreContratInvalideLimitBass() {
        char lettreTest = '@';
        assertFalse(validateurDesDonnees.validerLettreContrat(lettreTest));
    }    
    
 
    @Test
    public void testValiderLettreContratInvalideLimitHaut() {
        char lettreTest = 'G';
        assertFalse(validateurDesDonnees.validerLettreContrat(lettreTest));
    }  
    
    
    @Test
    public void testValiderClient() {
        String clientTest  = "123456";
        assertTrue(validateurDesDonnees.validerClient(clientTest));
    }
    
    
    @Test
    public void testValiderClientInvalidePasAssezDeChiffres() {
        String clientTest  = "12345";
        assertFalse(validateurDesDonnees.validerClient(clientTest));
    }
    
    
    @Test
    public void testValiderClientInvalideTropDeChiffres() {
        String clientTest  = "1234567";
        assertFalse(validateurDesDonnees.validerClient(clientTest));
    }
    
    
    @Test
    public void testValiderClientInvalidePasChiffre() {
        String clientTest  = "12A456";
        assertFalse(validateurDesDonnees.validerClient(clientTest));
    }
    
    
    @Test
    public void testValiderMois() {
        String moisTest  = "1995-08";
        assertTrue(validateurDesDonnees.validerMois(moisTest));
    }
    
    
    @Test
    public void testValiderMoisInvalidePasAssezDeChiffres() {
        String moisTest  = "1995-1";
        assertFalse(validateurDesDonnees.validerMois(moisTest));
    }
    
    
    @Test
    public void testValiderMoisInvalideTropDeChiffres() {
        String moisTest  = "1995-081";
        assertFalse(validateurDesDonnees.validerMois(moisTest));
    }
    
    
    @Test
    public void testValiderMoisInvalidePasDeBarre() {
        String moisTest  = "1995308";
        assertFalse(validateurDesDonnees.validerMois(moisTest));
    }
    
    
    @Test
    public void testValiderMoisInvalideMauvaisePlace() {
        String moisTest  = "19-9508";
        assertFalse(validateurDesDonnees.validerMois(moisTest));
    }
    
    
    @Test
    public void testValiderMoisInvalidePasChiffres() {
        String moisTest  = "Tropica";
        assertFalse(validateurDesDonnees.validerMois(moisTest));
    }
    
    
    @Test
    public void testValiderMoisInvalideNulle() {
        String moisTest  = "";
        assertFalse(validateurDesDonnees.validerMois(moisTest));
    }
    
    
    @Test
    public void testValiderDate() {
        String dateTest  = "1995-08-11";
        assertTrue(validateurDesDonnees.validerDate(dateTest));
    }
    
    
    @Test
    public void testValiderDateInvalideManquePremiereBarre() {
        String dateTest  = "1995208-11";
        assertFalse(validateurDesDonnees.validerDate(dateTest));
    }
    
    
    @Test
    public void testValiderDateInvalideManqueDeuxiemeBarre() {
        String dateTest  = "1995-08911";
        assertFalse(validateurDesDonnees.validerDate(dateTest));
    }
    
    
    @Test
    public void testValiderDateInvalidePasAssezDeChiffres() {
        String dateTest  = "1995-08-1";
        assertFalse(validateurDesDonnees.validerDate(dateTest));
    }
    
    
    @Test
    public void testValiderDateInvalideTropDeChiffres() {
        String dateTest  = "1995-08-114";
        assertFalse(validateurDesDonnees.validerDate(dateTest));
    }
    
    
    @Test
    public void testValiderDateInvalideDateExistePas() {
        String dateTest  = "2010-28-10";
        assertFalse(validateurDesDonnees.validerDate(dateTest));
    }
    
    
    @Test
    public void testValiderDateInvalideMauvaisOrdre() {
        String dateTest  = "28-10-2010";
        assertFalse(validateurDesDonnees.validerDate(dateTest));
    }
    
    
    @Test
    public void testValiderDateInvalidePasChiffre() {
        String dateTest  = "Tropicanar";
        assertFalse(validateurDesDonnees.validerDate(dateTest));
    }
    
    
    @Test
    public void testValiderDateInvalideNulle() {
        String dateTest  = null;
        assertFalse(validateurDesDonnees.validerDate(dateTest));
    }
    
    
    @Test
    public void testValiderDateInvalideNulleAvecDateFormat() {
        String dateTest  = null;
        assertFalse(validateurDesDonnees.validerDate(dateTest, "yyyy-MM-dd"));
    }
    
    
    @Test
    public void testValiderMois_String_String() {
        String moisTest  = "2010-08";
        String dateFormat = "yyyy-MM";
        assertTrue(validateurDesDonnees.validerDate(moisTest, dateFormat));
    }
    
    
    @Test
    public void testValiderDate_String_String() {
        String dateTest  = "2010-08-19";
        String dateFormat = "yyyy-MM-dd";
        assertTrue(validateurDesDonnees.validerDate(dateTest, dateFormat));
    }
    
    
    @Test
    public void testValiderDate_String_String_InvalidePasDeBarre() {
        String dateTest  = "2015/01/30";
        String dateFormat = "yyyy-MM-dd";
        assertFalse(validateurDesDonnees.validerDate(dateTest, dateFormat));
    }
    
    
    @Test
    public void testValiderDate_String_String_MauvaisJanvier() {
        String dateTest  = "2015-01-32";
        String dateFormat = "yyyy-MM-dd";
        assertFalse(validateurDesDonnees.validerDate(dateTest, dateFormat));
    }
    
    
    @Test
    public void testValiderDate_String_String_MauvaisFevrier() {
        String dateTest  = "2015-02-29";
        String dateFormat = "yyyy-MM-dd";
        assertFalse(validateurDesDonnees.validerDate(dateTest, dateFormat));
    }
    
    
    @Test
    public void testValiderDate_String_String_MauvaisFormat() {
        String dateTest  = "2015-02";
        String dateFormat = "yyyy-MM-dd";
        assertFalse(validateurDesDonnees.validerDate(dateTest, dateFormat));
    }
    
    
    @Test
    public void testValiderDateAppartientMois() {
        String dateTest  = "2015-02-14";
        String moisTest = "2015-02";
        assertTrue(validateurDesDonnees.validerDateAppartientMois(moisTest, dateTest));
    }

    
    @Test
    public void testValiderDateAppartientMoisInvalide() {
        String dateTest  = "2015-02-14";
        String moisTest = "2015-08";
        assertFalse(validateurDesDonnees.validerDateAppartientMois(moisTest, dateTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin0() {
        int soinTest  = 0;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin100() {
        int soinTest  = 100;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin150() {
        int soinTest  = 150;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin175() {
        int soinTest  = 175;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin200() {
        int soinTest  = 200;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin300() {
        int soinTest  = 300;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin399() {
        int soinTest  = 399;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin400() {
        int soinTest  = 400;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin500() {
        int soinTest  = 500;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin600() {
        int soinTest  = 600;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin700() {
        int soinTest  = 700;
        assertTrue(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderNumeroSoin710Invalide() {
        int soinTest  = 710;
        assertFalse(validateurDesDonnees.validerNumeroSoin(soinTest));
    }
    
    
    @Test
    public void testValiderMontantStringPoint() {
        String testMontant  = "1042.20$";
        assertTrue(validateurDesDonnees.validerMontantString(testMontant));
    }
    
    
    @Test
    public void testValiderMontantStringVirgule() {
        String testMontant  = "1042,20$";
        assertTrue(validateurDesDonnees.validerMontantString(testMontant));
    }
    
    
    @Test
    public void testValiderMontantStringInvalideNegatif() {
        String testMontant  = "-1042.20$";
        assertFalse(validateurDesDonnees.validerMontantString(testMontant));
    }
    
    @Test
    public void testValiderMontantStringInvalidePasDeSigneDollar() {
        String testMontant  = "1042.20";
        assertFalse(validateurDesDonnees.validerMontantString(testMontant));
    }
    
    
    @Test
    public void testValiderMontantStringInvalidePointMauvaisEndroit() {
        String testMontant  = "104,220$";
        assertFalse(validateurDesDonnees.validerMontantString(testMontant));
    }
    
    
    @Test
    public void testValiderMontantStringInvalideDollarMauvaisEndroit() {
        String testMontant  = "1042$2";
        assertFalse(validateurDesDonnees.validerMontantString(testMontant));
    }
    
    
    @Test
    public void testValiderMontantStringInvalideNulle() {
        String testMontant  = "";
        assertFalse(validateurDesDonnees.validerMontantString(testMontant));
    }
    
    
    @Test
    public void testValiderMontantStringZero() {
        String testMontant  = "0.00$";
        assertTrue(validateurDesDonnees.validerMontantString(testMontant));
    }
    
    
    @Test
    public void testValiderStringEnIntegerPositifPlus() {
        String testEntier = "1";
        assertTrue(validateurDesDonnees.validerStringEnIntegerPositif(testEntier));
    }
    
    
    @Test
    public void testValiderStringEnIntegerPositifZero() {
        String testEntier = "0";
        assertTrue(validateurDesDonnees.validerStringEnIntegerPositif(testEntier));
    }
    
    
    @Test
    public void testValiderStringEnIntegerPositifMoins() {
        String testEntier = "-1";
        assertFalse(validateurDesDonnees.validerStringEnIntegerPositif(testEntier));
    }
    
    
    @Test
    public void testValiderStringEnIntegerPositifMontantDollar() {
        String testMontant = "2.18$";
        assertFalse(validateurDesDonnees.validerStringEnIntegerPositif(testMontant));
    }
    
    
    @Test
    public void testValiderStringEnIntegerPositifDouble() {
        String testDouble = "4.92";
        assertFalse(validateurDesDonnees.validerStringEnIntegerPositif(testDouble));
    }
    
    
     @Test
    public void testValiderStringEnIntegerPositif_String() {
        String testChaine = "une chaine";
        assertFalse(validateurDesDonnees.validerStringEnIntegerPositif(testChaine));
    }
}
