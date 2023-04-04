package co.pokeapi.tests;

import co.pokeapi.steps.PokemonSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PokemonStatsTests {

    PokemonSteps pokemonSteps = new PokemonSteps();
    Integer weight;

    @Test
    @DisplayName("Проверка веса покемона")
    public void checkWeightPokemon(){
        pokemonSteps.getWeight()
                .statusCode(200)
                .extract()
                .body("weight", );
    }

}
