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

import javafx.beans.property.BooleanProperty;

/**
 * Interface vide permettant de définir des classes qui l'implémente pour la généricité
 */
public abstract class AbstractCard {

    /**
     * Définit si la carte est visible ou non
     */
    protected BooleanProperty visible;

    /**
     * Accesseur observable de visible
     *
     * @return Retourne la visibilité de la carte
     */
    public abstract BooleanProperty getVisible();

    /**
     * Récupération de la visibilité de la carte
     *
     * @return Retourne true si la carte est visible, false sinon
     */
    public abstract boolean isVisible();

    /**
     * Modification de la visibilité d'une carte
     *
     * @param visible Nouvelle visibilité de la carte
     */
    public abstract void setVisible(boolean visible);

}
