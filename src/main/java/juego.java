package juego;

import juego.excepciones.*;
import juego.pokemon.*;
import java.util.*;

public class juego {
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("¡Bienvenido al combate Pokémon!");
        System.out.print("Ingresa tu nombre: ");
        String nombreJugador = entrada.nextLine();

        List<Pokemon> disponibles = Arrays.asList(
                new Charmander(),
                new Squirtle(),
                new Bulbasaur(),
                new Pikachu()
        );


        Pokemon jugador = elegirPokemon(disponibles);
        // Selección CPU (random distinto)
        Pokemon cpu = elegirPokemonCPU(disponibles, jugador);

        System.out.println(nombreJugador + " eligió a " + jugador.getNombre());
        System.out.println("La CPU eligió a " + cpu.getNombre());


        while (!jugador.estaDebilitado() && !cpu.estaDebilitado()) {
            turnoJugador(jugador, cpu);
            if (!cpu.estaDebilitado()) {
                turnoCPU(cpu, jugador);
            }
            System.out.println(jugador.getNombre() + " HP: " + jugador.getVidaActual());
            System.out.println(cpu.getNombre() + " HP: " + cpu.getVidaActual());
        }

        if (jugador.estaDebilitado() && cpu.estaDebilitado()) {
            System.out.println("¡Empate!");
        } else if (cpu.estaDebilitado()) {
            System.out.println("¡Ganaste!");
        } else {
            System.out.println("Perdiste...");
        }
    }

    private static Pokemon elegirPokemon(List<Pokemon> disponibles) {
        while (true) {
            System.out.println("Elige tu Pokémon:");
            for (int i = 0; i < disponibles.size(); i++) {
                System.out.println((i+1) + ". " + disponibles.get(i).getNombre());
            }
            try {
                int opcion = Integer.parseInt(entrada.nextLine());
                if (opcion < 1 || opcion > disponibles.size()) {
                    throw new EleccionInvalidaException("Opción fuera de rango.");
                }
                return disponibles.get(opcion - 1);
            } catch (NumberFormatException | EleccionInvalidaException e) {
                System.out.println("Entrada inválida: " + e.getMessage());
            }
        }
    }

    private static Pokemon elegirPokemonCPU(List<Pokemon> disponibles, Pokemon jugador) {
        Random rand = new Random();
        Pokemon elegido;
        do {
            elegido = disponibles.get(rand.nextInt(disponibles.size()));
        } while (elegido.getClass().equals(jugador.getClass()));
        return elegido;
    }

    private static void turnoJugador(Pokemon jugador, Pokemon enemigo) {
        System.out.println("Elige un ataque:");
        List<Ataque> ataques = jugador.getAtaques();
        for (int i = 0; i < ataques.size(); i++) {
            System.out.println((i+1) + ". " + ataques.get(i).getNombre());
        }
        try {
            int opcion = Integer.parseInt(entrada.nextLine());
            if (opcion < 1 || opcion > ataques.size()) {
                throw new EleccionInvalidaException("Ataque inválido.");
            }
            ejecutarAtaque(jugador, enemigo, ataques.get(opcion - 1));
        } catch (NumberFormatException | EleccionInvalidaException | AtaqueFallidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void turnoCPU(Pokemon cpu, Pokemon enemigo) {
        Random rand = new Random();
        Ataque ataque = cpu.getAtaques().get(rand.nextInt(cpu.getAtaques().size()));
        try {
            ejecutarAtaque(cpu, enemigo, ataque);
        } catch (AtaqueFallidoException e) {
            System.out.println("El ataque de la CPU falló: " + e.getMessage());
        }
    }

    private static void ejecutarAtaque(Pokemon atacante, Pokemon objetivo, Ataque ataque)
            throws AtaqueFallidoException {
        if (Math.random() > ataque.getPrecision()) {
            throw new AtaqueFallidoException(atacante.getNombre() + " falló su ataque " + ataque.getNombre());
        }
        int danio = ataque.getRegla().calcularDanio(ataque.getPoder(), objetivo.getVidaActual());
        objetivo.recibirDanio(danio);
        System.out.println(atacante.getNombre() + " usó " + ataque.getNombre() + " e hizo " + danio + " de daño.");
    }
}
