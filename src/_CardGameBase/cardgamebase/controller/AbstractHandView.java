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

import cardgamebase.model.AbstractGameRules;
import cardgamebase.model.actor.AbstractActor;
import cardgamebase.model.actor.SimplePlayer;
import cardgamebase.model.card.AbstractCard;
import cardgamebase.model.card.AbstractDeck;
import cardgamebase.model.card.AbstractHand;
import cardgamebase.model.card.SimpleHand;
import javafx.beans.InvalidationListener;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Classe gérant l'affichage d'une main
 *
 * @param <P> Classe qui étend {@link SimplePlayer} paramétré par H et G, qui correspond au type d'acteur (joueur) de la
 *            main
 * @param <H> Classe qui étend {@link SimpleHand} correspondant au type de la main concrète de l'acteur
 * @param <G> Classe qui étend {@link AbstractGameRules} correspondant au type concrète de règles du jeu de l'acteur
 * @param <C> Classe qui étend {@link AbstractCard} correspond au type concrète de carte utiliser dans le jeu
 */
public abstract class AbstractHandView<P extends AbstractActor<D, H, C, G>, D extends AbstractDeck<C>, H extends
        AbstractHand<C>, C extends AbstractCard, G extends AbstractGameRules>
        implements ViewBySprite<C> {

    /**
     * Décalage X pour l'affichage de carte (on ne veut pas voir qu'une seule carte car elles sont empilées)
     */
    public static int SHIFT_X = 25;

    /**
     * Décalage Y pour l'affichage de carte (on ne veut pas voir qu'une seule carte car elles sont empilées)
     */
    public static int SHIFT_Y = 0;

    /**
     * Joueur à observer
     */
    private P player;

    /**
     * Index de la main du joueur
     */
    private int index;

    /**
     * Panel qui contiendra les cartes
     */
    private AnchorPane anchorPane;

    /**
     * Constructeur logique
     *
     * @param actor      Référence vers un acteur (joueur)
     * @param index      Référence vers l'index d'une des mains du joueur
     * @param anchorPane Référence vers le panel qui contiendra tout l'affichage de la main de l'acteur
     */
    public AbstractHandView(P actor, int index, AnchorPane anchorPane) {
        this.player = actor;
        this.index = index;
        this.anchorPane = anchorPane;

        // Affecte un écouteur pour détecter lorsque la main d'un joueur change (ajout de carte par exemple)
        actor.getHandsList().get(this.index).getHandCards()
                .addListener((InvalidationListener) change -> generateView());

        generateView();
    }

    /**
     * Représente un jeu de cartes
     */
    public void generateView() {

        H hand = player.getHandsList().get(this.index);

        for (int i = 0; i < hand.getHandCards().size(); i++) {
            C card = hand.getHandCards().get(i);
            ImageView cardView = null;

            double x = getColumn(card);
            double y = getLine(card);

            if (card.isVisible()) {
                cardView = SpriteCard.getCard(x, y);

            }
            else {
                cardView = SpriteCard.getBackCard();
            }
            cardView.setX(i * SHIFT_X);
            cardView.setY(i * SHIFT_Y);
            this.anchorPane.getChildren().add(cardView);
        }
    }
}
