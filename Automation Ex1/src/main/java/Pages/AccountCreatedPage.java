package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage {
    WebDriver driver;
    By accountCreatedBy = By.xpath("//b[text()='Account Created!']");
    By continueBy = By.xpath("//a[@data-qa='continue-button']");
    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }
    public Boolean DisplayTextPage(){
        WebElement accountCreatedElement = driver.findElement(accountCreatedBy);
       return accountCreatedElement.isDisplayed();
    }
    public void continueAndMoveToHome(){
        WebElement continueElement = driver.findElement(continueBy);
        continueElement.click();
    }
}
