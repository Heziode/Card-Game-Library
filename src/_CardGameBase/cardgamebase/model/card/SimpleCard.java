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
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Définition d'une simple carte
 */
public class SimpleCard extends AbstractCard {

    /**
     * Couleur de la carte
     */
    private Color color;

    /**
     * Valeur de la carte
     */
    private int value;

    /**
     * Constructeur d'une carte. Ici par défaut la carte est visible
     *
     * @param color Couleur de la carte
     * @param value Valeur de la carte
     */
    public SimpleCard(Color color, int value) {
        this.color = color;
        this.value = value;
        this.visible = new SimpleBooleanProperty(true);
    }

    /**
     * Constructeur d'une carte devant posséder une visibilité précise
     *
     * @param color   Couleur de la carte
     * @param value   Valeur de la carte
     * @param visible Visibilité de la carte
     */
    public SimpleCard(Color color, int value, boolean visible) {
        this(color, value);
        this.visible.setValue(visible);
    }

    /**
     * Vérifie si la carte est un as<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return Retourne vrai si la carte est un as, false sinon
     */
    public final boolean isAS() {
        return this.value == 1;
    }

    /**
     * Récupération de la couleur de la carte<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return Couleur de la carte
     */
    public final Color getColor() {
        return color;
    }

    /**
     * Modification de la couleur de la carte<br>
     * Est final pour empêcher la redéfinition.
     *
     * @param color Nouvelle couleur de la carte
     */
    public final void setColor(Color color) {
        this.color = color;
    }

    /**
     * Récupération de la valeur de la carte<br>
     * Est final pour empêcher la redéfinition.
     *
     * @return Retourne la valeur de la carte
     */
    public final int getValue() {
        return value;
    }

    /**
     * Modofication de la valeur de la carte<br>
     * Est final pour empêcher la redéfinition.
     *
     * @param value Nouvelle valeur de la carte
     */
    public final void setValue(int value) {
        this.value = value;
    }

    @Override
    public final BooleanProperty getVisible() {
        return visible;
    }

    @Override
    public final boolean isVisible() {
        return visible.getValue();
    }

    @Override
    public final void setVisible(boolean visible) {
        this.visible.setValue(visible);
    }
}