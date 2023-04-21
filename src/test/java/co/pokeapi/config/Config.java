package co.pokeapi.config;

import io.restassured.RestAssured;

/**
 * Класс конфигурации содержит базовый URL
 */
public class Config {
    private final static String URL = "https://pokeapi.co/api/v2/";

    public static String getBaseUri() {
        RestAssured.baseURI = URL;
        return URL;
    }
}
