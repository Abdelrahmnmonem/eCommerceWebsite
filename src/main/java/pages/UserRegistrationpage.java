package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationpage extends pageBase{
    public UserRegistrationpage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "gender-male")
    WebElement genderRdoBTN;
    @FindBy(id = "FirstName")
    WebElement fnTextBox;
    @FindBy(id = "LastName")
    WebElement lnTextBox;
    @FindBy(id = "Email")
    WebElement emailTextBox;
    @FindBy(id = "Password")
    WebElement passwordTextBox;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmBasswordTextBox;
    @FindBy(id = "register-button")
    WebElement registerBtn;
    @FindBy(css =" div.result")
    public WebElement  SuccsessMessage;
    @FindBy(linkText = "Log in")
    WebElement RegisterLogin;
    @FindBy(linkText = "My account")
    WebElement OpenMyAccount;

    public void UserRegistration(String firstname,String lastname,String email,String password){
        clickButton(genderRdoBTN);
       setTextElementText(fnTextBox,firstname);
        setTextElementText(lnTextBox,lastname);
        setTextElementText(emailTextBox,email);
        setTextElementText(passwordTextBox,password);
        setTextElementText(confirmBasswordTextBox,password);
        clickButton(registerBtn);

    }
    public void ClickOnRegister(){
        clickButton(RegisterLogin);
    }


public void ClickOnMyAccount(){
clickButton(OpenMyAccount);
}
}
