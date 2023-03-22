package batalla;

import enemigos.Enemigo;
import personajes.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaCombate {

    Random random = new Random();

    public void atacar(Personaje personaje, Enemigo enemigo) {

        boolean inCombat = true;

        while (inCombat) {
            int damageByCharacter = random.nextInt(1, 10);
            int defenseByEnemy = random.nextInt(1, 10);
            System.out.println("El héroe ataca");
            int resultadoPersonaje = (personaje.getAtaque() + damageByCharacter) - (enemigo.getDefensa() - defenseByEnemy);
            if (resultadoPersonaje > 0) {
                System.out.println("El heroe hace este daño: " + resultadoPersonaje);
                enemigo.setSalud(enemigo.getSalud() - resultadoPersonaje);
                if(enemigo.getSalud()<=0){
                    enemigo.morirse();
                }
            } else {
                System.out.println("El héroe no ha hecho daño");
            }
            if (enemigo.getSalud() > 0) {
                int damageByEnemy = random.nextInt(1, 10);
                int defenseByCharacter = random.nextInt(1, 10);
                System.out.println("El enemigo ataca");
                int resultadoEnemigo = (enemigo.getAtaque() + damageByEnemy) - (personaje.getDefensa() - defenseByCharacter);
                if (resultadoEnemigo > 0) {
                    System.out.println("El enemigo hace este daño: " + resultadoEnemigo);
                    personaje.setSalud(personaje.getSalud() - resultadoEnemigo);
                    if(personaje.getSalud()<=0){
                        personaje.morirse();
                    }
                } else {
                    System.out.println("El enemigo no ha hecho daño");
                }
            }
            if (!personaje.isAlive() || !enemigo.isAlive()) {
                inCombat = false;
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

