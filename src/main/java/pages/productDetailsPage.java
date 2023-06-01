package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productDetailsPage extends pageBase{
    public productDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//strong[contains(text(),'Apple MacBook Pro 13-inch')]")
    public WebElement productNameBredCrumb;
    @FindBy(xpath = "//button[contains(text(),'Email a friend')]")
    WebElement emailFriendBtn;
    @FindBy(linkText = "Add your review")
    WebElement AddYourReviewBtn;
    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishListBtn;
    @FindBy(linkText = "Wishlist")
    WebElement openWishList;
    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartBtn;
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement ShoppingCartPage;
  public  @FindBy(xpath = "//span[@id='price-value-4']")
    WebElement priceProductLbl;
 @FindBy (id = "termsofservice")
 WebElement agreeCheckBox;
 @FindBy(id = "checkout")
 WebElement checkOutBtn;
    public void openEmailFriend(){
        clickButton(emailFriendBtn);
    }
    public void openReviewPage(){
        clickButton(AddYourReviewBtn);
    }
public void addProductToWishList(){
        clickButton(addToWishListBtn);
}
    public void openWishList(){
        clickButton(openWishList);
    }
    public void addToCart(){
        clickButton(addToCartBtn);
    }
    public void openShoppingCart(){
        clickButton(ShoppingCartPage);
    }
    public void OpenCheckBoxPage(){
        clickButton(agreeCheckBox);
        clickButton(checkOutBtn);
    }

}
