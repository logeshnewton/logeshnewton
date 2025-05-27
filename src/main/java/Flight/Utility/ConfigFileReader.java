package Flight.Utility;

import java.io.*;
import java.util.Properties;


public class ConfigFileReader {
    public static Properties properties;


    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "test_data/flight/FlightTestCase.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("FlightTestCase.properties not found at " + propertyFilePath);
        }
    }

    public static String getApplicationUrl() {
        String url = properties.getProperty("site.url");
        if (url != null)
            return url;
        else
            throw new RuntimeException("url not specified in the FlightSearchFormTestCase.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null)
            return Long.parseLong(implicitlyWait);
        else
            throw new RuntimeException("implicitlyWait not specified in the FlightSearchFormTestCase.properties file.");
    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null)
            return value;
        else
            throw new RuntimeException("key not specified in the FlightSearchFormTestCase.properties file.");
    }

    public String getBaseDir() {
        String dir = System.getProperty("user.dir");
        if (dir != null) {
            return dir;
        } else
            throw new RuntimeException("base dir not specified in the FlightSearchFormTestCase.properties file.");
    }
}

