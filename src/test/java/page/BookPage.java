package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PageUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BookPage extends AbstractPage{
    @FindBy(id = "a-lnk-nonfiction_127000")
    private WebElement nonfictionsLink;

    @FindBy(xpath = "//div[@class='fl prod-content']/a[contains(@keywords, 'Закуски')]")
    private List<WebElement> nonfictionsList;

    public BookPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public BookPage openPage() {
        driver.get(url);
        return this;
    }

    public BookPage clickOnNonfictionsLink() {
        PageUtils.clickOnElement(javascriptExecutor, nonfictionsLink);

        logger.info("clicked on nonfiction link");
        return this;
    }

    public List<WebElement> getFirstFiveNonfictions() {
        return nonfictionsList.stream().limit(5).collect(Collectors.toList());
    }
}
