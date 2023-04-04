package co.pokeapi.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static co.pokeapi.dataTests.EndPoints.POKEMON;
import static io.restassured.RestAssured.given;

public class PokemonSteps extends RestClient {

    @Step("Получаем  параметр Вес")
    public Response getWeight(String namePokemon){
        Response response = given()
                .spec(getDefaultRequestSpec())
                .get(POKEMON+namePokemon);
        return response;
    }

    @Step("Получаем список способностей покемона")
    public ValidatableResponse getAbilities(){
        return given()
                .spec(getDefaultRequestSpec())
                .get(POKEMON+"rattata")
                .then();
    }
}
