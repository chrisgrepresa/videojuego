package enemigos;

import java.util.Random;

public class Goblin extends Enemigo{

    private int agilidad;

    public Goblin(String nombre, int salud, int ataque, int defensa, boolean alive, int agilidad) {
        super(nombre, salud, ataque, defensa, alive);
        this.agilidad = Math.min (agilidad,50);
    }

    public boolean esquivar(){
        Random random = new Random();
        int dexterityPosibility = random.nextInt(1,100);
        if(dexterityPosibility <= getAgilidad()){
            System.out.println("El goblin esquiva el ataque");
            return true;
        }
        else {
            System.out.println("El goblín no esquiva el ataque y se lo come con patatas");
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
