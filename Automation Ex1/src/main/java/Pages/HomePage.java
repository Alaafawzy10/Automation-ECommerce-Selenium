package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver ;
    String url = "http://automationexercise.com";
    By loginSignupBy = By.xpath("//i[@class='fa fa-lock']");
    By homeLogoBy = By.xpath("//img[@alt='Website for automation practice']");
     By productsBy = By.partialLinkText(" Products");
    By contactUsBy = By.xpath("//a[text()=' Contact us']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigate(){
        driver.navigate().to(url);
    }
    public void MoveToLoginSignupPage(){
        WebElement loginSignupElement = driver.findElement(loginSignupBy);
        loginSignupElement.click();
    }
    public Boolean checkHomePageIsLoaded(){
        WebElement homeLogoElement = driver.findElement(homeLogoBy);
        return homeLogoElement.isDisplayed();
    }
    public void MoveToContactUsPage(){
        WebElement contactUsElement = driver.findElement(contactUsBy);
        contactUsElement.click();

    }
    public void MoveToProductsPage(){
        WebElement productsElement = driver.findElement(productsBy);
        productsElement.click();

    }
}
