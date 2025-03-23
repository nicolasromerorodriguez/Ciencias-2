/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolb;

/**
 *
 * @author nicol
 */
class ArbolB {
    private NodoArbolB raiz;
    private int t; // Grado mínimo

    public ArbolB(int t) {
        this.t = t;
        raiz = new NodoArbolB(t, true);
    }

    public NodoArbolB buscar(NodoArbolB x, int k) {
        int i = 0;
        while (i < x.n && k > x.clave[i]) {
            i++;
        }
        if (i < x.n && k == x.clave[i]) {
            return x;
        }
        if (x.hoja) {
            return null;
        }
        return buscar(x.hijo[i], k);
    }

    public void insertar(int k) {
        NodoArbolB r = raiz;
        if (r.n == (2 * t - 1)) { // Si la raíz está llena
            NodoArbolB s = new NodoArbolB(t, false);
            raiz = s;
            s.hijo[0] = r;
            dividirHijo(s, 0, r);
            insertarNoLleno(s, k);
        } else {
            insertarNoLleno(r, k);
        }
    }

    private void insertarNoLleno(NodoArbolB x, int k) {
        int i = x.n - 1;
        if (x.hoja) {
            while (i >= 0 && k < x.clave[i]) {
                x.clave[i + 1] = x.clave[i];
                i--;
            }
            x.clave[i + 1] = k;
            x.n++;
        } else {
            while (i >= 0 && k < x.clave[i]) {
                i--;
            }
            i++;
            if (x.hijo[i].n == (2 * t - 1)) {
                dividirHijo(x, i, x.hijo[i]);
                if (k > x.clave[i]) {
                    i++;
                }
            }
            insertarNoLleno(x.hijo[i], k);
        }
    }

    private void dividirHijo(NodoArbolB x, int i, NodoArbolB y) {
        NodoArbolB z = new NodoArbolB(t, y.hoja);
        z.n = t - 1;
        
        for (int j = 0; j < t - 1; j++) {
            z.clave[j] = y.clave[j + t];
        }
        if (!y.hoja) {
            for (int j = 0; j < t; j++) {
                z.hijo[j] = y.hijo[j + t];
            }
        }
        y.n = t - 1;
        
        for (int j = x.n; j > i; j--) {
            x.hijo[j + 1] = x.hijo[j];
        }
        x.hijo[i + 1] = z;
        
        for (int j = x.n - 1; j >= i; j--) {
            x.clave[j + 1] = x.clave[j];
        }
        x.clave[i] = y.clave[t - 1];
        x.n++;
    }

    public void recorrer() {
        recorrer(raiz);
    }

    private void recorrer(NodoArbolB x) {
        int i;
        for (i = 0; i < x.n; i++) {
            if (!x.hoja) {
                recorrer(x.hijo[i]);
            }
            System.out.print(x.clave[i] + " ");
        }
        if (!x.hoja) {
            recorrer(x.hijo[i]);
        }
    }
}