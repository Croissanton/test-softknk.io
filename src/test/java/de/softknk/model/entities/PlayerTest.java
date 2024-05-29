/*package de.softknk.model.entities;
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
}*/

package de.softknk.model.entities;

import de.softknk.gui.PlayerData;
import de.softknk.main.AppSettings;
import de.softknk.model.util.Vector;
import de.softknk.model.util.EntityType;
import de.softknk.model.util.Moveable;
import de.softknk.model.entities.Point;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("TestPlayer", 100);
    }

    @Test
    @DisplayName("When a player is initialized, the player should have the correct values.")
    public void testInitialization_InitializationSuccess() {
        assertEquals("TestPlayer", player.getNickname());
        assertEquals(100, player.getScore());
        assertEquals(AppSettings.PLAYER_RADIUS, Player.RADIUS);
        assertEquals(AppSettings.WINDOW_WIDTH / 2, player.getStartX());
        assertEquals(AppSettings.WINDOW_HEIGHT / 2 - Player.RADIUS, player.getStartY());
        assertEquals(EntityType.PLAYER, player.getType());
        assertNotNull(player.getData());
    }

    //if the distance between the two centers (player and point) is less than the two radii then there is a collision!
    @Test
    @DisplayName("When a player collides with a point, the point should be added to the collision set.")
    public void testCollision_whenThereIsCollision_CollisionDetected() {
        Point point = new Point();
        point.setPosition(player.getStartX(), player.getStartY());
        player.collisionHandling(point);
        assertTrue(Player.collisionSet.contains(point));
    }
    //TEST FAILS DUE TO THE PLAYER NOT BEING ABLE TO COLLIDE WITH A POINT
    //POSSIBLE DUE TO THE ISSUE OF THE PLAYER NOT MODIFYING ENTITY COORDINATES

    @Test
    @DisplayName("When a player does not collide with a point, the point should not be added to the collision set.")
    public void testCollision_whenThereIsNoCollision_NoCollisionDetected() {
        Point point = new Point();
        point.setPosition(player.getStartX() + AppSettings.PLAYER_RADIUS + point.RADIUS + 1, player.getStartY() + AppSettings.PLAYER_RADIUS + point.RADIUS + 1);
        player.collisionHandling(point);
        assertFalse(Player.collisionSet.contains(point));
    }

    @Test
    @DisplayName("When the score is increased, the score should be updated.")
    public void testIncreaseScore_WithPositiveValue() {
        int initialScore = player.getScore();
        player.increaseScore(10);
        assertEquals(initialScore + 10, player.getScore());
    }

    @Test
    @DisplayName("When the score is increased with a negative value, the score should not change.")
    public void testIncreaseScore_WithNegativeValue() {
        int initialScore = player.getScore();
        player.increaseScore(-10);
        assertEquals(initialScore, player.getScore());
    }
    //TEST FAILS DUE TO THE ISSUE NOT BEING HANDLED

    @Test
    @DisplayName("When the player buys a level, the score should be updated." +
            "If the player does not have enough points, the player cannot make a purchase.")
    public void testBuyLevel() {
        int initialScore = player.getScore();
        assertTrue(player.buyLevel(50));
        assertEquals(initialScore - 50, player.getScore());

        assertFalse(player.buyLevel(200));
        assertEquals(initialScore - 50, player.getScore());
    }

    @Test
    @DisplayName("When the player moves to the right, the x-coordinate should increase.")
    public void testMoveX() {
        double initialX = player.getStartX();
        player.moveX(10);
        assertEquals(initialX + 10, player.getX());
    }
    //TEST FAILS DUE TO THE PLAYERS X VARIABLE NOT BEING RELATED TO ITS ENTITYS X VARIABLE

    @Test
    public void testMoveY() {
        double initialY = player.getStartY();
        player.moveY(10);
        assertEquals(initialY + 10, player.getY());
    }
    //TEST FAILS DUE TO THE PLAYERS Y VARIABLE NOT BEING RELATED TO ITS ENTITYS Y VARIABLE

    @Test
    public void testSetNickname() {
        player.setNickname("NewName");
        assertEquals("NewName", player.getNickname());
    }

    @Test
    @DisplayName("Players velocity is equal to the velocity set in appSettings.")
    public void testGetVelocity_isSameAsSettings() {
        assertEquals(AppSettings.VELOCITY, player.getVelocity());
    }

}

