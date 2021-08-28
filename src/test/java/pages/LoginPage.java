package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final static String endpoint = "/";

    private final static By passwordSelector = By.id("password");
    private final static By loginBtnSelector = By.id("login-button");
    private final static By errorMessageSelector = By.cssSelector(".error-message-container.error h3");

    public SelenideElement getUsernameField() { return $(By.id("user-name"));}

    public SelenideElement getPasswordField() {
        return $(passwordSelector);
    }

    public SelenideElement getLoginButton() {
        return $(loginBtnSelector);
    }

    public SelenideElement getErrorMessage() {
        return $(errorMessageSelector);
    }

    // Атомарные методы
    public LoginPage setUsername(String username) {
        getUsernameField().sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPage loginBtnClick() {
        getLoginButton().click();
        return this;
    }


    public ProductsPage successLoginBtnClick() {
        loginBtnClick();
        return new ProductsPage();
    }

}

