package juego.pokemon;

import juego.Ataque;
import java.util.List;

public abstract class Pokemon {
    protected String nombre;
    protected int vidaMaxima;
    protected int vidaActual;
    protected List<Ataque> ataques;

    public Pokemon(String nombre, int vidaMaxima, List<Ataque> ataques) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.ataques = ataques;
    }

    public String getNombre() { return nombre; }
    public int getVidaActual() { return vidaActual; }
    public int getVidaMaxima() { return vidaMaxima; }
    public List<Ataque> getAtaques() { return ataques; }

    public void recibirDanio(int danio) {
        this.vidaActual = Math.max(0, this.vidaActual - danio);
    }

    public boolean estaDebilitado() {
        return vidaActual <= 0;
    }
}

