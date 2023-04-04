package personajes;

import enemigos.Enemigo;

import java.util.Random;
import java.util.Scanner;

public class Mago extends Personaje{

    private int puntosDeMagia;

    public Mago(String nombre, int nivel, int salud, int ataque, int defensa, boolean alive, int puntosDeMagia) {
        super(nombre, nivel, salud, ataque, defensa, alive);
        this.puntosDeMagia = Math.min (puntosDeMagia,10);
    }

    public boolean lanzarHechizo(Enemigo enemigo){

        if (puntosDeMagia > 0){
            System.out.println("Puedes lanzar ataque");
            System.out.println("¿Qué quieres hacer? a) Relámpago | b) Bola de fuego");
            Scanner scanner = new Scanner(System.in);
            String eleccion = scanner.nextLine();
            Random random = new Random();
            if(eleccion.equalsIgnoreCase("a")){
                int damageByCharacterDiceOne = random.nextInt(1, 10);
                int damageByCharacterDiceTwo = random.nextInt(1, 10);
                int damageThunderTotal = damageByCharacterDiceOne + damageByCharacterDiceTwo;
                System.out.println("El daño con este hechizo es de " + damageThunderTotal);
            }
            else if(eleccion.equalsIgnoreCase("b")){
                int damageByCharacterDiceOne = random.nextInt(1, 10);
                int damageByCharacterDiceTwo = random.nextInt(1, 10);
                int damageByCharacterDiceThree = random.nextInt(1, 10);
                int damageByCharacterDiceFour = random.nextInt(1, 10);
                int damageFireBallTotal = damageByCharacterDiceOne + damageByCharacterDiceTwo + damageByCharacterDiceThree + damageByCharacterDiceFour;
                System.out.println("El daño con este hechizo es de " + damageFireBallTotal);
            }
            else {
                System.out.println("Respuesta incorrecta, escoge una opción A o B");
            }
            return true;
        }
        else {
            System.out.println("No puedes");
            return false;
        }
    }

    public int getPuntosDeMagia() {
        return puntosDeMagia;
    }

    public void setPuntosDeMagia(int puntosDeMagia) {
        this.puntosDeMagia = puntosDeMagia;
    }
}
