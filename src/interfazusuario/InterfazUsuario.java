package interfazusuario;

import batalla.SistemaDeAcciones;
import enemigos.Enemigo;
import enemigos.Goblin;
import enemigos.Ogro;
import personajes.Guerrero;
import personajes.Mago;
import personajes.Personaje;
import personajes.Picaro;

import java.util.Scanner;

public class InterfazUsuario {

    SistemaDeAcciones sistemaDeAcciones = new SistemaDeAcciones();

    public void startGame() {
        System.out.println("Bienvenido al juego. Tendrás que crear un héroe para luchar contra el monstruo. Primero creemos al héroe.");
        Personaje personaje = createCharacter();
        System.out.println("Ahora tendrás que crear un monstruo");
        //Enemigo enemigo = createMonster();
        System.out.println("¡Empieza el juego!");
        Ogro ogro = new Ogro("Shrek", 56, 6, 5, true, 9);
        sistemaDeAcciones.doCombatRound(personaje, ogro);
    }

    private Personaje createCharacter() {
        Personaje personaje = new Guerrero("Aragorn", 40, 100, 5, 5, true, 30);

        Scanner scanner = new Scanner(System.in);
        String choosenCharacter = selectCharacterType(scanner);
        personaje = selectOptionsCharacter(personaje, scanner, choosenCharacter);
        return personaje;
    }

    private static String selectCharacterType(Scanner scanner) {
        boolean faltaRespuesta = true;
        String choosenCharacter = null;

        while (faltaRespuesta == true) {
            System.out.println("¿Qué tipo de personaje quieres crear?");
            System.out.println("a) Guerrero");
            System.out.println("b) Pícaro");
            System.out.println("c) Mago");
            choosenCharacter = scanner.nextLine();
            if (choosenCharacter.equalsIgnoreCase("a") || choosenCharacter.equalsIgnoreCase("b")
                    || choosenCharacter.equalsIgnoreCase("c")) {
                System.out.printf("De acuerdo, has escogido: ");
                if (choosenCharacter.equalsIgnoreCase("a")) {
                    System.out.println("a) Guerrero");
                }
                if (choosenCharacter.equalsIgnoreCase("b")) {
                    System.out.println("b) Pícaro");
                }
                if (choosenCharacter.equalsIgnoreCase("c")) {
                    System.out.println("c) Mago");
                }
                System.out.println("Vamos a conocer un poco más a tu personaje.");
                faltaRespuesta = false;
            } else {
                System.out.println("Te has equivocado, repite");
            }
        }
        return choosenCharacter;
    }
    private static Personaje selectOptionsCharacter(Personaje personaje, Scanner scanner, String choosenCharacter) {
        System.out.println("Escribe el nombre de tu personaje");
        String nameCharacter = scanner.nextLine();
        controlNumberOptionsCharacter(scanner);
        return personaje;
    }

    private static void controlNumberOptionsCharacter(Scanner scanner) {
        boolean answerOneLack = true;
        boolean answerTwoLack = true;
        boolean answerThreeLack = true;
        while (answerOneLack) {
            System.out.println("Elige el nivel de salud, del 1 al 100");
            String healthLevelCharacter = scanner.nextLine();
            int healthLevelCharacterInt = Integer.parseInt(healthLevelCharacter);

            if (healthLevelCharacterInt > 1 && healthLevelCharacterInt < 100) {
                System.out.printf("Correcto.");
                answerOneLack = false;
            } else {
                System.out.println("Ese número no está entre el 1 y el 100");
            }
        }
        while (answerTwoLack) {
            System.out.println("Elige el nivel de ataque, del 1 al 100");
            String attackLevelCharacter = scanner.nextLine();
            int attackLevelCharacterInt = Integer.parseInt(attackLevelCharacter);

            if (attackLevelCharacterInt > 1 && attackLevelCharacterInt < 100) {
                System.out.printf("Correcto.");
                answerTwoLack = false;
            } else {
                System.out.println("Ese número no está entre el 1 y el 100");
            }
        }
        while (answerThreeLack) {
            System.out.println("Elige el nivel de defensa, del 1 al 100");
            String defenseLevelCharacter = scanner.nextLine();
            int defenseLevelCharacterInt = Integer.parseInt(defenseLevelCharacter);

            if (defenseLevelCharacterInt > 1 && defenseLevelCharacterInt < 100) {
                System.out.printf("Correcto.");
                answerThreeLack = false;
            } else {
                System.out.println("Ese número no está entre el 1 y el 100");
            }
        }
    }

