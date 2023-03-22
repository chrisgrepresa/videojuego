import batalla.SistemaCombate;
import enemigos.Ogro;
import personajes.Guerrero;

public class Main {
    public static void main(String[] args) {

        Guerrero guerrero = new Guerrero("Aragorn", 40,100,5,5,true,7);
        Ogro ogro = new Ogro("Onisan", 40, 10, 5,true,7);

        SistemaCombate sistemaCombate = new SistemaCombate();
        sistemaCombate.comenzarBatalla(guerrero,ogro);

    }
}