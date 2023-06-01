package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.productDetailsPage;
import pages.searchPage;

public class SearchProductUsingAutoSuggest extends testpase{

    searchPage searchObject;
    productDetailsPage productDetailsObject;
    String productName="Apple MacBook Pro 13-inch";
    @Test
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
}
