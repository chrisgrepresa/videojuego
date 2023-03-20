package personajes;

public class Picaro extends Personaje {

    private int agilidad;

    public Picaro(String nombre, int nivel, int salud, int ataque, int defensa, int agilidad) {
        super(nombre, nivel, salud, ataque, defensa);
        this.agilidad = agilidad;
    }

    @Override
    public void morirse() {
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