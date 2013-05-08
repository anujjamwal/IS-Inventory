import junit.framework.Assert;
import org.openqa.selenium.*;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionalTest {

    @Test
    public void testing() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:4040");

        Assert.assertEquals(driver.getTitle(),"Assets");
        WebElement element = driver.findElement(By.tagName("h1"));
        element.sendKeys("Asset Management System");
//        element.submit();


        driver.quit();
    }
}

