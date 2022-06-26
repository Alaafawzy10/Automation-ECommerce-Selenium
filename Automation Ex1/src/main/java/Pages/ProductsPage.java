package Pages;

import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.Attribute;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductsPage {
    WebDriver driver ;
    String url = "https://automationexercise.com/products";
    By allProductsTitle = By.xpath("//h2[text()='All Products']");
    By viewDetailsProductsListBtnBy = By.xpath("//i[@class='fa fa-plus-square']");
    By productsBy = By.xpath("//a[text()='Add to cart']");
    By continueShoppingBy = By.xpath("//button[text()='Continue Shopping']");
    By viewCartBy = By.partialLinkText("View Cart");
    By logoutBtnBy = By.xpath("//a[@href='/logout']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;

    }
    public Boolean checkProductsPageIsLoaded(){
        WebElement homeLogoElement = driver.findElement(allProductsTitle);
        return homeLogoElement.isDisplayed();
    }
    public List<WebElement>getAllViewDetailsButtonProducts(){
      List <WebElement> allViewDetailsBtnProductsListElements = driver.findElements(viewDetailsProductsListBtnBy);
      return allViewDetailsBtnProductsListElements;
    }
    public void MoveToSpecificDetailsViewPageProduct(int index){
        List <WebElement> allViewDetailsBtnProductsListElements = getAllViewDetailsButtonProducts();
        allViewDetailsBtnProductsListElements.get(--index).click();
    }
    public void addProductToCart(int index){
      List<WebElement> testProduct = driver.findElements(productsBy);
     --index;
      testProduct.get((index*2)).click();
    }
    public void continueShopping(){
        WebElement continueShoppingElement =new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(continueShoppingBy));
       continueShoppingElement.click();
    }
    public void viewCart(){
        WebElement viewCartElement =new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(viewCartBy));
        viewCartElement.click();
    }
    public void logoutFromAccount(){
        WebElement logoutBtnElement = driver.findElement(logoutBtnBy);
        logoutBtnElement.click();
    }
    public void navigate(){
        driver.navigate().to(url);
    }

}
