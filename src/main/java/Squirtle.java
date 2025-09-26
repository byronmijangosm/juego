package juego.pokemon;

import juego.Ataque;
import java.util.Arrays;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super("Squirtle", 110, Arrays.asList(
                new Ataque("Placaje", 15, 0.95, (p, v) -> p),
                new Ataque("Pistola Agua", 20, 0.9, (p, v) -> p + 5)
        ));
    }
}
