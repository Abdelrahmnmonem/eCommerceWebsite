package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Homepage extends pageBase {


    public Homepage(WebDriver driver) {
        super(driver);
        jse=(JavascriptExecutor) driver;
        action=new Actions(driver);
    }
@FindBy(linkText = "Register")
    WebElement registerlink;
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;
    @FindBy(id = "customerCurrency")
    WebElement currencydl1;
    @FindBy(linkText = "Computers")
    WebElement computerMenu;
    @FindBy(linkText = "Notebooks")
    WebElement noteBookMenu;
  public   @FindBy(xpath = "//h1[contains(text(),'Notebooks')]")
    WebElement notBookSuccess;





    public void openregisterbage(){

        clickButton(registerlink);
    }
    public void openLoginPage(){
        clickButton(loginLink);
    }
    public void openContactUsPage(){
scrollToBottom();
        clickButton(contactUsLink);
    }
    public void changeCurrency(){
        select =new Select(currencydl1);
        select.selectByIndex(1);
    }
    public void selectNoteBookMenu(){
       action.moveToElement(computerMenu).click().build().perform();
       action.moveToElement(noteBookMenu).click().click().build().perform();
    }
}
