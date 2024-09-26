package by7745.antonzinko;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIconLogin() {
        By iconLoginBy = By.xpath(HomePageXPath.ICON_LOGIN_XPATH);
        WebElement iconLogin = driver.findElement(iconLoginBy);
        iconLogin.click();
    }
}
