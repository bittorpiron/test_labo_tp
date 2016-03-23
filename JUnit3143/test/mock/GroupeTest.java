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
package mock;

import org.junit.Test;
import static org.junit.Assert.*;

public class GroupeTest {

    @Test
    public void testMailGroupe() {
        Etudiant e1 = new Etudiant("DOEJ871012");
        Etudiant e2 = new Etudiant("PLOJ920429");

        MailSenderTest testSender = new MailSenderTest();
        Groupe g = new Groupe(testSender);
        g.addEtudiant(e1);
        g.addEtudiant(e2);

        g.mailGroupe("Test Subject", "Test Message");
        assertEquals(testSender.emails.size(), 2);
    }
}
