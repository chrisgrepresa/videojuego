package batalla;

import enemigos.Enemigo;
import personajes.Personaje;

import java.util.Random;
import java.util.Scanner;

public class SistemaCombate {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public void realizarAccionPersonaje(Personaje personaje, Enemigo enemigo) {
        boolean inCombat = true;
        while (inCombat) {
            System.out.println("¿Qué quieres hacer? a) Atacar | b) Huir");
            String eleccion = scanner.nextLine();
            if(eleccion.equalsIgnoreCase("a")){
                System.out.println("¡Que comience el combate!");
                realizarTurnoPersonaje(personaje,enemigo);
                realizarTurnoEnemigo(personaje, enemigo);
                //inCombat = checkAlive(personaje, enemigo, inCombat);
            } else if (eleccion.equalsIgnoreCase("b")) {
               inCombat = huir(personaje);
               // Cuando llegue a esta línea va a ver si huyó y asignar el valor de true o false
                // (lo que devuelve el método huir) a variable in Combat
                //Después de intentar huir: comprobación. Si aún inCombat = true, el enemigo ataca.
                if(inCombat == true){
                    realizarTurnoEnemigo(personaje,enemigo);
                }
            }
            else {
                System.out.println("Respuesta incorrecta, escoge una opción A o B");
            }
            //Comprobar si siguen vivos para ver si se sigue el combate
            inCombat = checkAlive(personaje, enemigo,inCombat);
        }
        System.out.println("Se acabó el combate");
    }

    /*public void comenzarBatalla(Personaje personaje, Enemigo enemigo) {
        boolean inCombat = true;
        while (inCombat) {
            realizarTurnoPersonaje(personaje,enemigo);
            realizarTurnoEnemigo(personaje, enemigo);
            inCombat = checkAlive(personaje, enemigo, inCombat);
        }
        System.out.println("Se acabó el combate");
    }*/


    public boolean huir(Personaje personaje) {
        int diceScape = random.nextInt(1, 10);
        if (diceScape >= 8) {
            System.out.println("Escapas del combate");
            return false;
        }
        else {
            System.out.println("No has podido huir, a seguir peleando");
            return true;
        }

    }

    public void realizarTurnoPersonaje(Personaje personaje,Enemigo enemigo){
        int damageByCharacter = random.nextInt(1, 10);//Esto tb se puede refactorizar de 31-35: calcular daño
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
    }

    private void realizarTurnoEnemigo(Personaje personaje, Enemigo enemigo) {
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
    }
    private static boolean checkAlive(Personaje personaje, Enemigo enemigo, boolean inCombat) {
        if (!personaje.isAlive() || !enemigo.isAlive()) {
            inCombat = false;
        }
        return inCombat;
    }

}

