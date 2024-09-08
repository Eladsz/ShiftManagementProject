//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package LoggerTests;

import org.junit.BeforeClass;
import org.junit.Test;

import Logger.Logger;

public class LoggerTest {
    @BeforeClass
    public static void setup() {
        Logger.initLogger();
    }

    @Test
    public void testLogging() {
        Logger.log("This is a test log message");
        Logger.debug("This is a debug log message");
        Logger.error("This is an error log message");
    }
}
