package batalla;

import enemigos.Enemigo;
import enemigos.Goblin;
import enemigos.Ogro;
import personajes.Guerrero;
import personajes.Mago;
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
        int damageByCharacter = random.nextInt(1, 10);
        int defenseByEnemy = random.nextInt(1, 10);
        System.out.println("El héroe ataca");
        int resultadoPersonaje= 0; 
        resultadoPersonaje = calculateCharacterDamage(personaje, enemigo, damageByCharacter, defenseByEnemy);
        applyCharacterDamage(enemigo, resultadoPersonaje);
    }

    private static int calculateCharacterDamage(Personaje personaje, Enemigo enemigo, int damageByCharacter, int defenseByEnemy) {
        int resultadoPersonaje;
        if (enemigo instanceof Goblin) {
            if (((Goblin) enemigo).esquivar()) {
                resultadoPersonaje = 0;
            } else {
                resultadoPersonaje = (personaje.getAtaque() + damageByCharacter) - (enemigo.getDefensa() + defenseByEnemy);
            }
        } else {
            resultadoPersonaje = (personaje.getAtaque() + damageByCharacter) - (enemigo.getDefensa() + defenseByEnemy);
        }
        return resultadoPersonaje; 
    }

    private static void applyCharacterDamage(Enemigo enemigo, int resultadoPersonaje) {
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
                resultadoEnemigo = 0;
            } else {
                resultadoEnemigo = calculateAttackPointsEnemy(enemigo, damageByEnemy) - calculateDefensePointsCharacter(personaje, defenseByCharacter);
            }
        }
        else if(personaje instanceof Mago){
            System.out.println("Como el mago es debilucho, recibe " + (personaje.getDefensa() + defenseByCharacter) +
                    " pero le va a dañar 2 puntos más.");
            return (personaje.getDefensa() + defenseByCharacter -2);
        }
        else {
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

