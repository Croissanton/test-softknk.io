package de.softknk.model.operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class MineOperationTest {

    private static MineOperation mineOperation;

    @BeforeEach
    public void setUp() {
        mineOperation = new MineOperation(1);
    }

    @Test
    @DisplayName("Test getPrice() method when level is one")
    public void getPrice_WhenLevelOne_ReturnSixteenThousand() {
        int expectedValue = 32000;
        int obtainedValue = mineOperation.getPrice();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test doOperation method when level is one")
    public void doOperation_WhenLevelOne_ReturnFifty() {
        int expectedValue = 100;
        int obtainedValue = mineOperation.getPointsPerSecond();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test operationName method")
    public void operationName_ReturnMine() {
        String expectedValue = "MINE";
        String obtainedValue = mineOperation.operationName();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test getPointsPerSecond method")
    public void getPointsPerSecond_ReturnFifty() {
        mineOperation.doOperation();

        int expectedValue = 100;
        int obtainedValue = mineOperation.getPointsPerSecond();

        assertEquals(expectedValue, obtainedValue);
    }
}
