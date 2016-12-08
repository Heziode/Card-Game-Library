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
 * Classe abstraite de règle de jeu proposant des services spécifiques à des propriétés (d'où le fait qu'elle soit
 * abstraite et non une interface).
 */
public abstract class AbstractGameRules {

    /**
     * Nombre autorisé de main
     */
    private int numberOfHand;

    /**
     * Nombre de cartes maximum que peut avoir une main
     */
    private int numberOfCardByHand;

    /**
     * Constructeur logique
     *
     * @param numberOfHand       Nombre de mains qu'un joueur peut avoir
     * @param numberOfCardByHand Nombre de carte qu'une main peut obtenir, <b>-1</b> correspondant à infinie.
     */
    protected AbstractGameRules(int numberOfHand, int numberOfCardByHand) {
        this.numberOfHand = numberOfHand;
        this.numberOfCardByHand = numberOfCardByHand;
    }

    /**
     * Accesseur de numberOfHand<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return Retourne le nombre de main d'un joueur
     */
    public final int getNumberOfHand() {
        return numberOfHand;
    }

    /**
     * Mutateur de numberOfHand<br>
     * Est final pour empêcher la redéfinition.
     *
     * @param numberOfHand Nouvelle valeur de numberOfHand
     */
    public final void setNumberOfHand(int numberOfHand) {
        this.numberOfHand = numberOfHand;
    }

    /**
     * Accesseur de numberOfCardByHand<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return Retourne numberOfCardByHand
     */
    public final int getNumberOfCardByHand() {
        return numberOfCardByHand;
    }

    /**
     * Mutateur de numberOfCardByHand<br>
     * Est final pour empêcher la redéfinition.
     *
     * @param numberOfCardByHand Nouvelle valeur de numberOfCardByHand
     */
    public final void setNumberOfCardByHand(int numberOfCardByHand) {
        this.numberOfCardByHand = numberOfCardByHand;
    }
}
