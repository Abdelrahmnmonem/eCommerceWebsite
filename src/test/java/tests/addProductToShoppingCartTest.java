package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.productDetailsPage;
import pages.searchPage;
import pages.shoppingCartPage;

public class addProductToShoppingCartTest extends testpase{
    searchPage searchObject;
    productDetailsPage productDetailsObject;
    shoppingCartPage shoppingCartPageObject;
    String productName="Apple MacBook Pro 13-inch";
    @Test(priority = 1)
    public void UserCanSearchWithAutoSuggest(){

        try {
            searchObject=new searchPage(driver);
            searchObject.productSearchUsingAutoSuggest("MacB");
            productDetailsObject=new productDetailsPage(driver);
            Assert.assertTrue(productDetailsObject.productNameBredCrumb.getText().equalsIgnoreCase(productName));
        }catch (Exception e){
            System.out.println("Error occurred"+e.getMessage());
        }
    }
    @Test(priority = 2)
    public void userCanAddToShoppingCart(){
        productDetailsObject=new productDetailsPage(driver);
        productDetailsObject.addToCart();
    }
    @Test(priority = 3)
    public void openCartPage(){

        productDetailsObject=new productDetailsPage(driver);
        productDetailsObject.openShoppingCart();

    }
    @Test(priority = 4)
    public void userCanRemoveFromProductCart(){
        shoppingCartPageObject=new shoppingCartPage(driver);
        shoppingCartPageObject.removeFromCart();
        Assert.assertTrue(shoppingCartPageObject.successremove.getText().contains("Your Shopping Cart is empty!"));
    }

}
