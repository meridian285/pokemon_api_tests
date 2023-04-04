package co.pokeapi.dataTests;

import java.util.ArrayList;

public class Pokemon {
        private Integer weight;


    public Pokemon(Integer weight) {
        this.weight = weight;
    }

    public Pokemon(){

    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "weight=" + weight +
                '}';
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
