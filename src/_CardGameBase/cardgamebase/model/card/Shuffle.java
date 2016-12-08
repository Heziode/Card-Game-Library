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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Classe regroupant des algo de mélange de cartes
 */
public final class Shuffle {

    /**
     * Constructeur privée pour empêcher l'instanciation
     */
    private Shuffle() {
    }

    /**
     * Méthode de mélange américain d'une liste de cartes
     *
     * @param deck      Deck à mélanger
     * @param nbMelange Nombre de fois que le mélange sera effectué
     * @param <C>       Paramètre générique qui étend {@link SimpleCard} permettant ainsi une spécialisation
     * @return Retourne le deck resultant
     */
    public static <C extends SimpleCard> List<C> american(List<C> deck, int nbMelange) {
        if (!deck.isEmpty()) {
            for (int i = 0; i < nbMelange; i++) {
                for (int j = deck.size() / 2; j < deck.size(); j++) {
                    C card = deck.remove(j);
                    deck.add((j - deck.size() / 2) * 2 - 1, card);
                }
            }
        }
        return deck;
    }

    /**
     * Mélange français d'une liste de cartes
     *
     * @param deck      Liste de cartes à mélanger
     * @param nbMelange Nombre de fois que le mélange sera effectué
     * @param <C>       Paramètre générique qui étend {@link SimpleCard} permettant ainsi une spécialisation
     * @return Retourne la liste de carte resultant
     */
    public static <C extends SimpleCard> List<C> french(List<C> deck, int nbMelange) {
        if (deck.isEmpty()) {
            return deck;
        }

        Random rand = new Random();
        LinkedList<C> list = new LinkedList<C>(deck);

        for (int i = 0; i < nbMelange; i++) {
            int lenght;
            LinkedList<C> tampList = new LinkedList<C>();
            while (list.size() > 0) {
                if (list.size() < 10) {
                    lenght = list.size();
                }
                else {
                    lenght = rand.nextInt(20) + 1;
                }
                if (lenght <= list.size()) {
                    for (int j = lenght; j > 0; j--) {
                        C card = list.remove(j - 1);
                        tampList.addLast(card);
                    }
                }
            }
            list = tampList;
        }

        return list;
    }

    /**
     * Effectue une coupe d'une liste de cartes
     *
     * @param deck Liste de cartes à couper
     * @param <C>  Paramètre générique qui étend {@link SimpleCard} permettant ainsi une spécialisation
     * @return Retourne la liste de carte resultant
     */
    public static <C extends SimpleCard> List<C> cut(List<C> deck) {
        if (!deck.isEmpty()) {
            for (int j = 0; j < deck.size() / 2; j++) {
                C card = deck.remove(0);
                deck.add(card);
            }
        }
        return deck;
    }

    /**
     * Réalise un mélange d'un jeu de cartes
     *
     * @param deck Jeu de cartes à mélanger
     * @param <C>  Paramètre générique qui étend {@link SimpleCard} permettant ainsi une spécialisation
     * @return Retourne le jeu de cartes mélanger (liste de type ArrayList, cf. {@link
     * FXCollections#observableArrayList(Collection)})
     */
    public static <C extends SimpleCard> ObservableList<C> optimalShuffle(List<C> deck) {
        List<C> list = new LinkedList<C>(deck);
        list = french(list, 2);
        list = american(list, 2);
        list = cut(list);
        list = french(list, 5);
        list = american(list, 1);
        list = cut(list);

        return FXCollections.observableArrayList(list);
    }
}