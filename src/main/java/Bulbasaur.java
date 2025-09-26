package juego.pokemon;

import juego.Ataque;
import java.util.Arrays;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super("Bulbasaur", 105, Arrays.asList(
                new Ataque("Placaje", 15, 0.95, (p, v) -> p),
                new Ataque("Látigo Cepa", 20, 0.9, (p, v) -> p + 5)
        ));
    }
}
