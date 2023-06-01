package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends pageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordbtn;
    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;
    @FindBy(id = "NewPassword")
    WebElement newPasswordText;
    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordText;
    @FindBy(xpath = "//button[contains(text(),'Change password')]")
    WebElement changePasswordBtn;
    public @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]")
    WebElement alert;


    public void changPassword(String oldPassword,String newPassword,String confirmNewPassword){

        clickButton(changePasswordbtn);
        setTextElementText(oldPasswordTxt,oldPassword);
        setTextElementText(newPasswordText,newPassword);
        setTextElementText(confirmNewPasswordText,confirmNewPassword);
        clickButton(changePasswordBtn);
    }
}
