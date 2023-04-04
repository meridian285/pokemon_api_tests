package co.pokeapi.steps;

import co.pokeapi.dataTests.Ability;
import co.pokeapi.dataTests.Pokemon;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static co.pokeapi.dataTests.EndPoints.POKEMON;
import static io.restassured.RestAssured.given;

public class PokemonSteps extends RestClient {

//    @Step("Получаем  параметр Вес")
//    public List<Pokemon> getWeight(String namePokemon) {
//        List<Pokemon> pokemon = given()
//                .when()
//                .spec(getDefaultRequestSpec())
//                .get(POKEMON + "namePokemon")
//                .then()
//                .extract()
//                .body()
//                .jsonPath()
//                .getList("abilities.ability", Pokemon.class);
//
//        return pokemon;
//    }

    @Step("Получаем список способностей покемона")
    public List<Ability> getAbility(String namePokemon) {
        List<Ability> ability = given()
                .when()
                .spec(getDefaultRequestSpec())
                .get(POKEMON + "namePokemon")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("abilities.ability", Ability.class);

        return ability;
    }
}
