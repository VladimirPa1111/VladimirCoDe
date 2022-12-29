package tests;

import org.junit.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class ProductsTests extends BaseTest {
    public LoginPage loginPage;
    public ProductsPage productsPage;

    String username = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";

    int numberOfAllProducts = 6;

    int numberOfAddedProductsToCart = 2;
    
@Test
    public void verifyNumberOfProductsOnProductsPage(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.basePage();
        loginPage.login(username, password);
        productsPage.verifySuccessfulLogin(expectedText);
        productsPage.NumberOfProduts(numberOfAllProducts);        
        
        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }

@Test
    public void verifySuccessfulTwoProductsAddedtoShoppingCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        YourCartPage yourCartPage = new YourCartPage(driver);
        loginPage.basePage();
        loginPage.login(username, password);
        productsPage.verifySuccessfulLogin(expectedText);
        productsPage.verifyTwoProductsAddedtoShoppingCart();
        yourCartPage.verifyTwoProductsDisplayedInShoppingCart(numberOfAddedProductsToCart);
    
        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }
}

