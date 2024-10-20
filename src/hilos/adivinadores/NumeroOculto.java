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
import java.util.concurrent.atomic.AtomicBoolean;

class NumeroOculto {
    private final int numeroOculto;
    private final AtomicBoolean juegoTerminado = new AtomicBoolean(false);

    public NumeroOculto() {
        Random rand = new Random();
        this.numeroOculto = rand.nextInt(101);
        System.out.println("Número oculto generado: " + numeroOculto);
    }

    public synchronized int propuestaNumero(int num) {
        if (juegoTerminado.get()) {
            return -1;
        }
        if (num == numeroOculto) {
            juegoTerminado.set(true);
            return 1; 
        }
        return 0;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado.get();
    }
}
