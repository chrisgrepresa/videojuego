package characterfactories;

import personajes.Guerrero;
import personajes.Mago;
import personajes.Personaje;
import personajes.Picaro;
import utils.NameUtils;

import java.util.Scanner;

public class CharacterFactory {
    public static Personaje createCharacter() {
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
        if (NameUtils.checkName(nameCharacter)) {
            personaje.setNombre(nameCharacter);
        }
        controlNumberOptionsCharacter(personaje, scanner);
        personaje = aditionalLimitedPointsCharacter(personaje, scanner, choosenCharacter);
        return personaje;
    }

    private static void controlNumberOptionsCharacter(Personaje personaje, Scanner scanner) {
        boolean answerOneLack = true;
        boolean answerTwoLack = true;
        boolean answerThreeLack = true;
        while (answerOneLack) {
            try {
                System.out.println("Elige el nivel de salud, del 1 al 100");
                String healthLevelCharacter = scanner.nextLine();
                int healthLevelCharacterInt = Integer.parseInt(healthLevelCharacter);
                personaje.setSalud(healthLevelCharacterInt);
                if (healthLevelCharacterInt >= 1 && healthLevelCharacterInt <= 100) {
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
                System.out.println("Elige el nivel de ataque, del 1 al 100");
                String attackLevelCharacter = scanner.nextLine();
                int attackLevelCharacterInt = Integer.parseInt(attackLevelCharacter);
                personaje.setAtaque(attackLevelCharacterInt);
                if (attackLevelCharacterInt >= 1 && attackLevelCharacterInt <= 100) {
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
                System.out.println("Elige el nivel de defensa, del 1 al 100");
                String defenseLevelCharacter = scanner.nextLine();
                int defenseLevelCharacterInt = Integer.parseInt(defenseLevelCharacter);
                personaje.setDefensa(defenseLevelCharacterInt);

                if (defenseLevelCharacterInt >= 1 && defenseLevelCharacterInt <= 100) {
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

}
