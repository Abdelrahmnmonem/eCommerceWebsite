package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contactUsPage extends pageBase{
    public contactUsPage(WebDriver driver) {
        super(driver);
    }
@FindBy(id = "FullName")
    WebElement FullNameText;
    @FindBy(id = "Email")
    WebElement EmailText;
    @FindBy(id = "Enquiry")
    WebElement EnquiryText;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitBtn;
  public   @FindBy(xpath = "//div[contains(text(),'Your enquiry has been successfully sent to the sto')]")
    WebElement successMessage;
    public void contactUs(String fullName, String Email ,String Enquiry){
        setTextElementText(FullNameText,fullName);
        setTextElementText(EmailText,Email);
        setTextElementText(EnquiryText,Enquiry);
        clickButton(submitBtn);
    }

}
