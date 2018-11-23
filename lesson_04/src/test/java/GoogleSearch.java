import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class GoogleSearch {

    private WebDriver driver;

    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchWait(){
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("search");
        driver.findElement(By.name("btnK")).submit();
        assertTrue(isElementPresent(driver, By.cssSelector(".rc")));

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
