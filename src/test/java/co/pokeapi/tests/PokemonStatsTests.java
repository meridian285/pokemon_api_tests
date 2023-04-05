package co.pokeapi.tests;

import co.pokeapi.dataTests.Ability;
import co.pokeapi.steps.PokemonSteps;
import co.pokeapi.steps.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.Matchers.*;

/**
 * Тестовый класс
 */

public class PokemonStatsTests extends RestClient {

    PokemonSteps pokemonSteps = new PokemonSteps();

    @Test
    @DisplayName("Сравнение веса двух покемонов")
    public void checkWeightPokemon(){
        int weightPokemonOne = pokemonSteps.getWeightPokemon("rattata");
        int weightPokemonTwo = pokemonSteps.getWeightPokemon("pidgeotto");
        Assertions.assertTrue(weightPokemonOne < weightPokemonTwo);
    }

    @Test
    @DisplayName("Проверка на наличие способности у покемона 'run-away' ")
    public void checkAbility(){
        List<Ability> ability = pokemonSteps.getAbility("rattata");
        Assertions.assertTrue(ability.stream().anyMatch(x-> Objects.equals(x.getName(),"run-away")));
    }

    @Test
    @DisplayName("Проверка что у каждого покемона в списке есть name не пустое")
    public void checkNamePokemon(){
        pokemonSteps.getListNameField()
                .statusCode(200)
                .body("results.name", not(hasValue(nullValue())));
    }
}
