package Flight.Utility;

import java.io.*;
import java.util.Properties;

public class PropertyFileReader {

    public Properties properties;

    public PropertyFileReader(String filepath) throws IOException {
        BufferedReader reader;
        String PropertyPath = "test_data//" + filepath+".properties";
        try {
            reader = new BufferedReader(new FileReader(PropertyPath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Flight.property file not found" + PropertyPath);

        }


    }
    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null)
            return value;
        else
            throw new RuntimeException("key not specified in the properties file.");
    }

    public Properties getAllProperties() {
        if (properties != null)
            return properties;
        else
            throw new RuntimeException("No property specified in the property file.");

    }


    public String getApplicationUrl(String url){

        String value = properties.getProperty(url);
        if(value != null){
            return value;

        }else{
            throw new RuntimeException("value in Flight.property file not found" + url);
        }
    }

    public String getBaseDir(){

        String dir = properties.getProperty("user.dir");
        if(dir != null){
            return dir;
        }else{
            throw new RuntimeException("Base dir in Flight.property file not found");
        }


    }
    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null)
            return Long.parseLong(implicitlyWait);
        else
            throw new RuntimeException("implicitlyWait not specified in the FlightSearchFormTestCase.properties file.");
    }

}
