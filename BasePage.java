package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

    public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }
    public void click(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
    public String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();        
    }
    public void assertTextEquals(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);      
    }
    public int countItems(By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy).size();
    }
    public void assertIntegetEquals (int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }
    public void assertDoubleEquals (double expectedNumber, double actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber, 0.000001);
    }
}