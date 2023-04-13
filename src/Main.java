import batalla.SistemaCombate;
import batalla.SistemaDeAcciones;
import enemigos.Goblin;
import enemigos.Ogro;
import interfazusuario.InterfazUsuario;
import personajes.Guerrero;
import personajes.Mago;
import personajes.Picaro;

public class Main {
    public static void main(String[] args) {

        /*Guerrero guerrero = new Guerrero("Aragorn", 40,100,5,5,true,30);
        Ogro ogro = new Ogro("Onisan", 40, 10, 5,true,7);
        Picaro picaro = new Picaro("Pepe",4,100,6,7,true,10);
        Goblin goblin = new Goblin("Ñehehé", 40,8,6,true,25);
        Mago mago = new Mago("Jarri", 5,500,7,4,true,1);

        SistemaDeAcciones sistemaDeAcciones = new SistemaDeAcciones();
        sistemaDeAcciones.doCombatRound(mago,goblin);
        */

        InterfazUsuario interfazUsuario = new InterfazUsuario();
        interfazUsuario.startGame();


        // Simular unos cuantos combates y cambiar los mensajes que salgan para que sea mejor para el usuario.
        // Ogro ogro = new Ogro("Onisan", 40, 10, 5, true, 7);

        //todo: Arreglar creación del monstruo ---> HECHO
        // imprimir por pantalla el monstruo (toString) ---> HECHO
        // goblin le sale fuerza en lugar de agilidad, algo falla ---> HECHO
        // todo: quitar los niveles (cuidado que afecta a contructores. ---> HECHO
        // todo: que se pueda escoger letra o directamente escribir el tipo de personaje/enemigo---> HECHO

        // todo: Control de excepciones
        //  (numeros cuando letras, viceversa, espacio en numeros, signos en numeros)



    }
}