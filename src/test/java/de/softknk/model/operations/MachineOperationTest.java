package de.softknk.model.operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class MachineOperationTest {

    private static MachineOperation machineOperation;

    @BeforeEach
    public void setUp() {
        machineOperation = new MachineOperation(1);
    }

    @Test
    @DisplayName("Test getPrice() method when level is one")
    public void getPrice_WhenLevelOne_ReturnFourThousand() {
        int expectedValue = 8000;
        int obtainedValue = machineOperation.getPrice();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test doOperation method when level is one")
public void doOperation_WhenLevelOne_ReturnTen() {
        int expectedValue = 10;
        int obtainedValue = machineOperation.getPointsPerSecond();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test operationName method")
    public void operationName_ReturnMachine() {
        String expectedValue = "MACHINE";
        String obtainedValue = machineOperation.operationName();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    @DisplayName("Test getPointsPerSecond method")
    public void getPointsPerSecond_ReturnTen() {
        machineOperation.doOperation();

        int expectedValue = 10;
        int obtainedValue = machineOperation.getPointsPerSecond();

        assertEquals(expectedValue, obtainedValue);
    }
}
