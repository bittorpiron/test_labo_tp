package org.equipe21.projetsession;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReclamationAssuranceTest {
    
    /**
     * Cette librairie nous permet de tester les sorties console (comme un wrapper)
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    
    public ReclamationAssuranceTest() {        
    }
    

    @BeforeClass
    public static void setUpClass() {
    }
    

    @AfterClass
    public static void tearDownClass() {
    }
    

    @Before
    public void setUp() {
    }
    

    @After
    public void tearDown() {
    }

    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    
    @Test
    public void testMain() throws Exception {
        String[] args = new String[0];
        ReclamationAssurance.main(args);
        String sortieConsole = outContent.toString();
        assertEquals(Messages.NOMBRE_ARGUMENTS_INVALIDE , sortieConsole.substring(0, sortieConsole.length()-2));
    }
    
    @Test
    public void testReclamationAssurance_SansArguments() throws Exception {
        String[] args = new String[0];
        ReclamationAssurance reclamationAssurance = new ReclamationAssurance(args); 
        String sortieConsole = outContent.toString();
        assertEquals(Messages.NOMBRE_ARGUMENTS_INVALIDE , sortieConsole.substring(0, sortieConsole.length()-2));
    }

    @Test
    public void testReclamationAssurance_UnArgument() throws Exception {
        String[] args = {"argumententInvalide"};
        ReclamationAssurance reclamationAssurance = new ReclamationAssurance(args); 
        String sortieConsole = outContent.toString();
        assertEquals(Messages.ARGUMENT_INVALIDE , sortieConsole.substring(0, sortieConsole.length()-2));
    }
    
    
    @Test
    public void testReclamationAssurance_DeuxArguments() throws Exception {
        String[] args = {"argumentent1", "argumentent2"};
        ReclamationAssurance reclamationAssurance = new ReclamationAssurance(args); 
        String sortieConsole = outContent.toString();
        assertEquals(Messages.ECHEC_OUVERTURE_FICHIER , sortieConsole.substring(0, sortieConsole.length()-2));
    }
    
    
    @Test
    public void testReclamationAssurance_TropArguments() throws Exception {
        String[] args = {"argumentent1", "argumentent2", "argumentent2"};
        ReclamationAssurance reclamationAssurance = new ReclamationAssurance(args); 
        String sortieConsole = outContent.toString();
        assertEquals(Messages.NOMBRE_ARGUMENTS_INVALIDE , sortieConsole.substring(0, sortieConsole.length()-2));
    }


    @Test
    public void testProduireFichierSortieErreur() throws IOException {
        
        String[] args = {"argumentent1", "argumentent2"};
        ReclamationAssurance reclamationAssurance = new ReclamationAssurance(args); 
        
        String nomFichierSortie = "";
        String messageErreur = "";
        boolean expResult = false;
        boolean result = reclamationAssurance.produireFichierSortieErreur(nomFichierSortie, messageErreur);
        assertEquals(expResult, result);
    }


    @Test
    public void testDemanderConfirmation() throws Exception {

        boolean expResult = true;
        boolean result;
        result = ReclamationAssurance.demanderConfirmation(new ByteArrayInputStream("O".getBytes()));
        assertEquals(expResult, result);
    }

    
    @Test
    public void testDemanderConfirmation_Fail() throws Exception {

        boolean expResult = false;
        boolean result;
        result = ReclamationAssurance.demanderConfirmation(new ByteArrayInputStream("N".getBytes()));
        assertEquals(expResult, result);
    }

}
