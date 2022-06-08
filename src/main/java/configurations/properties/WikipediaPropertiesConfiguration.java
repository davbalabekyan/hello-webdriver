package configurations.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WikipediaPropertiesConfiguration {

    public static void configureProperties() {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/wikipedia.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            System.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
