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

import java.util.ArrayList;
import java.util.List;

public class MailSenderTest implements MailSender {

    List<Email> emails = new ArrayList<>();

    @Override
    public void send(String permaCode, String subject, String message) {
        emails.add(new Email(permaCode, subject, message));
    }

    public class Email {

        public String permaCode;
        public String sujet;
        public String message;

        public Email(String permaCode, String sujet, String message) {
            this.permaCode = permaCode;
            this.sujet = sujet;
            this.message = message;
        }
    }
}

