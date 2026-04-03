package com.unitedcoder.propertiesfiles;

/**
 * @author : ismetsasaq
 * @created : 31/03/2026,20:45
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class ReadFromConfigFile {
    public static void main(String[] args) {
      String userName=  ReadFromConfig.readFromConfig("config-qa.properties","username");
        System.out.println(userName);
    }
}
