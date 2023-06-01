package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class addProductReviewTest extends testpase{
    Homepage homeObject;
    LoginPage loginObject;
    UserRegistrationpage registrationObject;
    searchPage searchObject;
    productDetailsPage productDetailsObject;
    ReviewPage reviewPageObject;


    String productName = "Apple MacBook Pro 13-inch";
    String FirstName = "abdelrahman";
    String LastName = "abdelmoneam";
    String email = "abdo.mene1221@mail.com";
    String password = "01010064642";

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegestrationSuccsesfully() {
        homeObject = new Homepage(driver);
        homeObject.openregisterbage();
        registrationObject = new UserRegistrationpage(driver);
        registrationObject.UserRegistration(FirstName, LastName, email, password);
        Assert.assertTrue(registrationObject.SuccsessMessage.getText().contains("Your registration completed"));
    }

    @Test(dependsOnMethods = {"UserCanRegestrationSuccsesfully"})
    public void UsercanClickOnLogin() {
        registrationObject = new UserRegistrationpage(driver);
        registrationObject.ClickOnRegister();

    }

    @Test(dependsOnMethods = {"UsercanClickOnLogin"})
    public void UserCanLogin() {
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, password);
        Assert.assertTrue(loginObject.logOut.getText().contains("Log out"));
    }

    //user can search for the product
    @Test(dependsOnMethods = {"UserCanLogin"})
    public void UserCanSearchWithAutoSuggest() {

        try {
            searchObject = new searchPage(driver);
            searchObject.productSearchUsingAutoSuggest("MacB");
            productDetailsObject = new productDetailsPage(driver);
            Assert.assertTrue(productDetailsObject.productNameBredCrumb.getText().equalsIgnoreCase(productName));
        } catch (Exception e) {
            System.out.println("Error occurred" + e.getMessage());
        }
}
    @Test(dependsOnMethods = {"UserCanSearchWithAutoSuggest"})
    public void UserCanReviewProduct(){
        productDetailsObject=new productDetailsPage(driver);
        productDetailsObject.openReviewPage();
        reviewPageObject=new ReviewPage(driver);
        reviewPageObject.openReviewPage("ReviewMac","this product is very good");
        Assert.assertTrue(reviewPageObject.ReviewSentSuccessfully.getText().contains("Product review is successfully added."));
        System.out.println(reviewPageObject.ReviewSentSuccessfully.getText());

    }

}
