package by7745.antonzinko.ui;

import by7745.antonzinko.pages.HomePage;
import by7745.antonzinko.LoginForm;
import by7745.antonzinko.LoginFormText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver;
    final String BASE_URL = "https://7745.by/";

    @Test
    public void openDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        HomePage homePage = new HomePage(driver);
        homePage.clickIconLogin();

        LoginForm loginPage = new LoginForm(driver);
        loginPage.clickButtonEnter();

        String actual = loginPage.getLoginPageHeaderText();
        Assertions.assertEquals(LoginFormText.LOGIN_PAGE_HEADER_TEXT, actual);
    }
}
