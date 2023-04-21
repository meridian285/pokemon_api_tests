package co.pokeapi.steps;

import co.pokeapi.config.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * Класс с методом возвращает преднастройки(спецификация) для тестов
 */

public abstract class RestClient {
    public RequestSpecification getDefaultRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(Config.getBaseUri())
                .setContentType(ContentType.JSON)
                .build()
                .filter(new AllureRestAssured());
    }
}
