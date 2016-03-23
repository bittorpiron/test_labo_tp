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

public class Calc {

    Integer dernier = null;

    public Integer additionner(Integer a, Integer b) {
        if(a == null) {
            throw new IllegalArgumentException("a cannot be null");
        }
        if(b == null) {
            throw new IllegalArgumentException("b cannot be null");
        }
        return a + b;
    }

    public Integer multiplier(Integer a, Integer b) {
        if(a == null) {
            throw new IllegalArgumentException("a cannot be null");
        }
        if(b == null) {
            throw new IllegalArgumentException("b cannot be null");
        }
        Integer res = 0;
        Boolean neg = false;
        if(b < 0) {
            neg = true;
            b = Math.abs(b);
        }
        for(Integer i = 0; i < b; i++) {
            res += a;
        }
        if(neg) {
            res = -res;
        }
        dernier = res;
        return res;
    }

    public void reinitialiser() {
        dernier = null;
    }
}
