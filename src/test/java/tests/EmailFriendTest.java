package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends testpase {
    //user can register and login
    Homepage homeObject;
    LoginPage loginObject;
    UserRegistrationpage registrationObject;
    searchPage searchObject;
    productDetailsPage productDetailsObject;
    EmailFriendPage emailFriendPageObject;
    String productName = "Apple MacBook Pro 13-inch";
    String FirstName = "abdelrahman";
    String LastName = "abdelmoneam";
    String email = "abdo.mene122@mail.com";
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
    // email To friend
    @Test(dependsOnMethods = {"UserCanSearchWithAutoSuggest"})
public void registerUserCanSendProductToFriend(){
    productDetailsObject.openEmailFriend();
    emailFriendPageObject=new EmailFriendPage(driver);
    emailFriendPageObject.sendEmailToFriend("ali@mail.com","this product is very good");
    Assert.assertTrue(emailFriendPageObject.messageNotification.getText().contains("Your message has been sent."));
}
}
