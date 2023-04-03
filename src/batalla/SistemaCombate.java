package batalla;

import enemigos.Enemigo;
import enemigos.Ogro;
import personajes.Guerrero;
import personajes.Personaje;
import personajes.Picaro;

import java.util.Random;
import java.util.Scanner;

public class SistemaCombate {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);



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
        } else {
            System.out.println("No has podido huir, a seguir peleando");
            return true;
        }

    }

    public void realizarTurnoPersonaje(Personaje personaje, Enemigo enemigo) {
        int damageByCharacter = random.nextInt(1, 10);//Esto tb se puede refactorizar de 31-35: calcular daño
        int defenseByEnemy = random.nextInt(1, 10);
        System.out.println("El héroe ataca");
        int resultadoPersonaje = (personaje.getAtaque() + damageByCharacter) - (enemigo.getDefensa() + defenseByEnemy);
        if (resultadoPersonaje > 0) {
            System.out.println("El heroe hace este daño: " + resultadoPersonaje);
            enemigo.setSalud(enemigo.getSalud() - resultadoPersonaje);
            if (enemigo.getSalud() <= 0) {
                enemigo.morirse();
            }
        } else {
            System.out.println("El héroe no ha hecho daño");
        }
    }

    public void realizarTurnoEnemigo(Personaje personaje, Enemigo enemigo) {
        if (enemigo.getSalud() > 0) {
            int damageByEnemy = random.nextInt(1, 10);
            int defenseByCharacter = random.nextInt(1, 10);
            System.out.println("El enemigo ataca");
            int resultadoEnemigo = 0;
            resultadoEnemigo = calculateEnemyDamage(personaje, enemigo, damageByEnemy, defenseByCharacter, resultadoEnemigo);
            applyEnemyDamage(personaje, resultadoEnemigo);

        }
    }

    private static void applyEnemyDamage(Personaje personaje, int resultadoEnemigo) {
        if (resultadoEnemigo > 0) {
            System.out.println("El enemigo hace este daño: " + resultadoEnemigo);
            personaje.setSalud(personaje.getSalud() - resultadoEnemigo);
            if (personaje.getSalud() <= 0) {
                personaje.morirse();
            }
        } else {
            System.out.println("El enemigo no ha hecho daño");
        }
    }

    private static int calculateEnemyDamage(Personaje personaje, Enemigo enemigo, int damageByEnemy, int defenseByCharacter, int resultadoEnemigo) {
        if (personaje instanceof Picaro) {
            if (((Picaro) personaje).esquivar()) {
                //esquiva
            } else {
                resultadoEnemigo = calculateAttackPointsEnemy(enemigo, damageByEnemy) - calculateDefensePointsCharacter(personaje, defenseByCharacter);
            }
        } else {
            resultadoEnemigo = calculateAttackPointsEnemy(enemigo, damageByEnemy) - calculateDefensePointsCharacter(personaje, defenseByCharacter);
        }
        return resultadoEnemigo;
    }

    private static int calculateDefensePointsCharacter(Personaje personaje, int defenseByCharacter) {
        if(personaje instanceof Guerrero){
            return (personaje.getDefensa() + defenseByCharacter + ((Guerrero) personaje).getArmadura());
        }
        else {
            return personaje.getDefensa() + defenseByCharacter;
        }
    }

    private static int calculateAttackPointsEnemy(Enemigo enemigo, int damageByEnemy) {
        if(enemigo instanceof Ogro){
            Random random = new Random();
            int probabilidadAtaqueNormalOAplastar = random.nextInt(1,100);
            if(probabilidadAtaqueNormalOAplastar <= 50){
                return enemigo.getAtaque() + ((Ogro) enemigo).getFuerza() + damageByEnemy;
            }
            else{
                return ((Ogro)enemigo).aplastar();
            }
        }
        else {
            return enemigo.getAtaque() + damageByEnemy;
        }
    }

    public static boolean checkAlive(Personaje personaje, Enemigo enemigo, boolean inCombat) {
        if (!personaje.isAlive() || !enemigo.isAlive()) {
            inCombat = false;
        }
        return inCombat;
    }

}

