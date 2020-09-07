package com.dgyt.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author hanrongjie
 */
public class PropertyManager {
    private static final Properties PROPS = new Properties();

    static {
        try {
            PROPS.load(PropertyManager.class.getClassLoader().getResourceAsStream("Config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyManager() {
    }

    public static Object get(String key) {
        return PROPS.get(key);
    }
}
