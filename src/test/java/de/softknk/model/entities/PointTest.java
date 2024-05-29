package de.softknk.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    Point point;

    @BeforeEach
    public void setUp() {
        point = new Point();
        Point.initScoreValue(1);
    }

    @Test
    @DisplayName("Increasing the score value of a point should increase the score value by 1.")
    public void increaseScoreValue_IncreasesScoreValue() {
        Point.increaseScoreValue();
        int expected = 2;
        int obtained = Point.scoreValue();
        assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Getting the score value of a point should return the score value of the point.")
    public void scoreValue_WithValidScoreValue_ReturnsScoreValue() {
        int expected = 1;
        int obtained = Point.scoreValue();
        assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Moving a point on the x-axis should change the x-coordinate of the point.")
    public void moveX_WithValidPixel_ChangesXCoordinate() {
        double expected = point.getX() + 10;
        point.moveX(10);
        double obtained = point.getX();
        assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Moving a point on the y-axis should change the y-coordinate of the point.")
    public void moveY_WithValidPixel_ChangesYCoordinate() {
        double expected = point.getY() + 10;
        point.moveY(10);
        double obtained = point.getY();
        assertEquals(expected, obtained);
    }

}
