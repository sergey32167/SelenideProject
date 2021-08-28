package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage_PF {
    private final static String endpoint = "/";

    @FindBy(how = How.ID, using = "user-name")
    private SelenideElement username;

    @FindBy(how = How.ID, using = "login-button")
    private SelenideElement loginBtn;

    @FindBy(how = How.ID, using = "password")
    private SelenideElement password;

    @FindBy(how = How.CSS, using = ".error-message-container.error h3")
    private SelenideElement errorMassage;

    // Атомарные методы
    public LoginPage_PF setUsername(String username) {
        this.username.sendKeys(username);
        return this;
    }

    public LoginPage_PF setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public LoginPage_PF loginBtnClick() {
        this.loginBtn.click();
        return this;
    }

    public ProductsPage successLoginBtnClick() {
        loginBtnClick();
        return new ProductsPage();
    }

}

