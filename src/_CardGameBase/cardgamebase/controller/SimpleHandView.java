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

package cardgamebase.controller;

import cardgamebase.model.SimpleGameRules;
import cardgamebase.model.actor.SimplePlayer;
import cardgamebase.model.card.AbstractDeck;
import cardgamebase.model.card.SimpleCard;
import cardgamebase.model.card.SimpleHand;
import javafx.scene.layout.AnchorPane;

/**
 * Représentation simple des cartes d'un joueur
 */
public class SimpleHandView<P extends SimplePlayer<D, H, SimpleCard, G>, H extends SimpleHand, G extends
        SimpleGameRules, D extends AbstractDeck<SimpleCard>> extends AbstractHandView<P, D, H, SimpleCard, G> {

    /**
     * Constructeur logique
     *
     * @param actor      Référence vers un acteur (joueur)
     * @param index      Référence vers l'index d'une des mains du joueur
     * @param anchorPane Référence vers le panel qui contiendra tout l'affichage de la main du joueur
     */
    public SimpleHandView(P actor, int index, AnchorPane anchorPane) {
        super(actor, index, anchorPane);
    }

    @Override
    public final double getColumn(SimpleCard card) {
        return (card.getValue() - 1) * SpriteCard.width;
    }

    @Override
    public final double getLine(SimpleCard card) {
        return card.getColor().ordinal() * SpriteCard.height;
    }
}
