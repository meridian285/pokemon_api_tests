package co.pokeapi.tests;

import co.pokeapi.dataTests.Root;
import co.pokeapi.steps.PokemonSteps;
import co.pokeapi.steps.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static co.pokeapi.config.EndPoints.*;
import static org.hamcrest.Matchers.*;

/**
 * Тестовый класс
 */
//Тесты сделаны так, чтобы легко было переделать их в параметризованные, добавив аннотацию
public class PokemonTests extends RestClient {
    PokemonSteps pokemonSteps = new PokemonSteps();

    @Test
    @DisplayName("Сравнение веса двух покемонов")
    public void checkUniversalStep(){
        String firstPokemon = "rattata";
        String secondPokemon = "pidgeotto";
        int weightPokemonOne = pokemonSteps.getSameFields(POKEMON_NAME,firstPokemon).getWeight();
        int weightPokemonTwo = pokemonSteps.getSameFields(POKEMON_NAME,secondPokemon).getWeight();
        Assertions.assertTrue(weightPokemonOne < weightPokemonTwo,
                "Ожидалось что вес первого покемона меньше второго");
    }

    @Test
    @DisplayName("Сравнение способностей покемонов")
    public void checkPokemonAbility() {
        String abilityPokemonOne = "rattata";
        String abilityPokemonTwo = "pidgeotto";
        String ability = "run-away";
        Assertions.assertNotEquals(pokemonSteps.getSameFields(POKEMON_NAME, abilityPokemonOne).getAbilities()
                        .stream().anyMatch(x -> x.getAbility().getName().contains(ability)),
                pokemonSteps.getSameFields(POKEMON_NAME, abilityPokemonTwo).getAbilities()
                        .stream().anyMatch(x -> x.getAbility().getName().contains(ability)),
                "Ожидалось что у покемонов нет общей способности");
    }

    @Test
    @DisplayName("Проверка, что при запросе 1000 покемонов, у каждого покемона в списке не пустое name")
    public void checkNamePokemon(){
        int limitPoke = 1000;
        pokemonSteps.getListPokemon(limitPoke)
                .statusCode(200)
                //проверка, что поля name не пустые
                .body("results.name", not(hasValue(nullValue())));
    }

    @Test
    @DisplayName("Проверка что заданный лимит списка выдает нужное количество покемонов")
    public void checkListPokemon(){
        int id = 1000;
        List<Root.Result> listPokemon = pokemonSteps.getListPokemon(id)
                .statusCode(200)
                .extract().jsonPath().getList("results", Root.Result.class);
        //проверяем количество элементов полученного списка с заданным числом
        Assertions.assertEquals((long) listPokemon.size(), id,
                "Ожидалось совпадение количества элементов полученного списка с заданным числом");
    }
}
