package juego;

import juego.ReglaDanio;

public class Ataque {
    private String nombre;
    private int poder;
    private double precision;
    private ReglaDanio regla;

    public Ataque(String nombre, int poder, double precision, ReglaDanio regla) {
        this.nombre = nombre;
        this.poder = poder;
        this.precision = precision;
        this.regla = regla;
    }

    public String getNombre() { return nombre; }
    public int getPoder() { return poder; }
    public double getPrecision() { return precision; }
    public ReglaDanio getRegla() { return regla; }
}
