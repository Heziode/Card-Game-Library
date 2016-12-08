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

package cardgamebase.model;

/**
 * Définis les règles d'un simple jeu
 */
public class SimpleGameRules extends AbstractGameRules {

    /**
     * Valeur d'un valet
     */
    public static final int CARD_VALUE_JACK = 11;

    /**
     * Valeur d'une reine
     */
    public static final int CARD_VALUE_QUEEN = 12;

    /**
     * Valeur d'un roi
     */
    public static final int CARD_VALUE_KING = 13;

    /**
     * Constructeur par defaut.<br>
     * Appel {@link #SimpleGameRules(int, int)} paramétré par 1 et -1 afin de définir un comportement par défaut qui
     * est : un joueur peut avoir qu'une main de taille infinie.
     */
    public SimpleGameRules() {
        this(1, -1);
    }

    /**
     * Constructeur logique.<br>
     * Appel {@link #SimpleGameRules(int, int)}. Définis une taille de main infinie.
     *
     * @param numberOfHand Nombre de mains qu'un joueur peut avoir
     */
    public SimpleGameRules(int numberOfHand) {
        this(numberOfHand, -1);
    }

    /**
     * Constructeur logique
     *
     * @param numberOfHand       Nombre de mains qu'un joueur peut avoir
     * @param numberOfCardByHand Nombre de carte qu'une main peut obtenir, <b>-1</b> correspondant à infinie.
     */
    public SimpleGameRules(int numberOfHand, int numberOfCardByHand) {
        super(numberOfHand, numberOfCardByHand);
    }
}
