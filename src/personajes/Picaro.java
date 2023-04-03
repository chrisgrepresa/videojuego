package personajes;

import java.util.Random;

public class Picaro extends Personaje {

    private int agilidad;

    public Picaro(String nombre, int nivel, int salud, int ataque, int defensa, boolean alive, int agilidad) {
        super(nombre, nivel, salud, ataque, defensa, alive);
        this.agilidad = Math.min(agilidad, 50);
    }

    public boolean esquivar() {
        Random random = new Random();
        int dexterityPosibility = random.nextInt(1,100);
        if(dexterityPosibility <= getAgilidad()){
            System.out.println("El pícaro esquiva el ataque");
            return true;
        }
        else {
            System.out.println("No lo has esquivado, te ha dado en toda la jeta.");
            return false;
        }
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }
}