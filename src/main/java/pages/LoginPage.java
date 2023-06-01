package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
@FindBy(id = "Email")
    WebElement emailTextBox;
    @FindBy(id = "Password")
    WebElement passwordTextBox;
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;
   public @FindBy(linkText = "Log out")
    WebElement logOut;
    public void UserLogin(String email,String password){
setTextElementText(emailTextBox,email);
setTextElementText(passwordTextBox,password);
        clickButton(loginButton);
    }


}
