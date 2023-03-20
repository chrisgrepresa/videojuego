package enemigos;

public class Ogro extends Enemigo{

    private int fuerza;
    public Ogro(String nombre, int salud, int ataque, int defensa) {
        super(nombre, salud, ataque, defensa);
    }

    @Override
    public void morirse(){}

    public void aplastar(){
        //lo que va a hacer: ignorar armadura si la hay
    }
}
