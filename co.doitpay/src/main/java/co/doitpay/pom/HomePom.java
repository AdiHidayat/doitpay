package co.doitpay.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.doitpay.cons.Cons;

public class HomePom 
{
	WebDriver driver;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(id = "shopping_cart_container")
    WebElement cartLink;

    public HomePom(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Cons.TIME_OUT));
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addBtn.click();
    }

    public void goToCart() {
        cartLink.click();
    }

}
