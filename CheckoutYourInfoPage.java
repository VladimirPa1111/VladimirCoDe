package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class CheckoutYourInfoPage extends BasePage{
        public CheckoutYourInfoPage (WebDriver driver){
        super(driver);   
    }

    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By zipPostalCodeBy = By.id("postal-code");
    By continueButtonBy = By.id("continue"); 

    public CheckoutYourInfoPage fillYourInformation(String firstName, String lastName, String zipPostalCode){
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(zipPostalCodeBy, zipPostalCode);
        click(continueButtonBy);
        return this;
    }   
}
