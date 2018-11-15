import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.File;

public class LaunchIE {
//    private WebDriver driver;
//
//    @Before
//    public void start() {
//        driver = new InternetExplorerDriver();
//    }

    @Test
    public void loginTest() {
        getIEDriver();
    }

//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }

    public static InternetExplorerDriver getIEDriver(){
        InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
                .withLogLevel(InternetExplorerDriverLogLevel.TRACE)
                .withLogFile(new File("iedriver.log")).build();
        return new InternetExplorerDriver(service);
    }
}
