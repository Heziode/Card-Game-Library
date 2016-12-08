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

/**
 * Paquet de cartes
 */
public abstract class AbstractDeck<C extends AbstractCard> {

    /**
     * Liste des cartes du paquet
     */
    private ObservableList<C> deck;

    /**
     * Création d'un nouveau paquet vide
     */
    public AbstractDeck() {
        this.deck = FXCollections.<C>observableArrayList();
    }

    /**
     * Récupération de la liste de cartes du paquet<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return Retourne la liste de cartes
     */
    public final ObservableList<C> getDeck() {
        return this.deck;
    }

    /**
     * Modification complète du deck<br>
     * Est final pour empêcher la redéfinition.
     *
     * @param deck : Nouveau deck
     */
    public final void setDeck(ObservableList<C> deck) {
        this.deck = deck;
    }

    /**
     * Vérifie si le deck est vide<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return Retourne true si le deck est vide, false sinon
     */
    public final boolean isEmpty() {
        return this.deck.isEmpty();
    }

    /**
     * Remplis le paquet de cartes d'un certain nombre de paquets.
     *
     * @param nbPackage Nombre de paquets de cartes ajouté au deck
     */
    public abstract void fill(int nbPackage);

    /**
     * Pioche une carte du deck
     *
     * @return la carte piocher
     */
    public C draw() {
        return this.deck.remove(deck.size() - 1);
    }

    /**
     * Ajoute une carte à liste de carte
     *
     * @param card Cate à ajouter
     */
    public void addCard(C card) {
        this.deck.add(card);
    }

}