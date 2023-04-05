package co.pokeapi.tests;

import co.pokeapi.dataTests.Ability;
import co.pokeapi.dataTests.Root;
import co.pokeapi.steps.PokemonSteps;
import co.pokeapi.steps.RestClient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static co.pokeapi.config.EndPoints.POKEMON;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

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
}
