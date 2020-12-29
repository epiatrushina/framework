package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

public class BookChoiceTests extends CommonConditions{
    @Test
    public void chooseBookTest() {
        String url = "https://bukvaeshka.by/";

        WebElement keywordsMetaTag = new MainPage(driver, url)
                .openPage()
                .clickOnLinkToBookPage("Книги")
                .getKeywordsMetaTag();

        Assert.assertTrue(keywordsMetaTag.getAttribute("content").contains("Книги"));
    }
}
