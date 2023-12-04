import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserLoginSelectorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    void testShowSelectorInvalidInput() throws IOException {
        // GIVEN
        Scanner sc = new Scanner(System.in);
        String choice = "7";
        // WHEN
        UserLoginSelector.showSelector(sc, choice);
        System.setOut(System.out);

        // THEN
        assertEquals("Очакван низ", outContent.toString().trim());
    }

}
