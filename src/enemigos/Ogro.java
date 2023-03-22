package enemigos;

public class Ogro extends Enemigo{

    private int fuerza;

    public Ogro(String nombre, int salud, int ataque, int defensa, boolean alive, int fuerza) {
        super(nombre, salud, ataque, defensa, alive);
        this.fuerza = fuerza;
    }

    public void aplastar(){
        //lo que va a hacer: ignorar armadura si la hay
    }
}
