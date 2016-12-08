/*
 * (The MIT License)
 *
 * Copyright (c) 2016 - Dauprat Quentin, Duval Florian, Girault Jeoffrey & Michel Fabien
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package cardgamebase.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Classe de test de la classe SimpleGameRules
 */
public class SimpleGameRulesTest {

    /**
     * attribut GameRules à tester
     */
    private SimpleGameRules gameRules1, gameRules2, gameRules3;

    /**
     * initialisation des attributs avant les tests
     */
    @Before
    public void setUp() {
        gameRules1 = new SimpleGameRules();
        gameRules2 = new SimpleGameRules(2);
        gameRules3 = new SimpleGameRules(2, 2);
    }

    /**
     * Test de la méthode getNumberOfHand
     * assesseur renvoyant le nombre de mains
     *
     * @throws Exception
     */
    @Test
    public void getNumberOfHand() throws Exception {
        assertNotNull(gameRules1.getNumberOfHand());
        assertNotNull(gameRules2.getNumberOfHand());
        assertNotNull(gameRules3.getNumberOfHand());

        assertEquals(1, gameRules1.getNumberOfHand());
        assertEquals(2, gameRules2.getNumberOfHand());
        assertEquals(2, gameRules3.getNumberOfHand());
    }

    /**
     * Test sur la méthode setNumberOfHand
     * mutateur changeant le nombre de mains
     *
     * @throws Exception
     */
    @Test
    public void setNumberOfHand() throws Exception {
        gameRules1.setNumberOfHand(3);
        gameRules2.setNumberOfHand(3);
        gameRules3.setNumberOfHand(3);

        assertEquals(3, gameRules1.getNumberOfHand());
        assertEquals(3, gameRules2.getNumberOfHand());
        assertEquals(3, gameRules3.getNumberOfHand());
    }

    /**
     * Test de la méthode getNumberOfCardByHand
     * assesseur permettant de changer la valeur du nombre de carte par mains
     *
     * @throws Exception
     */
    @Test
    public void getNumberOfCardByHand() throws Exception {
        assertEquals(-1, gameRules1.getNumberOfCardByHand());
        assertEquals(-1, gameRules2.getNumberOfCardByHand());
        assertEquals(2, gameRules3.getNumberOfCardByHand());
    }

    /**
     * Test de la méthode setNumberOfCardByHand
     * mutateur changeant la valeur du nombre de cartes par mains
     *
     * @throws Exception
     */
    @Test
    public void setNumberOfCardByHand() throws Exception {
        gameRules1.setNumberOfCardByHand(2);
        gameRules2.setNumberOfCardByHand(2);
        gameRules3.setNumberOfCardByHand(2);

        assertEquals(2, gameRules1.getNumberOfCardByHand());
        assertEquals(2, gameRules2.getNumberOfCardByHand());
        assertEquals(2, gameRules3.getNumberOfCardByHand());
    }

}