package servlets.Sider;

import org.junit.jupiter.api.Test;
import tools.database.DatabaseReader;

import static org.junit.jupiter.api.Assertions.*;

class CheckLoginTest {
    @Test
    public void testLoginUtover () {
        assertTrue(DatabaseReader.loginCorrect("mari@hotmail.com", "root"));
    }

    @Test
    public void testLoginTrener () {
        assertTrue(DatabaseReader.loginCorrect("gordon.ramsey@kitchen.com", "root"));
    }

    @Test
    public void testLoginSuperbruker () {
        assertTrue(DatabaseReader.loginCorrect("superbruker@roing.no", "root"));
    }
}