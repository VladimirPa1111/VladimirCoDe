package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class ProductsPage extends BasePage{
    public ProductsPage (WebDriver driver){
    super(driver);
    }
    
    By productsPageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By addToCartButton1By = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    By addToCartButton2By = By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    
    By numberOfProductsBy = By.className("inventory_item");
    
    By hamburgerMenuBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");

    public ProductsPage verifySuccessfulLogin (String expectedText){
        String actualText = readText(productsPageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;    
    }
    public ProductsPage verifyTwoProductsAddedtoShoppingCart(){
        click(addToCartButton1By);
        click(addToCartButton2By);
        waitVisibility(shoppingCartBadgeBy);
        click(shoppingCartBadgeBy);
        return this;
    }
    public ProductsPage NumberOfProduts(int expectedNumberOfProducts){
        int actualNumberOfProducts = countItems(numberOfProductsBy);
        assertIntegetEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }
    public ProductsPage Logout(){
        click(hamburgerMenuBy);
        click(logoutButtonBy);
        return this;
    } 
}

