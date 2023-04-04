import batalla.SistemaCombate;
import batalla.SistemaDeAcciones;
import enemigos.Goblin;
import enemigos.Ogro;
import personajes.Guerrero;
import personajes.Mago;
import personajes.Picaro;

public class Main {
    public static void main(String[] args) {

        Guerrero guerrero = new Guerrero("Aragorn", 40,100,5,5,true,30);
        Ogro ogro = new Ogro("Onisan", 40, 10, 5,true,7);
        Picaro picaro = new Picaro("Pepe",4,100,6,7,true,10);
        Goblin goblin = new Goblin("Ñehehé", 40,8,6,true,25);
        Mago mago = new Mago("Jarri", 5,50,7,4,true,50);

        SistemaDeAcciones sistemaDeAcciones = new SistemaDeAcciones();
        sistemaDeAcciones.doCombatRound(mago,goblin);


    }
}