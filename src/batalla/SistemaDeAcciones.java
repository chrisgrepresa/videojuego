package batalla;
import enemigos.Enemigo;
import personajes.Guerrero;
import personajes.Personaje;
import java.util.Scanner;

public class SistemaDeAcciones {

    SistemaCombate sistemaCombate = new SistemaCombate();
    Scanner scanner = new Scanner(System.in);

    public void doCombatRound(Personaje personaje, Enemigo enemigo) {
        boolean inCombat = true;
        while (inCombat) {
            if (personaje instanceof Guerrero){
                warriorActions(personaje,enemigo,inCombat);
            }
            else {
                inCombat = genericActions(personaje, enemigo, inCombat);
            }
            //Comprobar si siguen vivos para ver si se sigue el combate
            inCombat = sistemaCombate.checkAlive(personaje, enemigo,inCombat);
        }
        System.out.println("Se acabó el combate");
    }

    private boolean genericActions(Personaje personaje, Enemigo enemigo, boolean inCombat) {
        System.out.println("¿Qué quieres hacer? a) Atacar | b) Huir");
        String eleccion = scanner.nextLine();
        if(eleccion.equalsIgnoreCase("a")){
            System.out.println("¡Que comience el combate!");
            sistemaCombate.realizarTurnoPersonaje(personaje, enemigo);
            sistemaCombate.realizarTurnoEnemigo(personaje, enemigo);
            //inCombat = checkAlive(personaje, enemigo, inCombat);
        } else if (eleccion.equalsIgnoreCase("b")) {
            inCombat = sistemaCombate.huir(personaje);
            // Cuando llegue a esta línea va a ver si huyó y asignar el valor de true o false
            // (lo que devuelve el método huir) a variable in Combat
            //Después de intentar huir: comprobación. Si aún inCombat = true, el enemigo ataca.
            if(inCombat == true){
                sistemaCombate.realizarTurnoEnemigo(personaje, enemigo);
            }
        }
        else {
            System.out.println("Respuesta incorrecta, escoge una opción A o B");
        }
        return inCombat;
    }


    public boolean warriorActions(Personaje personaje, Enemigo enemigo, boolean inCombat){
        System.out.println("¿Qué quieres hacer? a) Atacar | b) Huir | c) Grito de Guerra");
        String eleccion = scanner.nextLine();
        if(eleccion.equalsIgnoreCase("a")){
            System.out.println("¡Que comience el combate!");
            sistemaCombate.realizarTurnoPersonaje(personaje, enemigo);
            sistemaCombate.realizarTurnoEnemigo(personaje, enemigo);
            //inCombat = checkAlive(personaje, enemigo, inCombat);
        } else if (eleccion.equalsIgnoreCase("b")) {
            inCombat = sistemaCombate.huir(personaje);
            // Cuando llegue a esta línea va a ver si huyó y asignar el valor de true o false
            // (lo que devuelve el método huir) a variable in Combat
            //Después de intentar huir: comprobación. Si aún inCombat = true, el enemigo ataca.
            if(inCombat == true){
                sistemaCombate.realizarTurnoEnemigo(personaje, enemigo);
            }
        }
        else if(eleccion.equalsIgnoreCase("c")){
            inCombat = ((Guerrero)personaje).gritoDeGuerra(enemigo);
            if(inCombat == true){
                sistemaCombate.realizarTurnoEnemigo(personaje, enemigo);
            }
        }
        else {
            System.out.println("Respuesta incorrecta, escoge una opción A o B");
        }
        return inCombat;
    }

}
