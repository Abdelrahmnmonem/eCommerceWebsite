package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class wishListPage extends pageBase{
    public wishListPage(WebDriver driver) {
        super(driver);
    }
  public   @FindBy(xpath = "//a[contains(text(),'Apple MacBook Pro 13-inch')]")
    WebElement productName;
    @FindBy(xpath = "//tbody/tr[1]/td[8]")
    WebElement removeFromWishCartBtn;
   public @FindBy(xpath = "//div[contains(text(),'The wishlist is empty!')]")
    WebElement removeSuccsessMessage;
    public void removeProductFromWishList(){
        clickButton(removeFromWishCartBtn);
    }
}
