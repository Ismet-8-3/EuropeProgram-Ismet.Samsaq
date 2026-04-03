package com.unitedcoder.propertiesfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : ismetsasaq
 * @created : 31/03/2026,20:34
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class ReadFromConfig {
    public static  String readFromConfig(String fileName,String key) {
        Properties properties = new Properties();
        //open the file in reading more
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value=properties.getProperty(key);
        return value;
    }
}
