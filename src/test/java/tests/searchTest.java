package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.productDetailsPage;
import pages.searchPage;

public class searchTest extends testpase{
    searchPage searchObject;
    productDetailsPage productDetailsObject;
   String productName="Apple MacBook Pro 13-inch";
    @Test
    public void UserCanSearchForProduct(){
searchObject=new searchPage(driver);
        productDetailsObject=new productDetailsPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
        Assert.assertTrue(productDetailsObject.productNameBredCrumb.getText().equalsIgnoreCase(productName));
    }
}
