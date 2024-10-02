package by7745.antonzinko.ui;

import by7745.antonzinko.HomePage;
import by7745.antonzinko.LaptopsPageText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputSearchTest {
    WebDriver driver;
    final String BASE_URL = "https://7745.by/";

    @Test
    public void openDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        HomePage homePage = new HomePage(driver);
        homePage.dialInputSearchAndClickButton();

        String actual = homePage.getLaptopsPageHeaderText();
        Assertions.assertEquals(LaptopsPageText.LAPTOPS_PAGE_HEADER_TEXT, actual);
    }
}
