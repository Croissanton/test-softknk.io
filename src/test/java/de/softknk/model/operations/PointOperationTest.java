package de.softknk.model.operations;

import de.softknk.model.entities.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class PointOperationTest {

    private static PointOperation pointOperation;

    @BeforeEach
    public void setUp() {
        pointOperation = new PointOperation(1);
    }

    @Test
    @DisplayName("Test getPrice() method when level is one")
    public void getPrice_WhenLevelOne_ReturnSixteenThousand() {
        int expectedValue = 100;
        int obtainedValue = pointOperation.getPrice();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test doOperation() method")
    public void doOperation_WhenCalled_IncreaseScoreValue() {
        Point.initScoreValue(1);
        pointOperation.doOperation();

        int expectedValue = 2;
        int obtainedValue = Point.scoreValue();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test operationName method")
    public void operationName_ReturnPoint() {
        String expectedValue = "POINT";
        String obtainedValue = pointOperation.operationName();

        assertEquals(expectedValue, obtainedValue);
    }
}
