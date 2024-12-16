package hilos.adivinadores;

import java.util.Random;

public class Adivinador extends Thread{
    private NumeroOculto numeroOculto;
    private String nombre;

    public Adivinador(NumeroOculto numeroOculto, String nombre) {
        this.numeroOculto = numeroOculto;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        Random rand = new Random();
        
        while (true) {//Evita que se muestra más el mensaje de que se proponga un número
            try {
                Thread.sleep(rand.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int numeroPropuesto = rand.nextInt(101);
            int resultado = numeroOculto.propuestaNumero(numeroPropuesto);
            if (resultado == 0) {
            System.out.println(this.nombre + " propone el número: " + numeroPropuesto);
            }
            
            if (resultado == 1) {
                System.out.println(this.nombre + " adivinó el número: " + numeroPropuesto);
                break;
            } else if (resultado == -1) {
                System.out.println(this.nombre + " se detiene porque otro hilo ya adivinó el número.");
                break;
            }
        }
    }
}

