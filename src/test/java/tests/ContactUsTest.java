package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.contactUsPage;

public class ContactUsTest extends testpase{
    Homepage homePageObject;
    contactUsPage contactObject;
    String email="abdo@123.com";
    String fullName="abdelrahman abdelmoneam";
    String Enquiry="hello admin, this for test";
    @Test
    public void userCanUsContactus(){
        homePageObject=new Homepage(driver);
        homePageObject.openContactUsPage();
        contactObject=new contactUsPage(driver);
        contactObject.contactUs(fullName,email,Enquiry);
        Assert.assertTrue(contactObject.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
    }
}
