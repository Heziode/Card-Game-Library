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

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Classe qui gère le déplacement dans l'image (le sprite) qui contient toutes les cartes
 */
public final class SpriteCard {

    /**
     * Largeur d'une carte<br>
     * N'est pas final pour laisser libre à l'utilisateur de définir son sprite de cartes
     */
    public static double width = 250;

    /**
     * Hauteur d'une carte<br>
     * N'est pas final pour laisser libre à l'utilisateur de définir son sprite de cartes
     */
    public static double height = 363;

    /**
     * Régle la taille de l'image<br>
     * N'est pas final pour laisser libre à l'utilisateur de définir son sprite de cartes
     */
    public static int fixWidth = 100;

    /**
     * Numéro de ligne (en partant de 0) où se trouve l'image du dos de la carte.<br>
     * N'est pas final pour laisser libre à l'utilisateur de définir son sprite de cartes
     */
    public static int lineOfBack = 4;

    /**
     * Sprite contenant l'ensemble des cartes du jeu.<br>
     * N'est pas final pour laisser libre à l'utilisateur de définir son sprite de cartes
     */
    public static Image image = new Image("/ressources/images/decks_sprite.png");

    /**
     * Constructeur privée pour empêcher l'instanciation
     */
    private SpriteCard() {
    }

    /**
     * Récupère l'image correspondant au dos des cartes. Suppose qu'elle est située
     * sur la première colonne de la dernière ligne.
     *
     * @return Retourne l'image de dos d'une carte
     */
    public static ImageView getBackCard() {
        ImageView iv3 = new ImageView();
        iv3.setImage(image);

        double y = lineOfBack * height;

        return getCard(0, y);
    }

    /**
     * Récupère une carte contenue dans un sprite contenant toutes les cartes
     *
     * @param x Décalage du sélecteur de carte en x
     * @param y Décalage du sélecteur de carte en y
     * @return Retourne une portion d'image correspondant à la carte demandée
     */
    public static ImageView getCard(double x, double y) {
        ImageView imageCard = new ImageView();
        imageCard.setImage(image);

        Rectangle2D viewportRect = new Rectangle2D(x, y, width, height);
        imageCard.setViewport(viewportRect); // Sélectionne la partie de l'image que l'on souhaite obtenir

        imageCard.setFitWidth(fixWidth); // Réduit la taille de l'image
        imageCard.setPreserveRatio(true); // Préserve le ratio largeur hauteur lors du redimensionnement de l'image
        imageCard.setSmooth(true); // « lisse », utile dans le cas d'un redimensionnement uniquement
        imageCard.setCache(true); // Mets en cache l'image (optimisation)

        return imageCard;
    }
}
