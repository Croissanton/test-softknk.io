package de.softknk.data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ReadGameDataTest {

    private Path tempFile;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a temporary file with some data
        tempFile = Files.createTempFile("test-data", ".txt");
        Files.write(tempFile, "game data".getBytes());
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Wait for a short period to ensure the file is no longer in use
        Thread.sleep(100);

        int attempts = 0;
        while (attempts < 5) {
            try {
                Files.deleteIfExists(tempFile);
                break;
            } catch (Exception e) {
                attempts++;
                Thread.sleep(100); // Wait a bit before retrying
            }
        }
    }

    @Test
    @DisplayName("When a data file already exists, the game should start, using the data provided in the file.")
    public void ReadData_WhenDataFileExists_ReturnsSuccess() throws Exception {
        File testFile = tempFile.toFile();
        MockedStatic<DataFile> mockedStatic = Mockito.mockStatic(DataFile.class);

        try {
            // Mock the static method DataFile.dataFile() to return the temporary file
            mockedStatic.when(DataFile::dataFile).thenReturn(testFile);

            // Act: read the data
            Optional<List<String>> data = ReadGameData.readData();

            // Assert: verify the data is read successfully
            assertTrue(data.isPresent());
            assertTrue(data.get().contains("game data"));
        } finally {
            // Ensure the static mock is closed
            mockedStatic.close();
        }

        // The cleanup is handled in the @AfterEach method
    }

    @Test
    @DisplayName("When a data file does not exist, the game should start with default values.")
    public void readData_WhenDataFileDoesNotExist_ReturnsDefaults() throws Exception {
        File testFile = new File("non-existing-file.txt");
        MockedStatic<DataFile> mockedStatic = Mockito.mockStatic(DataFile.class);

        try {
            // Mock the static method DataFile.dataFile() to return the temporary file
            mockedStatic.when(DataFile::dataFile).thenReturn(testFile);

            // Act: read the data
            Optional<List<String>> data = ReadGameData.readData();

            // Assert: verify the data is read successfully
            assertTrue(data.isPresent());
            List<String> dataList = data.get();
            assertEquals(7, dataList.size(), "Data list should have 7 elements");
            assertEquals("<nickname>", dataList.get(0), "First element should be '<nickname>'");
            assertEquals("0", dataList.get(1), "Second element should be '0'");
            assertEquals("1", dataList.get(2), "Third element should be '1'");
            assertEquals("0", dataList.get(3), "Fourth element should be '0'");
            assertEquals("0", dataList.get(4), "Fifth element should be '0'");
            assertEquals("0", dataList.get(5), "Sixth element should be '0'");
            assertEquals("0", dataList.get(6), "Seventh element should be '0'");
        } finally {
            // Ensure the static mock is closed
            mockedStatic.close();
        }

        // The cleanup is handled in the @AfterEach method
    }
}
