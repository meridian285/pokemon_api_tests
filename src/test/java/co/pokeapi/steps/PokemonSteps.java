package co.pokeapi.steps;

import co.pokeapi.dataTests.Root;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static co.pokeapi.config.EndPoints.*;
import static io.restassured.RestAssured.given;

/**
 * Класс для шагов для тестов
 */
public class PokemonSteps extends RestClient {
    Response response;
    @Step("Шаг для тестов с endpoint pokemon/")
    public Root getSameFields(String endpoint, String namePokemon){
        return  given()
                .when()
                .spec(getDefaultRequestSpec())
                .get(endpoint, namePokemon)
                .then()
                .extract()
                .body()
                .as(Root.class);
    }

    @Step("Получаем список с полями name")
    public ValidatableResponse getListPokemon(int id){
        return given()
                .when()
                .spec(getDefaultRequestSpec())
                .get(POKEMON_LIMIT,id)
                .then();
    }
}
