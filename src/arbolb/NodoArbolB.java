/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolb;

/**
 *
 * @author nicol
 */
class NodoArbolB {
    int t; // Grado mínimo
    int n; // Número de claves
    int[] clave;
    NodoArbolB[] hijo;
    boolean hoja;

    public NodoArbolB(int t, boolean leaf) {
        this.t = t;
        this.hoja = leaf;
        this.clave = new int[2 * t - 1];
        this.hijo = new NodoArbolB[2 * t];
        this.n = 0;
    }
}

