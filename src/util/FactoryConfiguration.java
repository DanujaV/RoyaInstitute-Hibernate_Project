package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static Properties properties;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration();
        properties = new Properties();

        try {
            //load property file
            properties.load(Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("hibernate.properties"));
            configuration.setProperties(properties);

            //build session factory
            SessionFactory factory = configuration.buildSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
