package co.pokeapi.dataTests;

/**
 * Класс способностей покемонов, endpoint - POKEMON?limit=100000&offset=0
 */

public class Result {
    public String name;
    public String url;

    public Result() {
    }

    public Result(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
