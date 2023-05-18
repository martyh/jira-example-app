package com.teamswork.collab.services;

import javax.inject.Named;
import java.io.IOException;
import java.util.Properties;

/**
 * Picks out properties that are compiled into the maven.properties file as part of the plugin build process.
 */
@Named
public class ResourceService {

    private final Properties properties = new Properties();

    public ResourceService() throws IOException {
        java.io.InputStream is = this.getClass().getClassLoader().getResourceAsStream("maven.properties");
        if (is != null) {
            properties.load(is);
        }
    }

    public String getProperty(String propertyName)  {
        return this.properties.getProperty(propertyName);
    }
}
