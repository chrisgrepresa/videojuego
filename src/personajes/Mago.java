package personajes;

public class Mago extends Personaje{

    private int puntosDeMagia;

    public Mago(String nombre, int nivel, int salud, int ataque, int defensa, boolean alive, int puntosDeMagia) {
        super(nombre, nivel, salud, ataque, defensa, alive);
        this.puntosDeMagia = puntosDeMagia;
    }

    public void lanzarHechizo(){
    }

    public int getPuntosDeMagia() {
        return puntosDeMagia;
    }

    public void setPuntosDeMagia(int puntosDeMagia) {
        this.puntosDeMagia = puntosDeMagia;
    }
}
