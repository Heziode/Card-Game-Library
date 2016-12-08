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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Classe de test de la classe SimpleDeck
 */
public class SimpleDeckTest {

    /**
     * Attribut Deck à tester
     */
    private SimpleDeck deck;

    /**
     * Initialisation des attributs avant les tests
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        deck = new SimpleDeck();
        deck.fill(2);
    }

    /**
     * Test de la méthode isEmpty
     * qui renvoie un boolean afin de savoir si la liste est vide ou non
     *
     * @throws Exception
     */
    @Test
    public void isEmpty() throws Exception {
        assertNotNull(deck.isEmpty());
        assertFalse(deck.isEmpty());
    }

    /**
     * Test de la méthode setDeck
     * Mutateur de la classe qui change le contenu du deck par un nouveau
     *
     * @throws Exception
     */
    @Test
    public void setDeck() throws Exception {
        ObservableList<SimpleCard> deckbis = FXCollections.observableArrayList();
        deck.setDeck(deckbis);
        assertEquals(deckbis, deck.getDeck());
    }

    /**
     * Test de la méthode draw
     * méthode qui renvoie la carte piochée
     *
     * @throws Exception
     */
    @Test
    public void draw() throws Exception {
        int length = deck.getDeck().size();
        SimpleCard card = deck.getDeck().get(deck.getDeck().size() - 1);
        assertEquals(card, deck.draw());
        assertEquals(length - 1, deck.getDeck().size());
    }

}