import batalla.SistemaCombate;
import batalla.SistemaDeAcciones;
import enemigos.Ogro;
import personajes.Guerrero;
import personajes.Picaro;

public class Main {
    public static void main(String[] args) {

        Guerrero guerrero = new Guerrero("Aragorn", 40,100,5,5,true,30);
        Ogro ogro = new Ogro("Onisan", 40, 10, 5,true,7);
        Picaro picaro = new Picaro("Pepe",4,5,6,7,true,2);

        SistemaDeAcciones sistemaDeAcciones = new SistemaDeAcciones();
        sistemaDeAcciones.doCombatRound(guerrero,ogro);


    }
}