package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class YourCartPage extends BasePage{
    public YourCartPage (WebDriver driver){
        super(driver);   
    }

    By inventoryItemNameBy = By.className("inventory_item_name");
    
    By checkoutButtonBy = By.id("checkout");
    
    public YourCartPage verifyTwoProductsDisplayedInShoppingCart(int expectedNumberOfProducts){
        int actualNumberOfProducts = countItems(inventoryItemNameBy);
        assertIntegetEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }
    public YourCartPage clickCheckout(){
        click(checkoutButtonBy);    
        return this;
    }
}