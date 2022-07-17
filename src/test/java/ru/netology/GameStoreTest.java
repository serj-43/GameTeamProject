package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertTrue(store.containsGame(game));
    }

    @Test
    public void addDublicateGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertFalse(store.containsGame(game));
    }

    @Test
    public void AddSomeGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Башни", "Стратегии");
        assertTrue(store.containsGame(game2));
    }

    @Test
    public void NoSuchGame() {

        GameStore store = new GameStore();
        GameStore store2 = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store2.publishGame("Нетология Башни", "Стратегии");
        assertFalse(store.containsGame(game2));
    }

    @Test
    public void NoMostPlayerFind() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Sergey", 1);
        String actual = store.getMostPlayer();
        String expected = "Sergey";
        assertEquals(expected, actual);
    }

    @Test
    public void MostPlayerFind() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Sergey", 3);
        store.addPlayTime("Oleg", 4);
        store.addPlayTime("Sergey", 2);
        String actual = store.getMostPlayer();
        String expected = "Sergey";
        assertEquals(expected, actual);
    }

    @Test
    public void MostPlayerFind2() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Sergey", 3);
        store.addPlayTime("Oleg", 4);
        store.addPlayTime("Sergey", 2);
        store.addPlayTime("Oleg", 10);
        String actual = store.getMostPlayer();
        String expected = "Oleg";
        assertEquals(expected, actual);
    }

    @Test
    public void SumTimeFind() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Sergey", 3);
        store.addPlayTime("Oleg", 4);
        store.addPlayTime("Sergey", 2);
        int actual = store.getSumPlayedTime();
        int expected = 9;
        assertEquals(expected, actual);
    }


}
