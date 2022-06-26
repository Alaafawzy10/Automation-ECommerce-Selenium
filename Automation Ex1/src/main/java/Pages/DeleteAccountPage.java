package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteAccountPage {
    WebDriver driver ;
    By verifyDeleteAccountBy = By.xpath("//button[@class='btn btn-danger']");
    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyDeleteAccount(){
        WebElement verifyDeleteAccountElement = driver.findElement(verifyDeleteAccountBy);
        verifyDeleteAccountElement.click();
    }
}
