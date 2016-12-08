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

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Classe de test de la classe SimpleHand
 */
public class SimpleHandTest {

    /**
     * Attribut SimpleHand à tester
     */
    private SimpleHand simpleHand;

    /**
     * Cartes de la main
     */
    private SimpleCard card1, card2, card3;

    /**
     * Initialisation de l'attribut avant les tests
     */
    @Before
    public void setup() {
        simpleHand = new SimpleHand();

        card1 = new SimpleCard(Color.DIAMOND, 10);
        card2 = new SimpleCard(Color.DIAMOND, 9);
        card3 = new SimpleCard(Color.CLUB, 9);
    }

    /**
     * Test de la methode setHandCards
     * mutateur de la classe qui change les cartes de la main
     *
     * @throws Exception
     */
    @Test
    public void setHandCards() throws Exception {

        LinkedList<SimpleCard> cards = new LinkedList<SimpleCard>();

        cards.add(card1);
        cards.add(card2);

        ObservableList<SimpleCard> hand = FXCollections.observableList(cards);
        simpleHand.setHandCards(hand);

        assertNotNull(simpleHand.getHandCards());
        assertEquals(2, simpleHand.size());
        assertEquals(card1, simpleHand.getHandCards().get(0));
        assertEquals(card2, simpleHand.getHandCards().get(1));
    }

    /**
     * Test de la methode addCard
     * Rajoute une carte à la main
     *
     * @throws Exception
     */
    @Test
    public void addCard() throws Exception {
        SimpleCard card1 = new SimpleCard(Color.DIAMOND, 10);
        simpleHand.addCard(card1);

        assertNotNull(simpleHand.getHandCards());
        assertEquals(1, simpleHand.size());
        assertEquals(card1, simpleHand.getHandCards().get(0));
    }

    /**
     * Test de la methode removeCardAt
     * retire de la main la carte à l'indice passé en paramètre
     *
     * @throws Exception
     */
    @Test
    public void removeCardAt() throws Exception {
        simpleHand.addCard(card1);
        simpleHand.addCard(card2);
        simpleHand.addCard(card3);

        simpleHand.removeCardAt(1);

        assertNotNull(simpleHand.getHandCards());
        assertEquals(2, simpleHand.size());
        assertEquals(card1, simpleHand.getCardAt(0));
        assertEquals(card3, simpleHand.getCardAt(1));
    }
}