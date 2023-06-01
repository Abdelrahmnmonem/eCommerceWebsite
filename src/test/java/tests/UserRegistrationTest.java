package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;
import pages.UserRegistrationpage;


public class UserRegistrationTest extends testpase {
Homepage homeObject;
LoginPage loginObject;
UserRegistrationpage registrationObject;
String FirstName ="abdelrahman";
String LastName ="abdelmoneam";
    String email ="abdo.mene12@mail.com";
    String password ="01010064642";

@Test(priority = 1,alwaysRun = true)
public void UserCanRegestrationSuccsesfully(){
    homeObject=new Homepage( driver);
    homeObject.openregisterbage();
    registrationObject=new UserRegistrationpage(driver);
    registrationObject.UserRegistration(FirstName,LastName,email,password);
    Assert.assertTrue(registrationObject.SuccsessMessage.getText().contains("Your registration completed"));
}
@Test(dependsOnMethods ={"UserCanRegestrationSuccsesfully"} )
public void UsercanClickOnLogin(){
    registrationObject=new UserRegistrationpage(driver);
    registrationObject.ClickOnRegister();

}
@Test(dependsOnMethods ={"UsercanClickOnLogin"} )
    public void UserCanLogin(){
    loginObject=new LoginPage(driver);
    loginObject.UserLogin(email,password);
Assert.assertTrue(loginObject.logOut.getText().contains("Log out"));

}
}
