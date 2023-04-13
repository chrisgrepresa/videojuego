package personajes;

import enemigos.Enemigo;

import java.util.Random;

public class Guerrero extends Personaje {

    private int armadura;

    public Guerrero(String nombre, int salud, int ataque, int defensa, boolean alive, int armadura) {
        super(nombre, salud, ataque, defensa, alive);

        this.armadura = Math.min(armadura, 10); //Esto es un método que escoge el método más pequeño de las dos opciones
        // Se usa para que si alguien pone un valor mayor a 10, pone 10 por defecto.
        // se puede hacer tambien con if(armadura >10){this.armadura=armadura || setArmadura(10)}
    }

    public boolean gritoDeGuerra(Enemigo enemigo){
        Random random = new Random();
        int probabilidadDeAcojone = random.nextInt(1,100);
        if(probabilidadDeAcojone <20){
            enemigo.huir();
            return false;
        }
        else{
            System.out.println("El enemigo no se acojona, se ríe de ti, pringaillo");
            return true;
        }
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    @Override
    public String toString() {
        return super.toString() + " armadura: " + getArmadura();
    }
}

