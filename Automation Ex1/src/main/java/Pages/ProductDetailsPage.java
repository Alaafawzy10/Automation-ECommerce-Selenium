package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailsPage {
    WebDriver driver;

    By productDetailsCardBy = By.xpath("//div[@class='product-information']//*");
    By productNameBy = By.xpath("//div[@class='product-information']//h2");
    By productQuantityBy = By.id("quantity");
    By addCartBtnBy = By.xpath("//button[@type='button']");
    By viewCartBy = By.partialLinkText("View Cart");
    public ProductDetailsPage(WebDriver driver){
        this.driver=driver;
    }
    public String verifyThatCardElementsIsDisplayed(){
        List<WebElement> list = driver.findElements(productDetailsCardBy);
        String errorMessage="";
        WebElement productNameElement = driver.findElement(productNameBy);
        if(!productNameElement.isDisplayed()){
            errorMessage += productNameElement.getText()+" Not Visible";
        }

        for(WebElement element:list){
            if(element.getText().contains("Category")){
                if(!element.isDisplayed()){
                    errorMessage += element.getText()+" Not Visible";
                }
            }
            if(element.getText().contains("Rs.")){
                if(!element.isDisplayed()){
                    errorMessage += element.getText()+" Not Visible";
                }
            }
            if(element.getText().contains("Availability: ")){
                if(!element.isDisplayed()){
                    errorMessage += element.getText()+" Not Visible";
                }
            }
            if(element.getText().contains("Condition: ")){
                if(!element.isDisplayed()){
                    errorMessage += element.getText()+" Not Visible";
                }
            }
            if(element.getText().contains("Brand: ")){
                if(!element.isDisplayed()){
                    errorMessage += element.getText()+" Not Visible";
                }
            }
        }
        return errorMessage;
    }
    public void setTheQuantity(int quantity){
        WebElement productQuantityElement = driver.findElement(productQuantityBy);
        productQuantityElement.clear();
        productQuantityElement.sendKeys(Integer.toString(quantity));
    }
    public void addProductToCart(){
        WebElement addProductToCartBtnElement  = driver.findElement(addCartBtnBy);
        addProductToCartBtnElement.click();
    }
    public void viewCart(){
        WebElement viewCartElement =new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(viewCartBy));
        viewCartElement.click();
    }
}
