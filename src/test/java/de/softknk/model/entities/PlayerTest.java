package de.softknk.model.entities;
import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private static Player player;
    static //static block only runs once when the class is loaded
    {
        Platform.startup(() -> {
        });
    }
    @BeforeEach
    public void setUp() {
        player = new Player("TestPlayer", 0);
    }

    @Test
    @DisplayName("Getting the name of a player should return the name of the player.")
    public void getName_WithValidName_ReturnsName() {
        assertEquals("TestPlayer", player.getNickname());
    }

    @Test
    @DisplayName("Getting the score of a player should return the score of the player.")
    public void getScore_WithValidScore_ReturnsScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    @DisplayName("When you increase the score of a player, the score should be increased by the specified amount.")
    public void increaseScore_WithPositiveScore_IncreasesScore() {
        player.increaseScore(10);
        assertEquals(10, player.getScore());
    }

    @Test
    @DisplayName("When you increase the score of a player with a negative score, the score should not change.")
    //todo: but it do
    public void increaseScore_WithNegativeScore_DoesNotChangeScore() {
        player.increaseScore(-5);
        assertEquals(0, player.getScore());
    }

    @Test
    @DisplayName("When you buy a level with insufficient points, the method should return false.")
    public void buyLevel_WithInsufficientPoints_ReturnsFalse() {
        boolean result = player.buyLevel(10);
        assertFalse(result);
    }

    @Test
    @DisplayName("When you buy a level with sufficient points, the method should return true.")
    public void buyLevel_WithSufficientPoints_ReturnsTrue() {
        player.increaseScore(20);
        boolean result = player.buyLevel(10);
        assertTrue(result);
        assertEquals(10, player.getScore());
    }
}
