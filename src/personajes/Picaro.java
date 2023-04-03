package personajes;

public class Picaro extends Personaje {

    private int agilidad;

    public Picaro(String nombre, int nivel, int salud, int ataque, int defensa, boolean alive, int agilidad) {
        super(nombre, nivel, salud, ataque, defensa, alive);
        this.agilidad = Math.min(agilidad, 50);
    }

    public void esquivar() {
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }
}