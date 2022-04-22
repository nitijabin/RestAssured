package com.rest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    public static void loadProperties() throws IOException {
        load("src/test/resources/data.properties");

        load("src/test/resources/env."
                + System.getProperty("active.env")
                + ".properties");

    }
    public static void load(final String propertyPath) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(propertyPath)));
        for (String key : properties.stringPropertyNames()) {
            System.setProperty(key, properties.getProperty(key));
        }
    }
}