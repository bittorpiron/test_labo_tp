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

import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void testMultiplier_valeurs_positives() {
        Calc instance = new Calc();
        Integer expResult = 12;
        Integer result = instance.multiplier(3, 4);
        assertEquals(expResult, result);
    }

    @Test
    public void testMultiplier_une_valeur_negative() {
        Calc instance = new Calc();
        Integer expResult = -12;
        Integer result = instance.multiplier(3, -4);
        assertEquals(expResult, result);
    }

    @Test
    public void testMultiplier_deux_valeurs_negatives() {
        Calc instance = new Calc();
        Integer expResult = 12;
        Integer result = instance.multiplier(-3, -4);
        assertEquals(expResult, result);
    }

    @Test
    public void testMultiplier_positif_par_0() {
        Calc instance = new Calc();
        Integer expResult = 0;
        Integer result = instance.multiplier(3, 0);
        assertEquals(expResult, result);
    }

    @Test
    public void testMultiplier_negatif_par_0() {
        Calc instance = new Calc();
        Integer expResult = 0;
        Integer result = instance.multiplier(-3, 0);
        assertEquals(expResult, result);
    }

    @Test
    public void testMultiplier_negatif_0_par_0() {
        Calc instance = new Calc();
        Integer expResult = 0;
        Integer result = instance.multiplier(0, 0);
        assertEquals(expResult, result);
    }

    @Test(timeout=100)
    public void testMultiplier_doit_finir() {
        Calc instance = new Calc();
        Integer expResult = 100;
        Integer result = instance.multiplier(10, 10);
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testMultiplier_a_is_null_throws_exception() {
        Calc instance = new Calc();
        instance.multiplier(null, 10);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testMultiplier_b_is_null_throws_exception() {
        Calc instance = new Calc();
        instance.multiplier(10, null);
    }

    @Test
    public void testAdditionner_a_b_positifs() {
        Calc instance = new Calc();
        Integer exp = 2;
        Integer res = instance.additionner(1, 1);
        assertEquals(exp, res);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testAdditionner_a_est_null_exception() {
        Calc instance = new Calc();
        instance.additionner(null, 1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testAdditionner_b_est_null_exception() {
        Calc instance = new Calc();
        instance.additionner(1, null);
    }

}
