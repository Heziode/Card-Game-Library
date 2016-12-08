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

import javafx.collections.ObservableList;

/**
 * Classe abstraite d'une main définissant un ensemble de services
 */
public abstract class AbstractHand<C extends AbstractCard> {

    /**
     * Liste des cartes de la main
     */
    protected ObservableList<C> handCards;

    /**
     * Ajoute une carte à la main
     *
     * @param card Carte à ajouter
     */
    public abstract void addCard(C card);

    /**
     * Supprime une carte dans la main à la position donnée en paramètre et la retourne
     *
     * @param position Position de la carte à supprimer
     * @return Retourne la carte supprimer
     */
    public abstract C removeCardAt(int position);

    /**
     * Agis comme removeCardAt mais ne supprime pas la carte
     *
     * @param position Position de la carte à récupérer
     * @return Retourne la carte demander
     * @see AbstractHand#removeCardAt(int)
     */
    public abstract C getCardAt(int position);

    /**
     * Retourne la taille de la main
     *
     * @return Retourne la taille de la main (le nombre de cartes qu'elle contient)
     */
    public abstract int size();

    /**
     * Récupère la liste des cartes de la main<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return Retourne la liste observable des cartes de la main
     */
    public abstract ObservableList<C> getHandCards();

    /**
     * Affecte la liste des cartes de la main<br>
     * Est final pour empêcher la redéfinition.
     *
     * @param hand Nouvelle liste de carte
     */
    public abstract void setHandCards(ObservableList<C> hand);

}
