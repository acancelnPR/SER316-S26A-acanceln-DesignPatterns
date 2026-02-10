import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainSample {

    private Main main;

    @BeforeEach
    public void setUp(){
        main = new Main();
    }

    @Test
    @DisplayName("Test Build- gradle was configured correctly")
    public void testBuild(){
        String result;

        result = main.test_build(true);
        assertEquals("Hello World", result);

        result = main.test_build(false);
        assertEquals("Bye World", result);
    }
}
