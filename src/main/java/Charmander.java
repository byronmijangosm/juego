package juego.pokemon;

import juego.Ataque;
import java.util.Arrays;

public class Charmander extends Pokemon {
    public Charmander() {
        super("Charmander", 100, Arrays.asList(
                new Ataque("Arañazo", 15, 0.95, (p, v) -> p),
                new Ataque("Ascuas", 20, 0.85, (p, v) -> p + 5)
        ));
    }
}
