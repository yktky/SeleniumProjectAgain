package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    //this class will be responsible for loading properties file and will provide access
    //to values based on key names
    //we use Properties class to load custom.properties files
    private static Properties configFile;

    static {
        try {
            //location of properties file
            //provides access to file
            //try/catch block stands for handling exceptions
            //if exception occurs, code inside a catch block will be excuted
            //any class that is related to InputOutput produce checked exceptions
            //without handling checked exception, you can not run a code
            String path = System.getProperty("user.dir")+"/configuration.properties";
            //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //initialize properties object or create object of Properties class
            configFile = new Properties();
            //load your properties file into Properties object
            configFile.load(input);
            //close the input stream at the end
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }

    }

    /**
     * This method returns property value from configuration.properties file
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }

}
