package Flight.BaseTest;

import Flight.Driver.ChromeDriverManager;
import Flight.Driver.EdgeDriverManager;
import Flight.Driver.FireFoxDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverManagerFactory {

    public static DriverManager getDrivermanager(DriverManagerType type){
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new EdgeDriverManager();
                break;
            default:
                driverManager = new FireFoxDriverManager();
                break;

        }
        return driverManager;

    }
}
