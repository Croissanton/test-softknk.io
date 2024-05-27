package de.softknk;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class JavaFXExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        JavaFXInitializer.initialize();
    }
}
