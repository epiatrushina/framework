package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

import java.util.Arrays;
import java.util.List;

public class SearchTests extends CommonConditions{
    @Test
    public void sendCityToSearchInput() {
        String url = "https://bukvaeshka.by/";

        List<String> actualSearchResults = new MainPage(driver, url)
                .openPage()
                .waitForInputDropdownList("Минск")
                .getInputSuggestions();

        List<String> expectedSearchResults = Arrays.asList(
                "Минск",
                "Минская область",
                "Минская область, Минский район"
        );

        Assert.assertEquals(actualSearchResults, expectedSearchResults);
    }
}
