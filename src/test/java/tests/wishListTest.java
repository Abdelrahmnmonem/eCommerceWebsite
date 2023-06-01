package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.productDetailsPage;
import pages.searchPage;
import pages.wishListPage;


public class wishListTest extends testpase{
    searchPage searchObject;
    wishListPage wishListPageObject;
    productDetailsPage productDetailsObject;
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
    public void UserCanAddToWishList() {
        productDetailsObject=new productDetailsPage(driver);
        productDetailsObject.addProductToWishList();
        productDetailsObject.openWishList();
        wishListPageObject=new wishListPage(driver);
        Assert.assertTrue(wishListPageObject.productName.getText().contains(productName));
    }
    @Test(priority = 3)
    public void UserCanRemoveProductFromWishList(){
        wishListPageObject=new wishListPage(driver);
        wishListPageObject.removeProductFromWishList();
        Assert.assertTrue(wishListPageObject.removeSuccsessMessage.getText().contains("The wishlist is empty!"));

    }
}
