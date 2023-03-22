package enemigos;

public class Goblin extends Enemigo{

    private int agilidad;

    public Goblin(String nombre, int salud, int ataque, int defensa, boolean alive, int agilidad) {
        super(nombre, salud, ataque, defensa, alive);
        this.agilidad = agilidad;
    }

    public void esquivar(){}
}
