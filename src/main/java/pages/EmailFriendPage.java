package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends pageBase{
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FriendEmail")
    WebElement FriendEmailText;
    @FindBy(id = "PersonalMessage")
    WebElement PersonalMessageText;
    @FindBy(xpath = "//button[contains(text(),'Send email')]")
    WebElement sendEmailBtn;
    public  @FindBy(xpath = "//div[contains(text(),'Your message has been sent.')]")
    WebElement messageNotification;
    public void sendEmailToFriend (String friendEmail,String personalMessage){
        setTextElementText(FriendEmailText,friendEmail);
        setTextElementText(PersonalMessageText,personalMessage);
        clickButton(sendEmailBtn);
    }
}
