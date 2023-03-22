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
                int damageOne = random.nextInt(1, 10);
                int resultadoUno = (personaje.getAtaque() + damageOne) - (enemigo.getDefensa() - damageOne);
                if (resultadoUno > 0) {
                    enemigo.setSalud(enemigo.getSalud() - resultadoUno);
                }
                personajeAtaca = true;
            }

            if (enemigoAtaca == false) {
                int damageTwo = random.nextInt(1, 10);
                int resultadoDos = (enemigo.getAtaque() + damageTwo) - (personaje.getDefensa() - damageTwo);
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
        int diceScape = random.nextInt(1, 10);
        if(diceScape>=8){
            System.out.println("Escapas del combate");
        }
        else {
            System.out.println("¡Que comience el combate!");
        }
    }
}