    private static Personaje aditionalLimitedPoints(Personaje personaje, Scanner scanner, String choosenCharacter, String nameCharacter, String healthCharacter, String attackLevelCharacter, String defenseLevelCharacter) {
        if (choosenCharacter.equalsIgnoreCase("a")) {
            boolean faltanRespuestas = true;
            while (faltanRespuestas) {
                System.out.println("Eres un guerrero. Elige tu nivel de armadura, de 1 a 10.");
                String armorLevelCharacter = scanner.nextLine();
                if (Integer.parseInt(armorLevelCharacter) <= 10) {
                    System.out.println("La armadura es nivel " + armorLevelCharacter + " , estás preparado para luchar.");
                    faltanRespuestas = false;
                } else {
                    System.out.println("Hemos dicho hasta 10, no te flipes. Repite");
                }
                personaje = new Guerrero(nameCharacter, 0, Integer.parseInt(healthCharacter),
                        Integer.parseInt(attackLevelCharacter), Integer.parseInt(defenseLevelCharacter), true, Integer.parseInt(armorLevelCharacter));

            }
        } else if (choosenCharacter.equalsIgnoreCase("b")) {
            boolean faltanRespuestas = true;
            while (faltanRespuestas) {
                System.out.println("Eres un pícaro. Elige tu nivel de agilidad, de 1 a 50");
                String dexterityLevelCharacter = scanner.nextLine();
                if (Integer.parseInt(dexterityLevelCharacter) <= 50) {
                    System.out.println("La agilidad es nivel " + dexterityLevelCharacter + " , estás preparado para luchar.");
                    faltanRespuestas = false;
                } else {

                    System.out.println("Hemos dicho hasta 50, no te flipes. Repite");
                }
                personaje = new Picaro(nameCharacter, 0, Integer.parseInt(healthCharacter),
                        Integer.parseInt(attackLevelCharacter), Integer.parseInt(defenseLevelCharacter), true, Integer.parseInt(dexterityLevelCharacter));
            }

        } else if (choosenCharacter.equalsIgnoreCase("c")) {
            boolean faltanRespuestas = true;
            while (faltanRespuestas) {
                System.out.println("Eres un mago. Elige tu nivel de magia, de 1 a 10");
                String magicLevelCharacter = scanner.nextLine();
                if (Integer.parseInt((magicLevelCharacter)) <= 10) {
                    System.out.println("La magia es nivel " + magicLevelCharacter + " , estás preparado para luchar.");
                    faltanRespuestas = false;
                } else {
                    System.out.println("Hemos dicho hasta 10, no te flipes. Repite");
                }
                personaje = new Mago(nameCharacter, 0, Integer.parseInt(healthCharacter),
                        Integer.parseInt(attackLevelCharacter), Integer.parseInt(defenseLevelCharacter), true, Integer.parseInt(magicLevelCharacter));
            }
        }
        return personaje;
    }

    private Enemigo createMonster() {
        Enemigo enemigo = new Ogro("Shrek", 30, 8, 6, true, 9);

        Scanner scanner = new Scanner(System.in);
        String choosenEnemy = selectEnemyType(scanner);

        System.out.println("Escribe el nombre de tu enemigo");
        String nameEnemy = scanner.nextLine();
        System.out.println("Elige el nivel de salud de tu enemigo, de 1 a 100");
        String healthEnemy = scanner.nextLine();
        System.out.println("Elige el nivel de ataque de tu enemigo, del 1 al 100");
        String attackLevelEnemy = scanner.nextLine();
        System.out.println("Elige el nivel de defensa de tu enemigo, del 1 al 100");
        String defenseLevelEnemy = scanner.nextLine();
        if (choosenEnemy.equalsIgnoreCase("a")) {
            System.out.println("El enemigo es un ogro. Elige su nivel de fuerza, de 1 a 10.");
            String strengthLevelEnemy = scanner.nextLine();
            enemigo = new Ogro(nameEnemy, Integer.parseInt(healthEnemy), Integer.parseInt(attackLevelEnemy),
                    Integer.parseInt(defenseLevelEnemy), true, Integer.parseInt(strengthLevelEnemy));
        } else if (choosenEnemy.equalsIgnoreCase("b")) {
            System.out.println("El enemigo es un goblin. Elige su nivel de fuerza, de 1 a 10.");
            String dexterityLevelEnemy = scanner.nextLine();
            enemigo = new Goblin(nameEnemy, Integer.parseInt(healthEnemy),
                    Integer.parseInt(attackLevelEnemy), Integer.parseInt(defenseLevelEnemy), true, Integer.parseInt(dexterityLevelEnemy));
        }
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
            if (choosenEnemy.equalsIgnoreCase("a") || choosenEnemy.equalsIgnoreCase("b")
                    || choosenEnemy.equalsIgnoreCase("c")) {
                System.out.printf("De acuerdo, has escogido: ");
                if (choosenEnemy.equalsIgnoreCase("a")) {
                    System.out.println("a) Ogro");
                }
                if (choosenEnemy.equalsIgnoreCase("b")) {
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


}

