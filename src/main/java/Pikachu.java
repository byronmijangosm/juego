package juego.pokemon;

import juego.Ataque;
import java.util.Arrays;

public class Pikachu extends Pokemon {
    public Pikachu() {
        super("Pikachu", 90, Arrays.asList(
                new Ataque("Impactrueno", 18, 0.9, (p, v) -> p + 5),
                new Ataque("Ataque Rápido", 12, 0.95, (p, v) -> p)
        ));
    }
}
