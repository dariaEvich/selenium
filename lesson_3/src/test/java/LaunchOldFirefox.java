import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LaunchOldFirefox {
    private WebDriver driver;

    @Test
    public void oldMethod(){
        FirefoxOptions options = new FirefoxOptions().setLegacy(false);
        driver = new FirefoxDriver(options);
        driver.get("http://www.google.com");
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
    public void nightlyVersion(){
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")));
        driver = new FirefoxDriver(options);
        driver.get("http://www.google.com");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
