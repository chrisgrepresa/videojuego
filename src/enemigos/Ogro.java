package enemigos;

import java.util.Random;

public class Ogro extends Enemigo{

    private int fuerza;

    public Ogro(String nombre, int salud, int ataque, int defensa, boolean alive, int fuerza) {
        super(nombre, salud, ataque, defensa, alive);
        this.fuerza =  Math.min(fuerza, 10);
    }

    public int aplastar(){
        Random random = new Random();
        int probabilityOfSmash = random.nextInt(1,100);
        if(probabilityOfSmash <=30) {
            int damageByEnemyDiceOne = random.nextInt(1, 10);
            int damageByEnemyDiceTwo = random.nextInt(1, 10);
            int damageByEnemyDiceThree = random.nextInt(1, 10);
            int damageByEnemyDiceFour = random.nextInt(1, 10);
            int totalDamage = damageByEnemyDiceOne + damageByEnemyDiceTwo + damageByEnemyDiceThree + damageByEnemyDiceFour;
            System.out.println("El ogro te aplasta, en el sentido de la palabra que más te guste");
            return getAtaque() + getFuerza() + totalDamage;
        }
        else {
            System.out.println("El aplaste no ha sido efectuado, gua gua");
            return 0;
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public String toString() {
        return super.toString() + " nivel de fuerza: " + getFuerza();
    }
}
