
package hilos.adivinadores;

public class HilosAdivinadores {

    public static void main(String[] args) {
        NumeroOculto numeroOculto = new NumeroOculto();
        Thread[] adivinadores = new Thread[10];
        System.out.println("El número oculto es "+numeroOculto.getNumeroOculto());
        for (int i = 0; i < adivinadores.length; i++) {
            adivinadores[i] = new Thread(new Adivinador(numeroOculto, "Hilo-"+i + 1));
            adivinadores[i].start();
        }
        
        for (Thread adivinador : adivinadores) {
            try {
                adivinador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El juego ha terminado.");
    }
    
}
