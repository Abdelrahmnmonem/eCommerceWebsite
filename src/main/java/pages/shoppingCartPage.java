package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shoppingCartPage extends pageBase{
    public shoppingCartPage(WebDriver driver) {
        super(driver);
    }
@FindBy(xpath = "//input[@id='itemquantity11261']")
    WebElement quantityTex;
    @FindBy(id = "updatecart")
    WebElement updateBtn;
    @FindBy(xpath = "//tbody/tr[1]/td[7]/button[1]")
    WebElement removeBtn;
  public   @FindBy(xpath = "//div[contains(text(),'Your Shopping Cart is empty!')]")
    WebElement successremove;
    public void removeFromCart(){
        clickButton(removeBtn);
    }
    public void updateProductQuantityInCart(String quantity){
        clearText(quantityTex);
        setTextElementText(quantityTex,quantity);
        clickButton(updateBtn);
    }
    
}
