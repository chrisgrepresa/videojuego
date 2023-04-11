package personajes;

import enemigos.Enemigo;

import java.util.Random;
import java.util.Scanner;

public class Mago extends Personaje {

    private int puntosDeMagia;

    public Mago(String nombre, int nivel, int salud, int ataque, int defensa, boolean alive, int puntosDeMagia) {
        super(nombre, nivel, salud, ataque, defensa, alive);
        this.puntosDeMagia = Math.min(puntosDeMagia, 10);
    }

    public int lanzarHechizo() {
        Random random = new Random();
        System.out.println("Puedes lanzar ataque");
        System.out.println("¿Qué quieres hacer? a) Relámpago | b) Bola de fuego");
        Scanner scanner = new Scanner(System.in);
        String eleccion = scanner.nextLine();

        if (eleccion.equalsIgnoreCase("a")) {

            if (puntosDeMagia >= 1) {
                int damageByCharacterDiceOne = random.nextInt(1, 10);
                int damageByCharacterDiceTwo = random.nextInt(1, 10);
                int damageThunderTotal = damageByCharacterDiceOne + damageByCharacterDiceTwo;
                System.out.println("El daño con este hechizo es de " + damageThunderTotal);
                setPuntosDeMagia(getPuntosDeMagia()-1);
                return damageThunderTotal;
            } else {
                System.out.println("Puntos de magia insuficientes, hace un ataque normal");
                return getAtaque() + random.nextInt(1, 10);
            }
        } else if (eleccion.equalsIgnoreCase("b")) {
            if (puntosDeMagia >= 2) {
                int damageByCharacterDiceOne = random.nextInt(1, 10);
                int damageByCharacterDiceTwo = random.nextInt(1, 10);
                int damageByCharacterDiceThree = random.nextInt(1, 10);
                int damageByCharacterDiceFour = random.nextInt(1, 10);
                int damageFireBallTotal = damageByCharacterDiceOne + damageByCharacterDiceTwo + damageByCharacterDiceThree + damageByCharacterDiceFour;
                System.out.println("El daño con este hechizo es de " + damageFireBallTotal);
                setPuntosDeMagia(getPuntosDeMagia()-2);
                return damageFireBallTotal;
            } else {
                System.out.println("Puntos de magia insuficientes, hace un ataque normal");
                return getAtaque() + random.nextInt(1, 10);
            }
        } else {
            System.out.println("Respuesta incorrecta, hace un ataque normal");
            return getAtaque() + random.nextInt(1, 10);
        }
    }


    public int getPuntosDeMagia() {
        return puntosDeMagia;
    }

    public void setPuntosDeMagia(int puntosDeMagia) {
        this.puntosDeMagia = puntosDeMagia;
    }
}
