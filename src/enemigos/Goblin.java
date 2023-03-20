package enemigos;

public class Goblin extends Enemigo{

    private int agilidad;
    public Goblin(String nombre, int salud, int ataque, int defensa) {
        super(nombre, salud, ataque, defensa);
    }

    @Override
    public void morirse(){}

    public void esquivar(){}
}
