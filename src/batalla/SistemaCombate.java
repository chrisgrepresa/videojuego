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

        boolean combateTerminado = true;
        boolean personajeAtaca = false;
        boolean enemigoAtaca = false;


        while (!combateTerminado) {
            int damageByCharacter = random.nextInt(1, 10);
            int defenseByEnemy = random.nextInt(1, 10);
            int resultadoPersonaje = (personaje.getAtaque() + damageByCharacter) - (enemigo.getDefensa() - defenseByEnemy);
            if (resultadoPersonaje > 0) {
                enemigo.setSalud(enemigo.getSalud() - resultadoPersonaje);
            }
            if (enemigo.getSalud() > 0) {
                int damageByEnemy = random.nextInt(1, 10);
                int defenseByCharacter = random.nextInt(1, 10);
                int resultadoEnemigo = (enemigo.getAtaque() + damageByEnemy) - (personaje.getDefensa() - defenseByCharacter);
                if (resultadoEnemigo > 0) {
                    personaje.setSalud(personaje.getSalud() - resultadoEnemigo);

                }
            }
            if (personaje.getSalud() <= 0 || enemigo.getSalud() <= 0) {
                combateTerminado = true;
            }
        }
        System.out.println("Se acabó el combate");


    }

    public void huir(Personaje personaje) {
        int diceScape = random.nextInt(1, 10);
        if (diceScape >= 8) {
            System.out.println("Escapas del combate");
        } else {
            System.out.println("¡Que comience el combate!");
        }

    }
}

