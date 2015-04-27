
package org.equipe21.projetsession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatistiquesTest {

    private Statistiques stats;
    
    
    @Before
    public void setUp() {
        stats = new Statistiques();
    }
    
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testGetNbReclamationsValidesTraiteesEtatInitial() {
        assertTrue(stats.getNbReclamationsValidesTraitees() == 0);
    }

    
    @Test
    public void testIncrementerNbReclamationsValidesTraitees() {
        for (int i = 0; i < 15; i++) {
            stats.incrementerNbReclamationsValidesTraitees();
        }
        assertTrue(stats.getNbReclamationsValidesTraitees() == 15);
    }

    
    @Test
    public void testGetNbReclamationsRejeteesEtatInitial() {
        assertTrue(stats.getNbReclamationsRejetees() == 0);
    }

    
    @Test
    public void testIncrementerNbReclamationsRejetees() {
        for (int i = 0; i < 15; i++) {
            stats.incrementerNbReclamationsRejetees();
        }
        assertTrue(stats.getNbReclamationsRejetees() == 15);
    }

    
    @Test
    public void testIncrementerNbSoinDeclare() {
        stats.incrementerNbCategorieSoinDeclare("Soins dentaires");
        stats.incrementerNbCategorieSoinDeclare("Soins dentaires");
        
        for (int i = 0; i < 5; i++) {
            stats.incrementerNbCategorieSoinDeclare("Massothérapie");
        }
        
        assertTrue(stats.getNbCategorieSoinDeclare("Soins dentaires") == 2);
        assertTrue(stats.getNbCategorieSoinDeclare("Massothérapie") == 5);
    }
}