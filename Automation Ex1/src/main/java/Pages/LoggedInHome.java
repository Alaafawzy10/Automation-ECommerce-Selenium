package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedInHome {
    WebDriver driver ;
    By loggedInAsBy = By.xpath("//i[@class='fa fa-user']");
    By loggedInAsNameBy = By.tagName("b");
    By deleteAccountBy = By.linkText("/delete_account");
    By logoutBtnBy = By.xpath("//a[@href='/logout']");
    By viewCartBtnBy = By.partialLinkText("Cart");
    public LoggedInHome(WebDriver driver) {
        this.driver = driver;
    }
 public LoggedInHome(){
 }
    public Boolean checkLoginDisplay(){

        WebElement loggedInAsElement = driver.findElement(loggedInAsBy);
        return loggedInAsElement.isDisplayed();
    }
    public String getLoginUserName(){
        WebElement loggedInAsNameElement = driver.findElement(loggedInAsNameBy);
        return loggedInAsNameElement.getText();
    }
    public void deleteAccount(){
        WebElement deleteAccountElement = driver.findElement(deleteAccountBy);
        deleteAccountElement.click();
    }
    public void logoutFromAccount(){
        WebElement logoutBtnElement = driver.findElement(logoutBtnBy);
        logoutBtnElement.click();
    }
    public void viewCart(){
        WebElement viewCartElement = driver.findElement(viewCartBtnBy);
        viewCartElement.click();
    }
    public WebDriver getDriver(){
        return this.driver;
    }

}
