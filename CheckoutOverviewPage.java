package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage (WebDriver driver){
        super(driver);
    }

    By itemTotalBy = By.className("summary_subtotal_label");
    By taxBy = By.className("summary_tax_label");
    By summaryTotalBy = By.className("summary_total_label");

    By finishButtonBy = By.id("finish");
    By completeHeaderBy = By.className("complete-header");
  
    public CheckoutOverviewPage verifySum(){
        double basePrice = Double.parseDouble(readText(itemTotalBy).substring(13));
        double vat = Double.parseDouble(readText(taxBy).substring(6));
        double sum = Double.parseDouble(readText(summaryTotalBy).substring(8));
        double totalValue = basePrice + vat;
        Assert.assertEquals(sum, totalValue,0.000001);
        return this;
    }
    public CheckoutOverviewPage clickFinish(){
        click(finishButtonBy);               
        return this;
    }
    public CheckoutOverviewPage verifySuccessfulPurchase(String expectedText){
        String actualText = readText(completeHeaderBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }
    
    
}
