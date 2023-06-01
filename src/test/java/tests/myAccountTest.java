package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationpage;

public class myAccountTest extends testpase{
    Homepage homeObject;
    LoginPage loginObject;
    UserRegistrationpage registrationObject;
    MyAccountPage myAccountObject;
    String oldPassword= "01010064642";
    String newPassword= "abdo01010064642";
    String firstname="abdelrahman";
    String lastname="abdelmoneam";
    String email="abdo233@gmail.com";
    @Test(priority = 1)
    public void UserCanRegestrationSuccsesfully(){
        homeObject=new Homepage( driver);
        homeObject.openregisterbage();
        registrationObject=new UserRegistrationpage(driver);
        registrationObject.UserRegistration(firstname,lastname,email,oldPassword);
        Assert.assertTrue(registrationObject.SuccsessMessage.getText().contains("Your registration completed"));
    }
    @Test(priority = 2)
    public void UsercanClickOnLogin(){
        registrationObject=new UserRegistrationpage(driver);
        registrationObject.ClickOnRegister();

    }
    @Test(priority = 3)
    public void UserCanLogin(){
        loginObject=new LoginPage(driver);
        loginObject.UserLogin(email,oldPassword);
        Assert.assertTrue(loginObject.logOut.getText().contains("Log out"));
    }
    @Test(priority = 4)
    public void RegisterUserCanChangePassword(){
        registrationObject.ClickOnMyAccount();
        myAccountObject=new MyAccountPage(driver);

        myAccountObject.changPassword(oldPassword,newPassword,newPassword);
        Assert.assertTrue(myAccountObject.alert.getText().contains("Password was changed"));


    }
}
