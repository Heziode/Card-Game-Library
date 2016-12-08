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

package cardgamebase.model.card;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Classe de Test de la Classe SimpleCard
 */
public class SimpleCardTest {

    /**
     * Attribut Card à tester
     */
    private SimpleCard card;

    /**
     * Initialisation des attributs avec les tests
     */
    @Before
    public void setUp() {
        card = new SimpleCard(Color.CLUB, 10);
    }

    /**
     * Test de la méthode isAs
     * renvoie un boolean qui indique si la carte est un AS ou non
     *
     * @throws Exception
     */
    @Test
    public void isAS() throws Exception {
        assertNotNull(card.isAS());
        assertFalse(card.isAS());
    }

    /**
     * Test de la méthode getColor
     * renvoie la couleur de la carte
     *
     * @throws Exception
     */
    @Test
    public void getColor() throws Exception {
        assertNotNull(card.getColor());
        assertEquals(Color.CLUB, card.getColor());
    }

    /**
     * Test de la méthode isVisible
     * renvoie un boolean qui indique si la carte est visible ou non
     *
     * @throws Exception
     */
    @Test
    public void isVisible() throws Exception {
        assertNotNull(card.isVisible());
        assertTrue(card.isVisible());
    }

    /**
     * Test de la méthode setVisible
     * change la visibilité de la carte
     *
     * @throws Exception
     */
    @Test
    public void setVisible() throws Exception {
        card.setVisible(false);
        assertFalse(card.isVisible());
    }

    /**
     * Test de la méthode setColor
     * change la couleur de la carte
     *
     * @throws Exception
     */
    @Test
    public void setColor() throws Exception {
        card.setColor(Color.DIAMOND);
        assertEquals(Color.DIAMOND, card.getColor());
    }

    /**
     * Test de la méthode setValue
     * change la valeur de la carte
     *
     * @throws Exception
     */
    @Test
    public void setValue() throws Exception {
        card.setValue(5);
        assertEquals(5, card.getValue());
    }

}