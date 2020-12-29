package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BookPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NonfictionChoiceTests extends CommonConditions{
    @Test
    public void chooseNonfictionFromAllBooksMenusTest() {
        String url = "https://bukvaeshka.by/catalog/knigi/nekhudozhestvennaya_literatura/";

        List<WebElement> actualNonfiction = new BookPage(driver, url)
                .openPage()
                .clickOnNonfictionsLink()
                .getFirstFiveNonfictions();

        List<String> expectedNonfictionNames = Arrays.asList(
                "#1 Таро Евы",
                "#2 Искусство и восприятие. Биология зрения",
                "#3 Готовим блюда из любимых корейских дорам. Понравьтесь маме вашего биаса!",
                "#4 Wu-Tang Clan. Путь Дао",
                "#5 Энциклопедия кристаллов"
        );

        Assert.assertEquals(actualNonfiction.stream().map(WebElement::getText).collect(Collectors.toList()), expectedNonfictionNames);
    }
}
