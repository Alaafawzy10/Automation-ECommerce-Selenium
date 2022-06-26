package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    WebDriver driver;
    String url  ="https://automationexercise.com/checkout";
    By descriptionTextAreaBy = By.tagName("textarea");
    By placeOrderBy = By.partialLinkText("Place Order");
    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }


    public void setDescriptionOrder(String text){
        WebElement descriptionTextAreaElement = driver.findElement(descriptionTextAreaBy);
        descriptionTextAreaElement.clear();
        descriptionTextAreaElement.sendKeys(text);
    }
    public void placeOrder(){
        WebElement placeOrderElement = driver.findElement(placeOrderBy);
        placeOrderElement.click();
    }
    public void navigate(){
        driver.navigate().to(url);
    }
}
