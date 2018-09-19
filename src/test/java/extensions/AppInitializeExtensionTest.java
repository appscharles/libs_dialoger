package extensions;

import com.sun.javafx.application.PlatformImpl;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * The type App initialize extension.
 */
public class AppInitializeExtensionTest implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        PlatformImpl.setImplicitExit(false);
        PlatformImpl.startup(() -> {
        });
    }
}