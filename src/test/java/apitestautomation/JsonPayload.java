package apitestautomation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;

/**
 * @author : ismetsasaq
 * @created : 18/04/2026,11:06
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class JsonPayload {
    public static String catName;
    public static String addCategoryPayload(){
        Faker faker=new Faker();
        catName=faker.book().title();
        return String.format("{\n" +
                "  \"id\": 0,\n" +
                "catDescription\": \"0-3 years baby stuffs\",\n" +
                "catName\": %s\n"+
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2026-04-15T18:54:32.637Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}",catName);

    }
    public static String getAddCategoryPayload(){
        long timeStemp=System.currentTimeMillis();
        String payload=null;
        Category category=new Category("Electronic product"+timeStemp,11,
                "Appel product"+timeStemp,12,32,11,43,2,1,
                "good product","2 years garuanty","EP",55);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payload=objectMapper.writeValueAsString(category);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }

}
