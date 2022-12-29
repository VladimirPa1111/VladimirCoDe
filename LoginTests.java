package tests;

import org.junit.Test;
import pages.LoginPage;
import pages.ProductsPage;

    public class LoginTests extends BaseTest{
    public LoginPage loginPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";

    String lockedOutUser = "locked_out_user";
    String lockedOutUserErrorText = "Epic sadface: Sorry, this user has been locked out.";

    String badUsername = "wrong";
    String badUsernamePasswordErrorText = "Epic sadface: Username and password do not match any user in this service";

    String badPassword = "wrong";

@Test    
    public void navigateToBaseUrl(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
                
        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }

@Test    
    public void verifySuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.basePage();
        loginPage.login(username, password);
        productsPage.verifySuccessfulLogin(expectedText);

        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }

@Test    
    public void verifyUnsuccessfulLoginWithLockedOutUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(lockedOutUser, password);
        loginPage.verifyUnsuccessfulLogin(lockedOutUserErrorText);

        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }

@Test    
    public void verifyUnsuccessfulLoginWithBadUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(badUsername, password);
        loginPage.verifyUnsuccessfulLogin(badUsernamePasswordErrorText);

        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }

@Test    
    public void verifyUnsuccessfulLoginWithBadPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(username, badPassword);
        loginPage.verifyUnsuccessfulLogin(badUsernamePasswordErrorText);

        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }

@Test    
    public void verifyLogout(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.basePage();
        loginPage.login(username, password);
        productsPage.verifySuccessfulLogin(expectedText);
        productsPage.Logout();

        try{
            Thread.sleep(5000);
            }
        catch(InterruptedException e){
            e.printStackTrace();
        }    
    }
}
