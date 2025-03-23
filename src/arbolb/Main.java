/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolb;

/**
 *
 * @author nicol
 */
public class Main {

   
        public static void main(String[] args) {
        ArbolB tree = new ArbolB(2); // Grado mínimo t = 2
        
        int[] keys = {10, 20, 5, 6, 12, 30, 7, 17};
        for (int k : keys) {
            tree.insertar(k);
        }
        
        tree.recorrer(); // Salida ordenada
    }
}
