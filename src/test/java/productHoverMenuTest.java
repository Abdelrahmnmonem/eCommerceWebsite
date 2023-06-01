
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import tests.testpase;

public class productHoverMenuTest extends testpase {
    Homepage HomepageObject;
    @Test
    public void UserCanSelectProductFromMenu(){
        HomepageObject=new Homepage(driver);
        HomepageObject.selectNoteBookMenu();
        Assert.assertTrue(HomepageObject.notBookSuccess.getText().contains("Notebooks"));


    }
}
