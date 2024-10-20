/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilos.adivinadores;
/**
 *
 * @author Usuario
 */
public class HilosAdivinadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NumeroOculto numeroOculto = new NumeroOculto();
        Adivinador[] hilos = new Adivinador[10];
        
        for (int i = 0; i < 10; i++) {
            hilos[i] = new Adivinador(numeroOculto, "Adivinador-" + (i + 1));
            hilos[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El juego ha terminado.");
    }
    
}
