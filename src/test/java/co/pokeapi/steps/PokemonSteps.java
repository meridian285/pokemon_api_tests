package co.pokeapi.steps;

import co.pokeapi.dataTests.Ability;
import co.pokeapi.dataTests.Root;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static co.pokeapi.config.EndPoints.LISTPOKEMONS;
import static co.pokeapi.config.EndPoints.POKEMON;
import static io.restassured.RestAssured.given;

/**
 * Класс для шагов для тестов
 */
public class PokemonSteps extends RestClient {

    @Step("Получаем  параметр Вес покемона")
    public int getWeightPokemon(String namePokemon) {
        return given()
                .when()
                .spec(getDefaultRequestSpec())
                .get(POKEMON+"/"+namePokemon)
                .then()
                .extract()
                .body()
                .as(Root.class).getWeight();
    }

    @Step("Получаем список способностей покемона")
    public List<Ability> getAbility(String namePokemon) {
        return given()
                .when()
                .spec(getDefaultRequestSpec())
                .get(POKEMON+"/"+namePokemon)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("abilities.ability", Ability.class);
    }

    @Step("Получаем список с полями name")
    public ValidatableResponse getListNameField(){
        return given()
                .when()
                .spec(getDefaultRequestSpec())
                .get(POKEMON+LISTPOKEMONS)
                .then();
    }

}
