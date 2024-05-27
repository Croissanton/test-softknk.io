package de.softknk.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.File;

public class ReadGameDataTest {

    @Mock
    private DataFile dataFile; //Esto no va bien con mock, hay que buscarle alternativa. Fallan los 2 tests por motivos que no deberían.

    @Test
    @DisplayName("When a data file already exists, the game should start, using the data provided in the file.")
    public void ReadData_WhenDataFileExists_ReturnsSuccess() {
        Mockito.when(DataFile.dataFile()).thenReturn(new File("test-data.txt"));
        assert ReadGameData.readData().isPresent();

    }
    @Test
    @DisplayName("When a data file does not exist, the game should start with default values.")
    public void ReadData_WhenDataFileDoesNotExist_ReturnsFailure() {
        Mockito.when(DataFile.dataFile().exists()).thenReturn(false);
        if (ReadGameData.readData().isPresent()) throw new AssertionError();
    }

}
