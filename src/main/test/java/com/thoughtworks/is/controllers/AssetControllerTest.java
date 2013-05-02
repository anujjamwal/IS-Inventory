package com.thoughtworks.is.controllers;

import com.thoughtworks.is.repositories.AssetRepository;
import com.thoughtworks.is.repositories.AssetTypeRepository;
import junit.framework.Assert;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class AssetControllerTest  {

    @Test
    public void a() {

    }
}












//    @Test
//    public void testing() {
//        WebDriver driver = new HtmlUnitDriver();
//
//        driver.get("http://localhost:4040");
//        WebElement element = driver.findElement(By.name("q"));
//        element.sendKeys("Cheese!");
//        element.submit();
//        System.out.println("Page title is: " + driver.getTitle());
//        Assert.assertEquals(driver.getTitle(),"Create an asset");
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("cheese!");
//            }
//        });
//
//        System.out.println("Page title is: " + driver.getTitle());
//
//        driver.quit();
//    }
//}