package de.softknk.model.operations;

import de.softknk.gui.OperationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class OperationTest {

    private static Operation operation;

    @BeforeEach
    public void setUp() {
        operation = new Operation(null, 1) {
            @Override
            public void init() {
            }

            @Override
            public int getPrice() {
                return 0;
            }

            @Override
            public void doOperation() {
            }

            @Override
            public String operationName() {
                return null;
            }
        };
    }

    @Test
    @DisplayName("Test increaseLevel() method")
    public void increaseLevel_WhenCalled_IncreaseLevelByOne() {
        // Act
        operation.increaseLevel();

        int expectedLevel = 2;
        int obtainedLevel = operation.getLevel();

        // Assert
        assertEquals(expectedLevel, obtainedLevel);
    }

    @Test
    @DisplayName("Test canBuyLevel() method when player can buy level")
    public void canBuyLevel_WhenPlayerCanBuyLevel_ReturnTrueAndIncreaseLevel() {
        // Act
        boolean obtainedResult = operation.canBuyLevel();
        boolean expectedResult = true;

        int expectedLevel = 2;
        int obtainedLevel = operation.getLevel();

        // Assert
        assertEquals(expectedResult, obtainedResult);
        assertEquals(expectedLevel, obtainedLevel);
    }

    @Test
    @DisplayName("Test canBuyLevel() method when player cannot buy level")
    public void canBuyLevel_WhenPlayerCannotBuyLevel_ReturnFalseAndDoNotIncreaseLevel() {
        // Act
        boolean obtainedResult = operation.canBuyLevel();
        boolean expectedResult = false;

        int expectedLevel = 1;
        int obtainedLevel = operation.getLevel();

        // Assert
        assertEquals(expectedResult, obtainedResult);
        assertEquals(expectedLevel, obtainedLevel);
    }

    @Test
    @DisplayName("Test setLevel() method when level is positive")
    public void setLevel_WhenLevelPositive_UpdateLevelAndCallDataUpdate() {
        // Act
        operation.setLevel(5);

        int expectedLevel = 5;
        int obtainedLevel = operation.getLevel();

        // Assert
        assertEquals(expectedLevel, obtainedLevel);
    }

    @Test
    @DisplayName("Test setLevel() method when level is negative")
    public void setLevel_WhenLevelNegative_DoNotUpdateLevel() {
        // Act
        operation.setLevel(-5);

        int expectedLevel = 1;
        int obtainedLevel = operation.getLevel();

        // Assert
        assertEquals(expectedLevel, obtainedLevel); // Level should remain unchanged
    }

    @Test
    @DisplayName("Test getData() method")
    public void getData_WhenCalled_ReturnOperationData() {
        // Act
        OperationData obtainedData = operation.getData();

        // Assert
        assertEquals(operation.data, obtainedData);
    }
}
