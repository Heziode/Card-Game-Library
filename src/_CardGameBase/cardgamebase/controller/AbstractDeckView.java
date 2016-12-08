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

import cardgamebase.model.card.AbstractCard;
import cardgamebase.model.card.AbstractDeck;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Représentation d'un jeu de cartes
 *
 * @param <D> Classe qui étend {@link AbstractDeck} paramétré par C
 * @param <C> Classe qui étend {@link AbstractCard}
 */
public abstract class AbstractDeckView<D extends AbstractDeck<C>, C extends AbstractCard> implements ViewBySprite<C> {

    /**
     * Décalage X pour l'affichage de carte (on ne veut pas voir qu'une seule carte car elles sont empilées)
     */
    public static int MAX_SHIFT_X = 0;

    /**
     * Décalage Y pour l'affichage de carte (on ne veut pas voir qu'une seule carte car elles sont empilées)
     */
    public static int MAX_SHIFT_Y = 25;

    /**
     * Référence vers le jeu de carte de la partie
     */
    private D deck;

    /**
     * Décalage entre chaque carte en x
     */
    private double shiftX;

    /**
     * Décalage entre chaque carte en y
     */
    private double shiftY;

    /**
     * Panel qui contiendra les cartes
     */
    private AnchorPane anchorPane;

    /**
     * Détermine si les cartes doivent être visibles ou non
     */
    private BooleanProperty visible;

    /**
     * Constructeur logique
     *
     * @param anchorPane Référence vers le pane qui contiendra l'ensemble des cartes
     * @param visible    Boolean définissant si les cartes doivent être visibles ou non
     * @param deck       Référence vers le jeu de cartes à afficher
     */
    protected AbstractDeckView(AnchorPane anchorPane, boolean visible, D deck) {
        this.anchorPane = anchorPane;
        this.visible = new SimpleBooleanProperty(visible);
        this.deck = deck;

        // Calcul d'un rapport de décalage pour que suivant le nombre de cartes, cela prenne au max la valeur définie
        shiftX = (double) MAX_SHIFT_X / (deck.getDeck().size());
        shiftY = (double) MAX_SHIFT_Y / (deck.getDeck().size());

        this.visible.addListener((observable, oldValue, newValue) -> {
            generateView();
        });

        // Définit le changeListener du deck
        ListChangeListener<? super C> deckListChangeListener = c -> {
            generateView();
        };

        this.deck.getDeck().removeListener(deckListChangeListener);
        this.deck.getDeck().addListener(deckListChangeListener);

        generateView();
    }

    /**
     * Représente un jeu de cartes
     */
    public void generateView() {
        anchorPane.getChildren().removeAll(anchorPane.getChildren());
        Double currentShiftX = 0d;
        Double currentShiftY = 0d;

        for (int i = 0; i < deck.getDeck().size(); i++) {
            ImageView cardView = null;

            double x = getColumn(deck.getDeck().get(i));
            double y = getLine(deck.getDeck().get(i));

            // Affiche le recto ou le verso de la carte suivant l'état de visible
            cardView = visible.getValue() ? SpriteCard.getCard(x, y) : SpriteCard.getBackCard();

            cardView.setX(-currentShiftX.intValue());
            cardView.setY(-currentShiftY.intValue());
            this.anchorPane.getChildren().add(cardView);

            currentShiftX += shiftX;
            currentShiftY += shiftY;
        }
    }
}
