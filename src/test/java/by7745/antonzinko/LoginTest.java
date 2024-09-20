package by7745.antonzinko;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver;
    final String BASE_URL = "https://7745.by/";

    @Test
    public void testLoginWithEmptyData() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        HomePage homePage = new HomePage(driver);
        homePage.clickIconLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonEnter();
    }
}
