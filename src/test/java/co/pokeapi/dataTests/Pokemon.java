package co.pokeapi.dataTests;

import java.util.ArrayList;

public class Pokemon {

    ArrayList<Object> abilities = new ArrayList<Object>();
    private Integer weight;


    public ArrayList<Object> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Object> abilities) {
        this.abilities = abilities;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
