package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LoginPage_PF;
import pages.ProductsPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Listeners(SoftAsserts.class)
public class FirstTest extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;
    LoginPage_PF loginPage_pf;

    @Test
    public void firstSelenideTest() {
//        Настройка slf4j
//        org.apache.log4j.BasicConfigurator.configure();
//        Logger logger = LoggerFactory.getLogger(FirstTest.class);

        open("/");

        SelenideElement element = $(By.id("user-name"));
        element.sendKeys("standard_user");
//        logger.debug(element.getTagName());

        $(By.id("password")).sendKeys("secret_sauce");
        $(By.id("login-button")).click();

        $(".title")
                .should(exist)  // должен существовать
                .shouldBe(visible) //должен быть видемый
                .shouldNotHave(text("Products")); // должен иметь текст

        $$(".inventory_item_name")
                .shouldHave(CollectionCondition.size(6))
                .exclude(exactText(""))  // исключает текст
                .findBy(text("Sauce Labs Bolt T-Shirt"))
                .click();
//        SelenideElement inventoryList = $(".inventory_list");
//        ElementsCollection list = inventoryList.findAll(".inventory_item_name");
//        list
//                .shouldHave(CollectionCondition.size(6))
//                .findBy(text("Sauce Labs Bolt T-Shirt"))
//                .should(exist);

        $(".inventory_details_back_button")
                .should(exist)
                .shouldBe(visible);

        String text = $(".inventory_details_desc").getText();

        $(".product_sort_container")
                .selectOptionByValue("za");

    }

    @Test
    public void secondSelenideTest(){
        loginPage = open("/",LoginPage.class);
        loginPage.setUsername("standard_user")
                .setPassword("secret_sauce");
        productsPage = loginPage.successLoginBtnClick();


    }

    @Test
    public void thirdSelenideTest(){
        loginPage_pf = open("/",LoginPage_PF.class);
        loginPage_pf.setUsername("standard_user")
                .setPassword("secret_sauce");
        productsPage = loginPage_pf.successLoginBtnClick();


    }
}
