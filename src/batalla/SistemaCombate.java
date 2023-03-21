package batalla;

import enemigos.Enemigo;
import personajes.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaCombate {

    List<Personaje> personaje = new ArrayList<>();
    List<Enemigo> enemigo = new ArrayList<>();
    Random random = new Random();


    public void atacar(Personaje personaje, Enemigo enemigo) {

        boolean faltanAtaques = true;
        boolean personajeAtaca = false;
        boolean enemigoAtaca = false;

        while (faltanAtaques == true) {
            if (personajeAtaca == false) {
                int tiradaUno = random.nextInt(1, 10);
                int resultadoUno = (personaje.getAtaque() + tiradaUno) - (enemigo.getDefensa() - tiradaUno);
                if (resultadoUno > 0) {
                    enemigo.setSalud(enemigo.getSalud() - resultadoUno);
                }
                personajeAtaca = true;
            }

            if (enemigoAtaca == false) {
                int tiradaDos = random.nextInt(1, 10);
                int resultadoDos = (enemigo.getAtaque() + tiradaDos) - (personaje.getDefensa() - tiradaDos);
                if (resultadoDos > 0) {
                    personaje.setSalud(personaje.getSalud() - resultadoDos);

                }
                enemigoAtaca = true;
            }

            if (personajeAtaca == true && enemigoAtaca == true) {
                faltanAtaques = false;
            } //creo que aquí no hace falta else
        }
        System.out.println("Se acabó el combate");
    }

    public void huir(Personaje personaje){
        int tiradaTres = random.nextInt(1, 10);
        if(tiradaTres>=8){
            System.out.println("Escapas del combate");
        }
        else {
            System.out.println("¡Que comience el combate!");
        }
    }
}

