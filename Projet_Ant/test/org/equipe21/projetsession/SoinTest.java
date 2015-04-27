package org.equipe21.projetsession;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SoinTest {
    
    public Soin soin = new Soin(-1, "", "0.00$"); 
    
    public SoinTest() {
    }
    

    @BeforeClass
    public static void setUpClass() {
        

    }
    

    @AfterClass
    public static void tearDownClass() {
    }
    

    @Before
    public void setUp() {
        soin.setTotalActuel(new Dollar(400.00));
        soin.setNbrTraitements(33);
    }
    

    @After
    public void tearDown() {
    }

    
    @Test
    public void testCalculerMontantMensuel_PasDeMax() {
        Dollar nouveauMontant = (new Dollar(200.00));    
        soin.setMaximumMensuel(new Dollar(0.00));
        
        Dollar expResult = nouveauMontant;
        Dollar expResultTotale = Dollar.additionDollars(soin.getTotalActuel(), nouveauMontant);
        
        Dollar result = soin.calculerMontantMensuel(nouveauMontant);
        assertEquals(expResult, result);

        result = soin.getTotalActuel();
        assertEquals(expResultTotale, result);
    }
    
        
    @Test
    public void testCalculerMontantMensuel_Limite() {
        Dollar nouveauMontant = new Dollar(200.00);
        soin.setMaximumMensuel(new Dollar(600.00)); 
        
        Dollar expResult = nouveauMontant;
        Dollar expResultTotale = Dollar.additionDollars(soin.getTotalActuel(), nouveauMontant);
        
        Dollar result = soin.calculerMontantMensuel(nouveauMontant);
        assertEquals(expResult, result);
        
        result = soin.getTotalActuel();
        assertEquals(expResultTotale, result);
    }
    
    
    @Test
    public void testCalculerMontantMensuel_NeDepassePas() {
        Dollar nouveauMontant = new Dollar(100.00);
        soin.setMaximumMensuel(new Dollar(600.00)); 
        
        
        Dollar expResult = nouveauMontant;
        Dollar expResultTotale = Dollar.additionDollars(soin.getTotalActuel(), nouveauMontant);
        
        Dollar result = soin.calculerMontantMensuel(nouveauMontant);
        assertEquals(expResult, result);
        
        result = soin.getTotalActuel();
        assertEquals(expResultTotale, result);
    }
    
    
    @Test
    public void testCalculerMontantMensuel_Depasse() {
        Dollar nouveauMontant = new Dollar(200.01);
        soin.setMaximumMensuel(new Dollar(600.00)); 
 
        Dollar expResult =  Dollar.soubstractionDollars(soin.getMaximumMensuel(), soin.getTotalActuel());
        Dollar expResultTotale = soin.getMaximumMensuel();
        
        Dollar result = soin.calculerMontantMensuel(nouveauMontant);
        assertEquals(expResult, result);

        
        result = soin.getTotalActuel();
        assertEquals(expResultTotale, result);
    }

}
