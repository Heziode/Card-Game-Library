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

/**
 * Service pour obtenir les coordonnées lignes colonnes d'une carte dans un sprite
 */
public interface ViewBySprite<C extends AbstractCard> {

    /**
     * Récupère la coordonnée colonne de la carte
     *
     * @param card Carte dont on souhaite obtenir la coordonée colonne
     * @return Retourne la coordonnée colonne de la carte
     */
    double getColumn(C card);

    /**
     * Récupère la coordonnée ligne de la carte
     *
     * @param card Carte dont on souhaite obtenir la coordonée ligne
     * @return Retourne la coordonnée ligne de la carte
     */
    double getLine(C card);
}
