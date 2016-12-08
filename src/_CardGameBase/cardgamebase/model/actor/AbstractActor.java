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
import javafx.collections.ObservableList;

/**
 * Classe abstraite proposant des services de bases pour un acteur (joueur) de jeux de cartes. Est abstrait car il
 * utilise des propriétés pour ses services.
 */
public abstract class AbstractActor<D extends AbstractDeck<C>, H extends AbstractHand<C>, C extends AbstractCard, G
        extends AbstractGameRules> {

    /**
     * Définit l'emplacement de la première main
     */
    public static final int FIRST_HAND = 0;

    /**
     * Liste de mains d'un joueur
     */
    protected ObservableList<H> hands;

    /**
     * Référence vers les règles du jeu
     */
    protected G gameRules;

    /**
     * Nom du joueur
     */
    protected String name;

    /**
     * Permet de savoir le numéro de la main courante
     */
    protected IntegerProperty currentHand;

    /**
     * Permets de piocher une carte dans le deck
     *
     * @param deck Référence vers le jeu de cartes
     */
    public abstract void draw(D deck);

    /**
     * Méthode permettant de faire jouer un joueur
     */
    public abstract void play();

    /**
     * Récupération de la liste des mains<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return la liste de main du joueur
     */
    public abstract ObservableList<H> getHandsList();

    /**
     * Retourne la main actuelle du joueur
     *
     * @return Retourne la main actuelle du joueur
     */
    public abstract H getCurrentHand();

    /**
     * Retourne le nombre de mains du joueur
     *
     * @return Retourne le nombre de mains du joueur
     */
    public abstract int getNumberOfHands();

    /**
     * Récupère le nom du joueur
     *
     * @return Retourne le nom du joueur
     */
    public abstract String getName();

    /**
     * Affecte le nom du joueur
     *
     * @param name Nom du joueur
     */
    public abstract void setName(String name);

    /**
     * Accesseur observable de currentHand<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return Retourne la main courante
     */
    public abstract IntegerProperty getCurrentHandProperty();

    /**
     * Retourne le numéro de la main courante
     *
     * @return position de la main courante
     */
    public abstract int getIntCurrentHand();

    /**
     * Permets de supprimer (détruire) l'ensemble des mains du joueur et d'en créer une nouvelle.
     */
    public abstract void reinitializeHand();
}
