package co.pokeapi.steps;

import co.pokeapi.dataTests.Pokemon;
import co.pokeapi.steps.RestClient;
import io.qameta.allure.Step;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ValidatableResponse;

import static co.pokeapi.dataTests.EndPoints.POKEMON;
import static io.restassured.RestAssured.given;

public class PokemonSteps extends RestClient {

    @Step("Получаем  параметр Вес")
    public ValidatableResponse getWeight(){
        return given()
                .spec(getDefaultRequestSpec())
                .get(POKEMON)
                .then();
    }
}
