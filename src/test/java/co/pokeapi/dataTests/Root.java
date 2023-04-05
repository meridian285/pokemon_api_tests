package co.pokeapi.dataTests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Корневой класс для endpoint POKEMON/"имя покемона"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Integer weight;

    public Root(){
    }

    public Root(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }
}
