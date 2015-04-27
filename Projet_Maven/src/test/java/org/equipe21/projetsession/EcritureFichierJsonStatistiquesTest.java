package org.equipe21.projetsession;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EcritureFichierJsonStatistiquesTest {
    
    MockWriter writer;
    Statistiques stats;
    EcritureFichierJsonStatistiques ecrit;
    
    public EcritureFichierJsonStatistiquesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        writer = new MockWriter();
        stats = new Statistiques();
        stats.incrementerNbReclamationsValidesTraitees();
        stats.incrementerNbReclamationsRejetees();
        stats.incrementerNbCategorieSoinDeclare("Soins dentaires");
        stats.incrementerNbCategorieSoinDeclare("Massothérapie");
        ecrit = new EcritureFichierJsonStatistiques(stats);
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testEcrireLesDonnees() throws IOException{
        String donneesTest =  "{\n" +
            "    \"nb_reclamations_valide_traitees\": 1,\n" +
            "    \"nb_reclamations_rejetees\": 1,\n" +
            "    \"nb_soins_declares\":     {\n" +
            "        \"Soins dentaires\": 1,\n" +
            "        \"Massothérapie\": 1\n" +
            "    }\n" +
            "}" ;
        ecrit.ecrireLesDonnees(writer);
        assertEquals(donneesTest, writer.getWrittenData());
    }
}
