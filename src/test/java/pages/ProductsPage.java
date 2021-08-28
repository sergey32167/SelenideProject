package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private final static String endpoint = "/inventory.html";

    private final static By shoppingCartBtnSelector = By.id("shopping_cart_container");
    private final static String item_Add_To_Cart_Button = "//div[.='replace']/ancestor::div[@class= 'inventory_item_description']//button";
    private final static By productsTitle_By = By.xpath("//span[. = 'Products']");

    private SelenideElement getItemAddToCartButton(String productName) {
        return $(item_Add_To_Cart_Button.replace("replace", productName));
    }

    private SelenideElement getCartBadge() {
        return $(shoppingCartBtnSelector);
    }

    private SelenideElement getProductsTitle() {
        return $(productsTitle_By);
    }


    // Атомарные методы
    public ProductsPage addItemToCart(String productName) {
        getItemAddToCartButton(productName).click();
        return this;
    }

    public ProductsPage addItemsToCart(List<String> itemsList) {
        for (String item : itemsList) {
            getItemAddToCartButton(item).click();
        }
        return this;
    }
}

