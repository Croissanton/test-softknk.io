package de.softknk.model.operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class ExcavatorOperationTest {

    private static ExcavatorOperation excavatorOperation;

    @BeforeEach
    public void setUp() {
        excavatorOperation = new ExcavatorOperation(1);
    }

    @Test
    @DisplayName("Test getPrice() method when level is one")
    public void getPrice_WhenLevelOne_ReturnSixteenThousand() {
        int expectedValue = 16000;
        int obtainedValue = excavatorOperation.getPrice();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test doOperation method when level is one")
    public void doOperation_WhenLevelOne_ReturnFifty() {
        int expectedValue = 50;
        int obtainedValue = excavatorOperation.getPointsPerSecond();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
@DisplayName("Test operationName method")
    public void operationName_ReturnExcavator() {
        String expectedValue = "EXCAVATOR";
        String obtainedValue = excavatorOperation.operationName();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test getPointsPerSecond method")
    public void getPointsPerSecond_ReturnFifty() {
        excavatorOperation.doOperation();

        int expectedValue = 50;
        int obtainedValue = excavatorOperation.getPointsPerSecond();

        assertEquals(expectedValue, obtainedValue);
    }
}
