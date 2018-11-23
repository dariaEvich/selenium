import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @org.junit.Test
    public void clickMenuItems() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<String> menuItems = new ArrayList<>();
        menuItems.add("Template");
        menuItems.add("Template");
        menuItems.add("Logotype");
        menuItems.add("Catalog");
        menuItems.add("Catalog");
        menuItems.add("Product Groups");
        menuItems.add("Option Groups");
        menuItems.add("Manufacturers");
        menuItems.add("Suppliers");
        menuItems.add("Delivery Statuses");
        menuItems.add("Sold Out Statuses");
        menuItems.add("Quantity Units");
        menuItems.add("CSV Import/Export");
        menuItems.add("Countries");
        menuItems.add("Currencies");
        menuItems.add("Customers");
        menuItems.add("Customers");
        menuItems.add("CSV Import/Export");
        menuItems.add("Newsletter");
        menuItems.add("Geo Zones");
        menuItems.add("Languages");
        menuItems.add("Languages");
        menuItems.add("Storage Encoding");
        menuItems.add("Job Modules");
        menuItems.add("Job Modules");
        menuItems.add("Customer Modules");
        menuItems.add("Shipping Modules");
        menuItems.add("Payment Modules");
        menuItems.add("Order Total Modules");
        menuItems.add("Order Success Modules");
        menuItems.add("Order Action Modules");
        menuItems.add("Orders");
        menuItems.add("Orders");
        menuItems.add("Order Statuses");
        menuItems.add("Pages");
        menuItems.add("Monthly Sales");
        menuItems.add("Monthly Sales");
        menuItems.add("Most Sold Products");
        menuItems.add("Most Shopping Customers");
        menuItems.add("Settings");
        menuItems.add("Settings");
        menuItems.add("Settings");
        menuItems.add("Settings");
        menuItems.add("Settings");
        menuItems.add("Settings");
        menuItems.add("Settings");
        menuItems.add("Settings");
        menuItems.add("Settings");
        menuItems.add("Slides");
        menuItems.add("Tax Classes");
        menuItems.add("Tax Classes");
        menuItems.add("Tax Rates");
        menuItems.add("Search Translations");
        menuItems.add("Search Translations");
        menuItems.add("Scan Files For Translations");
        menuItems.add("CSV Import/Export");
        menuItems.add("Users");
        menuItems.add("vQmods");
        menuItems.add("vQmods");

        List<WebElement> mainList = driver.findElements(By.cssSelector("ul#box-apps-menu >li"));
        int h1 = 0;
        for (int i = 0; i < mainList.size(); i++) {
            mainList = driver.findElements(By.cssSelector("ul#box-apps-menu >li"));
            mainList.get(i).click();
            Assert.assertEquals(menuItems.get(h1++), driver.findElement(By.cssSelector("h1")).getText());
            mainList = driver.findElements(By.cssSelector("ul#box-apps-menu >li"));
            List<WebElement> subMenu = mainList.get(i).findElements(By.xpath(".//li"));
            int k;
            for (k = 0; k < subMenu.size(); k++) {
                subMenu.get(k).click();
                mainList = driver.findElements(By.cssSelector("ul#box-apps-menu >li"));
                subMenu = mainList.get(i).findElements(By.xpath(".//li"));
                Assert.assertEquals(menuItems.get(h1++), driver.findElement(By.cssSelector("h1")).getText());
            }
        }
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
