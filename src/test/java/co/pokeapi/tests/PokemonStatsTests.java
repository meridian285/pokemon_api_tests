package co.pokeapi.tests;

import co.pokeapi.dataTests.Ability;
import co.pokeapi.dataTests.Result;
import co.pokeapi.steps.PokemonSteps;
import co.pokeapi.steps.RestClient;
import groovy.beans.ListenerList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.Matchers.*;

/**
 * Тестовый класс
 */

public class PokemonStatsTests {
    PokemonSteps pokemonSteps = new PokemonSteps();

    //этот тест можно было сделать более универсальным(параметризованным), но решил что этого достаточно
    @Test
    @DisplayName("Сравнение веса двух покемонов")
    public void checkWeightPokemon(){
        int weightPokemonOne = pokemonSteps.getWeightPokemon("rattata");
        int weightPokemonTwo = pokemonSteps.getWeightPokemon("pidgeotto");
        Assertions.assertTrue(weightPokemonOne < weightPokemonTwo,
                "Ожидалось что вес первого покемона меньше второго");
    }

    @Test
    @DisplayName("Проверка на наличие способности у покемона 'run-away'")
    public void checkAbility(){
        List<Ability> ability = pokemonSteps.getAbility("rattata");
        Assertions.assertTrue(ability.stream().anyMatch(x-> Objects.equals(x.getName(),"run-away")));
    }

    @Test
    @DisplayName("Проверка что у каждого покемона в списке есть name не пустое, запрос выдает заданное число покемонов")
    public void checkNamePokemon(){
        int limitPoke = 1000;
        pokemonSteps.getListPokemon(limitPoke)
                .statusCode(200)
                //проверка что поля name не пустые
                .body("results.name", not(hasValue(nullValue())));
    }

    @Test
    @DisplayName("Проверка что заданный лимит списка выдает нужное колличество покемонов")
    public void checkListPokemon(){
        int limitPoke = 1000;
        List<Result> listPokemon = pokemonSteps.getListPokemon(limitPoke)
                .statusCode(200)
                .extract().jsonPath().getList("results", Result.class);
        //проверяем колличество элементов полученного списка с заданным числом
        Assertions.assertEquals((long) listPokemon.size(), limitPoke,
                "Ожидалось совпадение колличество элементов полученного списка с заданным числом");
    }
}
