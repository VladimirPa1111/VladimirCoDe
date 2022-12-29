package tests;

import org.junit.Test;
import pages.CheckoutOverviewPage;
import pages.CheckoutYourInfoPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class CheckoutOverviewTests extends BaseTest{
    
    public LoginPage loginPage;
    public ProductsPage productsPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";
        
    String firstName = "Vladimir";
    String lastName = "Savicic";
    String zipPostalCode = "26000 Pancevo";

    String completeHeader = "THANK YOU FOR YOUR ORDER";

@Test    
    public void verifyTotalPrice(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        YourCartPage yourCartPage = new YourCartPage(driver);
        CheckoutYourInfoPage checkoutYourInfoPage = new CheckoutYourInfoPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver); 
        loginPage.basePage();
        loginPage.login(username, password);
        productsPage.verifySuccessfulLogin(expectedText);
        productsPage.verifyTwoProductsAddedtoShoppingCart();
        yourCartPage.clickCheckout();
        checkoutYourInfoPage.fillYourInformation(firstName, lastName, zipPostalCode);
        checkoutOverviewPage.verifySum();

        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }

@Test    
    public void verifySuccessfulOrder(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        YourCartPage yourCartPage = new YourCartPage(driver);
        CheckoutYourInfoPage checkoutYourInfoPage = new CheckoutYourInfoPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver); 
        loginPage.basePage();
        loginPage.login(username, password);
        productsPage.verifySuccessfulLogin(expectedText);
        productsPage.verifyTwoProductsAddedtoShoppingCart();
        yourCartPage.clickCheckout();
        checkoutYourInfoPage.fillYourInformation(firstName, lastName, zipPostalCode);
        checkoutOverviewPage.clickFinish();
        checkoutOverviewPage.verifySuccessfulPurchase(completeHeader);

        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }   
}
