package personajes;

public abstract class Personaje {

    private String nombre;
    private int nivel;
    private int salud;
    private int ataque;
    private int defensa;

    public Personaje(String nombre, int nivel, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public abstract void morirse();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}
