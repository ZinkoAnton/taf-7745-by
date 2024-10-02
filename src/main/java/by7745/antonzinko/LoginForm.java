package by7745.antonzinko;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm {
    WebDriver driver;

    public LoginForm(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonEnter() {
        By buttonEnterBy = By.xpath(LoginFormXPath.BUTTON_ENTER_XPATH);
        WebElement buttonEnter = driver.findElement(buttonEnterBy);
        buttonEnter.click();
    }

    public void dialInputLogin(String email) {
        By inputLoginBy = By.xpath(LoginFormXPath.INPUT_LOGIN_XPATH);
        WebElement inputLogin = driver.findElement(inputLoginBy);
        inputLogin.sendKeys(email);
    }

    public void dialInputPassword(String password) {
        By inputPasswordBy = By.xpath(LoginFormXPath.INPUT_PASSWORD_XPATH);
        WebElement inputPassword = driver.findElement(inputPasswordBy);
        inputPassword.sendKeys(password);
    }

    public String getLoginPageHeaderText() {
        WebElement loginPageHeaderText = driver.findElement(By.xpath(LoginFormText.LOGIN_PAGE_HEADER_PATH));
        String actual = loginPageHeaderText.getText();
        return actual;
    }
}

