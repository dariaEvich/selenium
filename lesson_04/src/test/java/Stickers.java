import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Stickers {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void areStickersPresent() {
        driver.get("http://localhost/litecart");
        Integer itemsCount = driver.findElements(By.cssSelector("li.product.column.shadow.hover-light")).size();
        Integer stickersCount = driver.findElements(By.cssSelector("div.sticker.sale")).size() + driver.findElements(By.cssSelector("div.sticker.new")).size();
        Assert.assertEquals(itemsCount, stickersCount);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
