package hilos.adivinadores;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
import java.util.Random;

class Adivinador extends Thread {
    private final NumeroOculto numeroOculto;
    public Adivinador(NumeroOculto numeroOculto, String name) {
        super(name);
        this.numeroOculto = numeroOculto;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (!numeroOculto.isJuegoTerminado()) {
            int intento = rand.nextInt(101);
            System.out.println(getName() + " propone: " + intento);

            int resultado = numeroOculto.propuestaNumero(intento);
            if (resultado == 1) {
                System.out.println(getName() + " ha adivinado el numero correcto!");
                break; // Termina el hilo porque adivinó
            } else if (resultado == -1) {
                System.out.println(getName() + " se detiene porque el juego ha terminado.");
                break; // Termina el hilo porque otro hilo ya adivinó
            }
        }
    }
}
