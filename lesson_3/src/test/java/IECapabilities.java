import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IECapabilities {

    private WebDriver driver;


    @Test
    public void getCapabilities(){
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
//        WebDriver driver = new ChromeDriver(caps);
//        System.out.println(((HasCapabilities) driver).getCapabilities());

        ChromeOptions options = new ChromeOptions();
        options.setCapability("unexpectedAlertBehaviour", "dismiss");
        driver = new ChromeDriver(options);

    }

    @Test
    public void startFullscreen(){
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
    }

    @Test
    public void ieCapabilities(){
        InternetExplorerOptions opt = new InternetExplorerOptions();
        opt.setCapability("unexpectedAlertBehaviour", "dismiss");
        opt.setCapability("InternetExplorerDriver.REQUIRE_WINDOW_FOCUS", "dismiss");
        driver = new InternetExplorerDriver(opt);
    }

    @After
    public void stop() {
        driver.close();
        driver = null;
    }
}
