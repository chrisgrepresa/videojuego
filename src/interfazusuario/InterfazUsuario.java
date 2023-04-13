package interfazusuario;

import batalla.SistemaDeAcciones;
import characterfactories.CharacterFactory;
import characterfactories.EnemyFactory;
import enemigos.Enemigo;
import enemigos.Goblin;
import enemigos.Ogro;
import personajes.Guerrero;
import personajes.Mago;
import personajes.Personaje;
import personajes.Picaro;
import utils.NameUtils;

import java.util.Scanner;

public class InterfazUsuario {
    CharacterFactory characterFactory = new CharacterFactory();
    EnemyFactory enemyFactory = new EnemyFactory();
    SistemaDeAcciones sistemaDeAcciones = new SistemaDeAcciones();

    public void startGame() {
        System.out.println("Bienvenido al juego. Tendrás que crear un héroe para luchar contra el monstruo. Primero creemos al héroe.");
        Personaje personaje = CharacterFactory.createCharacter();
        System.out.println(personaje);
        System.out.println("Ahora tendrás que crear un monstruo");
        Enemigo enemigo = EnemyFactory.createMonster();
        System.out.println(enemigo);
        System.out.println("¡Empieza el juego!");
        //Ogro ogro = new Ogro("Shrek", 56, 6, 5, true, 9);
        sistemaDeAcciones.doCombatRound(personaje, enemigo);
    }
}
