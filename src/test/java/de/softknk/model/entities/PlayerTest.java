package de.softknk.model.entities;
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

}
