package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.productDetailsPage;
import pages.searchPage;

public class changeCurrencyTest extends testpase{
    Homepage homepageObject;
    searchPage searchObject;
    productDetailsPage productDetailsObject;
    String productName="Apple MacBook Pro 13-inch";
@Test
    public void UserCanChangeCurrency(){
        homepageObject=new Homepage(driver);
        homepageObject.changeCurrency();


    }
    @Test
    public void UserCanSearchWithAutoSuggest(){

        try {
            searchObject=new searchPage(driver);
            searchObject.productSearchUsingAutoSuggest("MacB");
            productDetailsObject=new productDetailsPage(driver);
            Assert.assertTrue(productDetailsObject.productNameBredCrumb.getText().equalsIgnoreCase(productName));
            Assert.assertTrue(productDetailsObject.priceProductLbl.getText().contains("€"));
            System.out.println(productDetailsObject.priceProductLbl.getText());
        }catch (Exception e){
            System.out.println("Error occurred"+e.getMessage());
        }
    }






}


