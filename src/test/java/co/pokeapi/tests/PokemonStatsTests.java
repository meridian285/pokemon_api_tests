package co.pokeapi.tests;

import co.pokeapi.dataTests.Ability;
import co.pokeapi.dataTests.Pokemon;
import co.pokeapi.steps.PokemonSteps;
import co.pokeapi.steps.RestClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static co.pokeapi.dataTests.EndPoints.POKEMON;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class PokemonStatsTests extends RestClient {

    PokemonSteps pokemonSteps = new PokemonSteps();
    Integer weight;
    Response response;

    @Test
    @DisplayName("Сравнение веса двух покемонов")
    public void checkWeightPokemon(){
        Pokemon pokemon = new Pokemon();
        List<Pokemon> pokemonWeight = given()
                .when()
                .spec(getDefaultRequestSpec())
                .get(POKEMON+"rattata")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList(".", Pokemon.class);

        System.out.println(pokemonWeight);
    }

    @Test
    @DisplayName("Проверка на наличие способности покемона 'run-away' ")
    public void checkAbility(){
        List<Ability> ability =
        pokemonSteps.getAbility("rattata");
        Assertions.assertTrue(ability.stream().anyMatch(x-> Objects.equals(x.getName(),"run-away")));

    }
}
