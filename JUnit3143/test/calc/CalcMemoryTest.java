/*
 * Copyright 2015 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package calc;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CalcMemoryTest {

    Calc instance = new Calc();

    @After
    public void tearDown() {
        instance.reinitialiser();
    }

    @Test
    public void testMultiplier_sans_derniere_valeur() {
        assertNull(instance.dernier);
    }

    @Test
    public void testMultiplier_avec_derniere_valeur() {
        Integer expResult = 100;
        instance.multiplier(10, 10);
        assertEquals(expResult, instance.dernier);
    }

    @Test
    public void testMultiplier_apres_reinit_derniere_est_nul() {
        instance.multiplier(10, 10);
        instance.reinitialiser();
        assertNull(instance.dernier);
    }
}
