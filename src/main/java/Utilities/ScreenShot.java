package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ScreenShot {

    public static void ScreenShoots(WebDriver driver, String testCaseName) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormated = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        File Screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = "ScreenShots/"+testCaseName+"_"+time.format(timeFormated)+".png";
        try {
            FileUtils.copyFile(Screenshots, new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
