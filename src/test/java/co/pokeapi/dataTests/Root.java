package co.pokeapi.dataTests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
