package servlets.Sider;

import org.junit.jupiter.api.Test;
import tools.database.DatabaseReader;

import static org.junit.jupiter.api.Assertions.*;

class CheckLoginTest {
    @Test
    public void testLogin () {
        assertTrue(DatabaseReader.loginCorrect("johan.svartdal30@gmail.com", "root"));
    }
}