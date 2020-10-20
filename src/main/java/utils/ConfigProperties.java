package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 *
 */

public class ConfigProperties {

    public static String getProperty(String property) throws IOException {
        InputStream input =
                ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties");

        Properties properties = new Properties();
        properties.load(input);
        return properties.getProperty(property);
    }
}
