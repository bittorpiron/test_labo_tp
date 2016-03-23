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
package etudiant;

import static com.sun.xml.internal.fastinfoset.stax.events.EmptyIterator.instance;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class EtudiantTest {

    @Test
    public void testGetAge_0ans() {
        Integer exp = 0;
        Etudiant e = new Etudiant("Doe", "John", new Date());
        assertEquals(exp, e.getAge());
    }

    @Test
    public void testGetAge_21ans() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat anneeFormat = new SimpleDateFormat("yyyy");

        Integer anneeCour = Integer.parseInt(anneeFormat.format(new Date()));
        Integer age = 21;

        Date naiss = dateFormat.parse("02/03/" + (anneeCour - age));
        Etudiant e = new Etudiant("Doe", "John", naiss);

        Integer result = e.getAge();
        assertEquals(age, result);
    }

}
