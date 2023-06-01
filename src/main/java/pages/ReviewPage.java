package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends pageBase{
    public ReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "AddProductReview_Title")
    WebElement ProductReview_Title;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewText;
    @FindBy(id = "addproductrating_3")
    WebElement Rating;
    @FindBy(name = "add-review")
    WebElement addReviewBtn;
 public @FindBy(xpath = "//div[contains(text(),'Product review is successfully added.')]")
 WebElement ReviewSentSuccessfully;
    public void openReviewPage(String Title,String ReviewText){
        setTextElementText(ProductReview_Title,Title);
        setTextElementText(reviewText,ReviewText);
        clickButton(Rating);
        clickButton(addReviewBtn);
    }

}
