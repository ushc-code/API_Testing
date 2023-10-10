package helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyProvider {
    private static PropertyProvider inctance;

    public static synchronized PropertyProvider getInctance() {
        if (inctance == null) {
            inctance = new PropertyProvider();
        }
        return inctance;
    }

    private PropertyProvider() {

    }

    public String getProperty(String propertyName) {

        Properties prop = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/properties/config.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }
        } catch (Exception e) {
            System.out.println("Property not found");
        }
        return null;
    }
}
