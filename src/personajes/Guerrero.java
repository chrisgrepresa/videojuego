package personajes;

public class Guerrero extends Personaje {

    private int armadura;

    public Guerrero(String nombre, int nivel, int salud, int ataque, int defensa, boolean alive, int armadura) {
        super(nombre, nivel, salud, ataque, defensa, alive);
        this.armadura = armadura;
    }

    private void gritoDeGuerra(){
        
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
}

