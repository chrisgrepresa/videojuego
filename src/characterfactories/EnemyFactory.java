package characterfactories;

import enemigos.Enemigo;
import enemigos.Goblin;
import enemigos.Ogro;
import utils.NameUtils;

import java.util.Scanner;

public class EnemyFactory {
    public static Enemigo createMonster() {
        Enemigo enemigo = new Ogro("Shrek", 30, 8, 6, true, 9);

        Scanner scanner = new Scanner(System.in);
        String choosenEnemy = selectEnemyType(scanner);
        enemigo = selectOptionsEnemy(enemigo, scanner, choosenEnemy);
        return enemigo;
    }

    private static String selectEnemyType(Scanner scanner) {
        boolean faltaRespuesta = true;
        String choosenEnemy = null;

        while (faltaRespuesta == true) {
            System.out.println("¿Qué tipo de personaje quieres crear?");
            System.out.println("a) Ogro");
            System.out.println("b) Goblin");
            choosenEnemy = scanner.nextLine();
            if (choosenEnemy.equalsIgnoreCase("a") || choosenEnemy.equalsIgnoreCase("b") ||
                    choosenEnemy.equalsIgnoreCase("ogro") || choosenEnemy.equalsIgnoreCase("goblin")) {
                System.out.printf("De acuerdo, has escogido: ");
                if (choosenEnemy.equalsIgnoreCase("a") || choosenEnemy.equalsIgnoreCase("ogro")) {
                    System.out.println("a) Ogro");
                }
                if (choosenEnemy.equalsIgnoreCase("b") || choosenEnemy.equalsIgnoreCase("goblin")) {
                    System.out.println("b) Goblin");
                }
                System.out.println("Vamos a conocer un poco más al enemigo.");
                faltaRespuesta = false;
            } else {
                System.out.println("Te has equivocado, repite");
            }
        }
        return choosenEnemy;
    }


    private static Enemigo selectOptionsEnemy(Enemigo enemigo, Scanner scanner, String choosenEnemy) {
        System.out.println("Escribe el nombre de tu enemigo");
        String nameEnemy = scanner.nextLine();
        if (NameUtils.checkName(nameEnemy)) {
            enemigo.setNombre(nameEnemy);
        }
        controlNumberOptionsEnemy(enemigo, scanner);
        enemigo = additionalPointsEnemy(enemigo, scanner, choosenEnemy);
        return enemigo;
    }

    private static void controlNumberOptionsEnemy(Enemigo enemigo, Scanner scanner) {
        boolean answerOneLack = true;
        boolean answerTwoLack = true;
        boolean answerThreeLack = true;
        while (answerOneLack) {
            try {
                System.out.println("Elige el nivel de salud de tu enemigo, de 1 a 100");
                String healthEnemy = scanner.nextLine();
                int healthEnemyInt = Integer.parseInt(healthEnemy);
                enemigo.setSalud(healthEnemyInt);

                if (healthEnemyInt >= 1 && healthEnemyInt <= 100) {
                    System.out.printf("Correcto.");
                    answerOneLack = false;
                } else {
                    System.out.println("Ese número no está entre el 1 y el 100");
                }
            } catch (Exception e) {
                System.out.println("Incorrecto, hazlo otra vez.");
            }
        }
        while (answerTwoLack) {
            try {
                System.out.println("Elige el nivel de ataque de tu enemigo, del 1 al 100");
                String attackLevelEnemy = scanner.nextLine();
                int attackEnemyInt = Integer.parseInt(attackLevelEnemy);
                enemigo.setAtaque(attackEnemyInt);

                if (attackEnemyInt >= 1 && attackEnemyInt <= 100) {
                    System.out.printf("Correcto.");
                    answerTwoLack = false;
                } else {
                    System.out.println("Ese número no está entre el 1 y el 100");
                }
            } catch (Exception e) {
                System.out.println("Incorrecto, hazlo otra vez.");
            }
        }
        while (answerThreeLack) {
            try {
                System.out.println("Elige el nivel de defensa de tu enemigo, del 1 al 100");
                String defenseLevelEnemy = scanner.nextLine();
                int defenseEnemyInt = Integer.parseInt(defenseLevelEnemy);
                enemigo.setAtaque(defenseEnemyInt);

                if (defenseEnemyInt >= 1 && defenseEnemyInt <= 100) {
                    System.out.printf("Correcto.");
                    answerThreeLack = false;
                } else {
                    System.out.println("Ese número no está entre el 1 y el 100");
                }
            } catch (Exception e) {
                System.out.println("Incorrecto, hazlo otra vez.");
            }
        }
    }

    private static Enemigo additionalPointsEnemy(Enemigo enemigo, Scanner scanner, String choosenEnemy) {
        if (choosenEnemy.equalsIgnoreCase("a") || choosenEnemy.equalsIgnoreCase("ogro")) {
            boolean faltanRespuestas = true;
            while (faltanRespuestas) {
                System.out.println("El enemigo es un ogro. Elige su nivel de fuerza, de 1 a 10.");
                String strengthLevelEnemy = scanner.nextLine();
                if (Integer.parseInt(strengthLevelEnemy) >= 1 && Integer.parseInt(strengthLevelEnemy) <= 10) {
                    System.out.println("La fuerza es nivel " + strengthLevelEnemy + " , estás preparado para luchar.");
                    faltanRespuestas = false;
                } else {
                    System.out.println("Hemos dicho del 1 al 10, no te flipes. Repite");
                }
                enemigo = new Ogro(enemigo.getNombre(), enemigo.getSalud(), enemigo.getAtaque(),
                        enemigo.getDefensa(), true, Integer.parseInt(strengthLevelEnemy));
            }
        } else if (choosenEnemy.equalsIgnoreCase("b") || choosenEnemy.equalsIgnoreCase("goblin")) {
            boolean faltanRespuestas = true;
            while (faltanRespuestas) {
                System.out.println("El enemigo es un goblin. Elige su nivel de agilidad, de 1 a 50.");
                String dexterityLevelEnemy = scanner.nextLine();
                if (Integer.parseInt(dexterityLevelEnemy) >= 1 && Integer.parseInt(dexterityLevelEnemy) <= 50) {
                    System.out.println("La agilidad es nivel " + dexterityLevelEnemy + " , estás preparado para luchar.");
                    faltanRespuestas = false;
                } else {
                    System.out.println("Hemos dicho del 1 al 50, no te flipes. Repite");
                }
                enemigo = new Goblin(enemigo.getNombre(), enemigo.getSalud(), enemigo.getAtaque(),
                        enemigo.getDefensa(), true, Integer.parseInt(dexterityLevelEnemy));
            }
        }
        return enemigo;
    }

}
