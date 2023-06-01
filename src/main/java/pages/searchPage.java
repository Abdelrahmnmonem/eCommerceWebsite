package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class searchPage extends pageBase{
    public searchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchTextBox;
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement searchBtn;
    @FindBy(id = "ui-id-1")
    List<WebElement> productList;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitle;
    public void productSearch(String productName){
setTextElementText(searchTextBox,productName);
clickButton(searchBtn);

    }
    public void openProductDetailsPage(){
        clickButton(productTitle);
    }
    public void productSearchUsingAutoSuggest(String searchText){
        setTextElementText(searchTextBox,searchText);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productList.get(0).click();

    }

}
