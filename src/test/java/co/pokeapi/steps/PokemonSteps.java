package co.pokeapi.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static co.pokeapi.dataTests.EndPoints.POKEMON;
import static io.restassured.RestAssured.given;

public class PokemonSteps extends RestClient {

    @Step("Получаем  параметр Вес")
    public ValidatableResponse getWeight(){
        return given()
                .spec(getDefaultRequestSpec())
                .log().all()
                .get(POKEMON)
                .then();
    }
}
