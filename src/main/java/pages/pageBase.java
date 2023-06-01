package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageBase {
   public JavascriptExecutor jse;
   public Actions action;
   public Select select;
    protected WebDriver driver;
    public pageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    protected static void clickButton(WebElement button){
        button.click();

    }
    protected static void setTextElementText(WebElement sendText,String value){
        sendText.sendKeys(value);

    }
    public void scrollToBottom(){

jse.executeScript("scrollBy(0,2500)");
    }
    public void clearText(WebElement element){
        element.clear();
    }
}
