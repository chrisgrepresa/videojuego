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
        System.out.println(personaje);
        System.out.println("Ahora tendrás que crear un monstruo");
        Enemigo enemigo = createMonster();
        System.out.println(enemigo);
        System.out.println("¡Empieza el juego!");
        //Ogro ogro = new Ogro("Shrek", 56, 6, 5, true, 9);
        sistemaDeAcciones.doCombatRound(personaje, enemigo);
    }

    private Personaje createCharacter() {
        Personaje personaje = new Guerrero("Aragorn", 100, 5, 5, true, 30);

        Scanner scanner = new Scanner(System.in);
        String choosenCharacter = selectCharacterType(scanner);
        personaje = selectOptionsCharacter(personaje, scanner, choosenCharacter);
        return personaje;
    }

    private static String selectCharacterType(Scanner scanner) {
        boolean faltaRespuesta = true;
        String choosenCharacter = null;

        while (faltaRespuesta) {
            System.out.println("¿Qué tipo de personaje quieres crear?");
            System.out.println("a) Guerrero");
            System.out.println("b) Pícaro");
            System.out.println("c) Mago");
            choosenCharacter = scanner.nextLine();
            if (choosenCharacter.equalsIgnoreCase("a") || choosenCharacter.equalsIgnoreCase("b")
                    || choosenCharacter.equalsIgnoreCase("c") || choosenCharacter.equalsIgnoreCase("guerrero")
            || choosenCharacter.equalsIgnoreCase("picaro") || choosenCharacter.equalsIgnoreCase("pícaro")
                    || choosenCharacter.equalsIgnoreCase("mago")) {
                System.out.printf("De acuerdo, has escogido: ");
                if (choosenCharacter.equalsIgnoreCase("a") || choosenCharacter.equalsIgnoreCase("guerrero")) {
                    System.out.println("a) Guerrero");
                }
                if (choosenCharacter.equalsIgnoreCase("b") || choosenCharacter.equalsIgnoreCase("pícaro")
                 || choosenCharacter.equalsIgnoreCase("picaro")) {
                    System.out.println("b) Pícaro");
                }
                if (choosenCharacter.equalsIgnoreCase("c") || choosenCharacter.equalsIgnoreCase("mago")) {
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
        personaje.setNombre(nameCharacter);
        controlNumberOptionsCharacter(personaje, scanner);
        personaje = aditionalLimitedPointsCharacter(personaje, scanner, choosenCharacter);
        return personaje;
    }

    private static void controlNumberOptionsCharacter(Personaje personaje, Scanner scanner) {
        boolean answerOneLack = true;
        boolean answerTwoLack = true;
        boolean answerThreeLack = true;
        while (answerOneLack) {
            System.out.println("Elige el nivel de salud, del 1 al 100");
            String healthLevelCharacter = scanner.nextLine();
            int healthLevelCharacterInt = Integer.parseInt(healthLevelCharacter);
            personaje.setSalud(healthLevelCharacterInt);

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
            personaje.setAtaque(attackLevelCharacterInt);

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
            personaje.setDefensa(defenseLevelCharacterInt);

            if (defenseLevelCharacterInt > 1 && defenseLevelCharacterInt < 100) {
                System.out.printf("Correcto.");
                answerThreeLack = false;
            } else {
                System.out.println("Ese número no está entre el 1 y el 100");
            }
        }
    }

    private static Personaje aditionalLimitedPointsCharacter(Personaje personaje, Scanner scanner, String choosenCharacter) {
        if (choosenCharacter.equalsIgnoreCase("a") || choosenCharacter.equalsIgnoreCase("guerrero")) {
            boolean faltanRespuestas = true;
            while (faltanRespuestas) {
                System.out.println("Eres un guerrero. Elige tu nivel de armadura, de 1 a 10.");
                String armorLevelCharacter = scanner.nextLine();
                if (Integer.parseInt(armorLevelCharacter) >= 1 && Integer.parseInt(armorLevelCharacter) <= 10) {
                    System.out.println("La armadura es nivel " + armorLevelCharacter + " , estás preparado para luchar.");
                    faltanRespuestas = false;
                } else {
                    System.out.println("Hemos dicho del 1 al 10, no te flipes. Repite");
                }
                personaje = new Guerrero(personaje.getNombre(), personaje.getSalud(),
                        personaje.getAtaque(), personaje.getDefensa(), true, Integer.parseInt(armorLevelCharacter));
            }
        } else if (choosenCharacter.equalsIgnoreCase("b") || choosenCharacter.equalsIgnoreCase("picaro")
                || choosenCharacter.equalsIgnoreCase("pícaro")) {
            boolean faltanRespuestas = true;
            while (faltanRespuestas) {
                System.out.println("Eres un pícaro. Elige tu nivel de agilidad, de 1 a 50");
                String dexterityLevelCharacter = scanner.nextLine();
                if (Integer.parseInt(dexterityLevelCharacter) >= 1 && Integer.parseInt(dexterityLevelCharacter) <= 50) {
                    System.out.println("La agilidad es nivel " + dexterityLevelCharacter + " , estás preparado para luchar.");
                    faltanRespuestas = false;
                } else {

                    System.out.println("Hemos dicho del 1 al 50, no te flipes. Repite");
                }
                personaje = new Picaro(personaje.getNombre(), personaje.getSalud(),
                        personaje.getAtaque(), personaje.getDefensa(), true, Integer.parseInt(dexterityLevelCharacter));
            }

        } else if (choosenCharacter.equalsIgnoreCase("c") || choosenCharacter.equalsIgnoreCase("mago")) {
            boolean faltanRespuestas = true;
            while (faltanRespuestas) {
                System.out.println("Eres un mago. Elige tu nivel de magia, de 1 a 10");
                String magicLevelCharacter = scanner.nextLine();
                if (Integer.parseInt((magicLevelCharacter)) >= 1 && Integer.parseInt((magicLevelCharacter)) <= 10) {
                    System.out.println("La magia es nivel " + magicLevelCharacter + " , estás preparado para luchar.");
                    faltanRespuestas = false;
                } else {
                    System.out.println("Hemos dicho del 1 al 10, no te flipes. Repite");
                }
                personaje = new Mago(personaje.getNombre(), personaje.getSalud(),
                        personaje.getAtaque(), personaje.getDefensa(), true, Integer.parseInt(magicLevelCharacter));
            }
        }
        return personaje;
    }

    private Enemigo createMonster() {
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
        enemigo.setNombre(nameEnemy);
        controlNumberOptionsEnemy(enemigo, scanner);
        enemigo = additionalPointsEnemy(enemigo, scanner, choosenEnemy);
        return enemigo;
    }

    private static void controlNumberOptionsEnemy(Enemigo enemigo, Scanner scanner) {
        boolean answerOneLack = true;
        boolean answerTwoLack = true;
        boolean answerThreeLack = true;
        while (answerOneLack) {
            System.out.println("Elige el nivel de salud de tu enemigo, de 1 a 100");
            String healthEnemy = scanner.nextLine();
            int healthEnemyInt = Integer.parseInt(healthEnemy);
            enemigo.setSalud(healthEnemyInt);

            if (healthEnemyInt > 1 && healthEnemyInt < 100) {
                System.out.printf("Correcto.");
                answerOneLack = false;
            } else {
                System.out.println("Ese número no está entre el 1 y el 100");
            }
        }
        while (answerTwoLack) {
            System.out.println("Elige el nivel de ataque de tu enemigo, del 1 al 100");
            String attackLevelEnemy = scanner.nextLine();
            int attackEnemyInt = Integer.parseInt(attackLevelEnemy);
            enemigo.setAtaque(attackEnemyInt);

            if (attackEnemyInt > 1 && attackEnemyInt < 100) {
                System.out.printf("Correcto.");
                answerTwoLack = false;
            } else {
                System.out.println("Ese número no está entre el 1 y el 100");
            }
        }
        while (answerThreeLack) {
            System.out.println("Elige el nivel de defensa de tu enemigo, del 1 al 100");
            String defenseLevelEnemy = scanner.nextLine();
            int defenseEnemyInt = Integer.parseInt(defenseLevelEnemy);
            enemigo.setAtaque(defenseEnemyInt);

            if (defenseEnemyInt > 1 && defenseEnemyInt < 100) {
                System.out.printf("Correcto.");
                answerThreeLack = false;
            } else {
                System.out.println("Ese número no está entre el 1 y el 100");
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
        } else if (choosenEnemy.equalsIgnoreCase("b")  || choosenEnemy.equalsIgnoreCase("goblin")) {
            boolean faltanRespuestas = true;
            while (faltanRespuestas) {
                System.out.println("El enemigo es un goblin. Elige su nivel de agilidad, de 1 a 10.");
                String dexterityLevelEnemy = scanner.nextLine();
                if (Integer.parseInt(dexterityLevelEnemy) >= 1 && Integer.parseInt(dexterityLevelEnemy) <= 10) {
                    System.out.println("La agilidad es nivel " + dexterityLevelEnemy + " , estás preparado para luchar.");
                    faltanRespuestas = false;
                } else {
                    System.out.println("Hemos dicho del 1 al 10, no te flipes. Repite");
                }
                enemigo = new Goblin(enemigo.getNombre(), enemigo.getSalud(), enemigo.getAtaque(),
                        enemigo.getDefensa(), true, Integer.parseInt(dexterityLevelEnemy));
            }
        }
        return enemigo;
    }

}


