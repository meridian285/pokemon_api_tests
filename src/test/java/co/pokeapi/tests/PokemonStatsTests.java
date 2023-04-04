package co.pokeapi.tests;

import co.pokeapi.dataTests.Ability;
import co.pokeapi.dataTests.Pokemon;
import co.pokeapi.steps.PokemonSteps;
import co.pokeapi.steps.RestClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static co.pokeapi.dataTests.EndPoints.POKEMON;
import static io.restassured.RestAssured.given;

public class PokemonStatsTests extends RestClient {

    PokemonSteps pokemonSteps = new PokemonSteps();
    Integer weight;
    Response response;

    @Test
    @DisplayName("Сравнение веса двух покемонов")
    public void checkWeightPokemon(){
        Integer weightPokemon1;
        Integer weightPokemon2;
        List<Pokemon> pokemonList = pokemonSteps.getWeight("rattata")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("weight", Pokemon.class);

//        weightPokemon1 = response.path("weight");
//        response = pokemonSteps.getWeight("pidgeotto");
//        weightPokemon2 = response.path("weight");
//        Assertions.assertTrue(weightPokemon1 < weightPokemon2);
    }

    @Test
    @DisplayName("Проверка на наличие способности покемона 'run-away' ")
    public void checkAbility(){

//        pokemonSteps.getAbilities().assertThat()
//                        .statusCode(200)
//                                .body("abilities.ability.name", equalTo("run-away"));
        List<Ability> ability = given()
                .when()
                .spec(getDefaultRequestSpec())
                .get(POKEMON+"rattata")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("abilities.ability.name", Ability.class);
    int i = 1;
    }
}
