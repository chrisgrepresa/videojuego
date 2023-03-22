import batalla.SistemaCombate;
import enemigos.Ogro;
import personajes.Guerrero;
import personajes.Personaje;

public class Main {
    public static void main(String[] args) {

        Guerrero guerrero = new Guerrero("Aragorn", 40,100,5,5,true,7);
        Ogro ogro = new Ogro("Onisan", 40, 10, 5,true,7);

        SistemaCombate sistemaCombate = new SistemaCombate();
        sistemaCombate.atacar(guerrero,ogro);

    }
}