import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class ProductPage {
    private static WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkRightProductPage() {
        driver.get("http://localhost/litecart/");
        WebElement productOnMain = driver.findElement(By.cssSelector("div#box-campaigns li:first-child"));
        String nameOnMain = productOnMain.findElement(By.cssSelector("div.name")).getText();
        //Prices
        int regularPriceOnMain = findPrice("//div[@id='box-campaigns']//li[1]//s");
        int campaignPriceOnMain = findPrice("//div[@id='box-campaigns']//li[1]//strong");
        //Color of campaign price
        Integer[] campaignPriceColor = findcolor("//div[@id='box-campaigns']//li[1]//strong", "Chrome");
        assertTrue(campaignPriceColor[1] == 0 & campaignPriceColor[2] == 0);
        assertTrue(productOnMain.findElement(By.xpath("//div[@id='box-campaigns']//li[1]//strong")).getAttribute("localName").equals("strong"));
        //Color of regular price color
        Integer[] regularPriceColor = findcolor("//div[@id='box-campaigns']//li[1]//s", "Chrome");
        assertTrue(regularPriceColor[0] == regularPriceColor[1] & regularPriceColor[1] == regularPriceColor[2] & regularPriceColor[0] == regularPriceColor[2]);
        assertTrue(productOnMain.findElement(By.cssSelector("s.regular-price")).getAttribute("localName").equals("s"));
        assertTrue(findFontSize("//div[@id='box-campaigns']//li[1]//strong") > findFontSize("//div[@id='box-campaigns']//li[1]//s"));
        productOnMain.click();

        //Product page
        String nameOnProductPage = driver.findElement(By.cssSelector("h1")).getText();
        assertTrue(nameOnMain.equals(nameOnProductPage));
        //Prices
        String regularLocator = "//div[@class = 'information']/div[@class = 'price-wrapper']/s";
        String campaignLocator = "//div[@class = 'information']/div[@class = 'price-wrapper']/strong";
        int regularPriceOnProductPage = findPrice(regularLocator);
        assertTrue(regularPriceOnProductPage == regularPriceOnMain);
        int campaignPriceOnProductPage = findPrice(campaignLocator);
        assertTrue(campaignPriceOnMain == campaignPriceOnProductPage);
        //Color of campaign price
        campaignPriceColor = findcolor(campaignLocator, "Chrome");
        assertTrue(campaignPriceColor[1] == 0 & campaignPriceColor[2] == 0);
        assertTrue(driver.findElement(By.xpath(campaignLocator)).getAttribute("localName").equals("strong"));
        //Color of regular price color
        regularPriceColor = findcolor(regularLocator, "Chrome");
        assertTrue(regularPriceColor[0] == regularPriceColor[1] & regularPriceColor[1] == regularPriceColor[2] & regularPriceColor[0] == regularPriceColor[2]);
        assertTrue(driver.findElement(By.xpath(regularLocator)).getAttribute("localName").equals("s"));
        assertTrue(findFontSize(campaignLocator) > findFontSize(regularLocator));
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    private static int findPrice(String locator) {
        String priceString = driver.findElement(By.xpath(locator)).getText();
        String buf = priceString.substring(1);
        return Integer.parseInt(buf);
    }

    private static Integer[] findcolor(String locator, String driverType) {
        String color = driver.findElement(By.xpath(locator)).getCssValue("color");
        String buf;
        if (driverType.equals("Chrome")) {
            buf = color.substring(5, color.length() - 1);
        } else {
            buf = color.substring(4, color.length() - 1);
        }
        String[] rgbComponentsString = buf.split(", ");
        Integer[] rgbComponents = new Integer[rgbComponentsString.length];
        for (int i = 0; i < rgbComponentsString.length; i++) {
            rgbComponents[i] = Integer.parseInt(rgbComponentsString[i]);
        }
        return rgbComponents;
    }

    private static Double findFontSize(String locator) {
        String sizeString = driver.findElement(By.xpath(locator)).getCssValue("font-size");
        Double size = Double.parseDouble(sizeString.replace("px", ""));
        return size;
    }
}
