package testngframework;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * @author : ismetsasaq
 * @created : 30/11/2024,20:39
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class ScreenShotUtility {
    public void tackScreenShot(String fileName, ChromeDriver driver){
        DateTime dateTime=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yy-MM-HH-mm");
        String timeStamp=dateTime.toString(formatter);
        fileName=fileName+"_"+timeStamp;
        File imageFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String imageFolder="screenshoots";
        try {
            FileUtils.copyFile(imageFile,new File(imageFolder+File.separator+fileName+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
