package com.dgyt.tank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static final Properties props = new Properties();

    static {
        try {
            props.load(PropertyManager.class.getClassLoader().getResourceAsStream("Config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        return props.get(key);
    }
}
