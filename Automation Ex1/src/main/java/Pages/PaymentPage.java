package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    WebDriver driver;
    String url  ="https://automationexercise.com/payment";
    By cardNameBy = By.xpath("//input[@name='name_on_card']");
    By cardNumberBy = By.xpath("//input[@name='card_number']");
    By cardCvcBy = By.xpath("//input[@name='cvc']");
    By cardExpirationBy = By.xpath("//input[@name='expiry_month']");
    By cardYearBy = By.xpath("//input[@name='expiry_year']");
    By submitOrderBy = By.id("submit");
    By successMessageBy = By.xpath("//div[@id='success_message']");
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigate(){
        driver.navigate().to(url);
    }
    public void setCardDetails(String name,String number ,String cvc,String expiration,String year){
        WebElement cardNameElement = driver.findElement(cardNameBy);
        cardNameElement.sendKeys(name);

        WebElement cardCvcElement = driver.findElement(cardCvcBy);
        cardCvcElement.sendKeys(cvc);

        WebElement cardNumberElement = driver.findElement(cardNumberBy);
        cardNumberElement.sendKeys(number);

        WebElement cardExpirationElement = driver.findElement(cardExpirationBy);
        cardExpirationElement.sendKeys(expiration);

        WebElement cardYearElement = driver.findElement(cardYearBy);
        cardYearElement.sendKeys(year);

    }
    public void submitOrder(){
        WebElement submitOrderElement = driver.findElement(submitOrderBy);
        submitOrderElement.click();

    }

}
