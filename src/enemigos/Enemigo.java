package enemigos;

public abstract class Enemigo {

    private String nombre;
    private int salud;
    private int ataque;
    private int defensa;
    private boolean alive;

    public void morirse(){
        System.out.println("El enemigo " + getNombre() + " ha muerto");
        setAlive(false);
    }

    public Enemigo(String nombre, int salud, int ataque, int defensa, boolean alive) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alive = alive;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
