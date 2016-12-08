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

package cardgamebase.model.actor;

import cardgamebase.model.AbstractGameRules;
import cardgamebase.model.card.AbstractCard;
import cardgamebase.model.card.AbstractDeck;
import cardgamebase.model.card.AbstractHand;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe de gestion simple d'un joueur d'un jeu de cartes
 */
public abstract class SimplePlayer<D extends AbstractDeck<C>, H extends AbstractHand<C>, C extends AbstractCard, G
        extends AbstractGameRules>
        extends AbstractActor<D, H, C, G> {

    /**
     * Constructeur logique
     *
     * @param gameRules Référence vers les règles du jeu
     */
    public SimplePlayer(G gameRules) {
        hands = FXCollections.<H>observableArrayList();
        currentHand = new SimpleIntegerProperty(FIRST_HAND);
        this.gameRules = gameRules;
    }

    /**
     * Passage à la prochaine main du joueur bloqué par les règles
     */
    public void nextHand() {
        int nextNumber = (currentHand.get() + 1) % gameRules.getNumberOfHand();
        if (hands.size() > nextNumber) {
            currentHand.setValue(nextNumber);
        }
    }

    @Override
    public void draw(D deck) {
        if (gameRules.getNumberOfCardByHand() == -1 || gameRules.getNumberOfCardByHand() > getCurrentHand().size()) {
            getCurrentHand().addCard(deck.draw());
        }
    }

    @Override
    public ObservableList<H> getHandsList() {
        return this.hands;
    }

    @Override
    public H getCurrentHand() {
        return hands.get(currentHand.get());
    }

    @Override
    public int getNumberOfHands() {
        return hands.size();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public final IntegerProperty getCurrentHandProperty() {
        return currentHand;
    }

    @Override
    public int getIntCurrentHand() {
        return currentHand.getValue();
    }

    @Override
    public final void reinitializeHand() {
        try {
            this.finalize();
            this.hands = FXCollections.<H>observableArrayList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
