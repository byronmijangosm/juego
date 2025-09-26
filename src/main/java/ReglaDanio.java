package juego;

@FunctionalInterface
public interface ReglaDanio {
    int calcularDanio(int poderBase, int vidaActual);
}
