package helpers;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {
    private StringBuilder propertiesName;
    InputStream inputStream;
    Properties properties;

    public PropertiesReader(String propertiesName) throws IOException {
        try {
            this.propertiesName = new StringBuilder(propertiesName);
            properties = new Properties();

            this.propertiesName.append(".properties");
            inputStream = getClass().getClassLoader().getResourceAsStream(this.propertiesName.toString());
            properties.load(inputStream);

        } catch (Exception e){
            throw new FileNotFoundException("property file '" + this.propertiesName + "' not found in the classpath");
        } /*finally {
            inputStream.close();
        }*/
    }

    public String getProperty(String property){
        return this.properties.getProperty(property);
    }
}