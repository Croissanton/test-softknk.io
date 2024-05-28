package de.softknk.model.operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class FactoryOperationTest {

    private static FactoryOperation factoryOperation;

    @BeforeEach
    public void setUp() {
        factoryOperation = new FactoryOperation(1);
    }

    @Test
    @DisplayName("Test getPrice() method when level is one")
    public void getPrice_WhenLevelOne_ReturnThirtyTwoThousand() {
        int expectedValue = 64000;
        int obtainedValue = factoryOperation.getPrice();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test doOperation method when level is one")
    public void doOperation_WhenLevelOne_ReturnZero() {
        int expectedValue = 200;
        int obtainedValue = factoryOperation.getPointsPerSecond();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test operationName method")
    public void operationName_ReturnFactory() {
        String expectedValue = "FACTORY";
        String obtainedValue = factoryOperation.operationName();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test getPointsPerSecond method")
    public void getPointsPerSecond_ReturnZero() {
        factoryOperation.doOperation();

        int expectedValue = 200;
        int obtainedValue = factoryOperation.getPointsPerSecond();

        assertEquals(expectedValue, obtainedValue);
    }
}
