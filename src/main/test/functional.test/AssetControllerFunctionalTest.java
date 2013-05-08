import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AssetControllerFunctionalTest {

    @Test
    public void testing() {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4040");
        Assert.assertEquals(driver.getTitle(), "Assets");
        String[] text2 = new String[10];
        int i = 0;
        //Header
        WebElement element = driver.findElement(By.tagName("h1"));
        String text = element.getText();
        Assert.assertEquals("Asset Management System", text);

        WebElement element1 = driver.findElement(By.tagName("ul"));

        List<WebElement> element2 = element1.findElements(By.tagName("li"));
        Assert.assertEquals(3, element2.size());


        for (WebElement ele : element2) {
            ele.findElement(By.tagName("a"));
            text2[i] = ele.getText();
            i++;
        }
        Assert.assertEquals("New", text2[0]);
        Assert.assertEquals("Stock", text2[1]);
        Assert.assertEquals("Add Asset Type", text2[2]);


        //footer
        WebElement element3 = driver.findElement(By.className("footer"));
        String text3 = element3.getText();
        Assert.assertEquals("Copyright © 2013, ThoughtWorks, Inc. All rights reserved.",text3);
        WebElement element4 = element3.findElement(By.tagName("a"));
        String text4 = element4.getText();
        Assert.assertEquals("ThoughtWorks", text4);
        System.out.println(text4);


        driver.quit();
    }
}

