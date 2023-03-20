package personajes;

public class Guerrero extends Personaje {

    private int armadura;

    public Guerrero(String nombre, int nivel, int salud, int ataque, int defensa, int armadura) {
        super(nombre, nivel, salud, ataque, defensa);
        this.armadura = armadura;
    }

    @Override
    public void morirse() {
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

