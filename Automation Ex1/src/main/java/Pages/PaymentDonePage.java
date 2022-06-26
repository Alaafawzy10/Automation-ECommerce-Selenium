package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class PaymentDonePage {
    WebDriver driver ;
    By continueBy = By.partialLinkText("Continue");
    By downloadInvoiceBy = By.partialLinkText("Download Invoice");
    By logoutBtnBy = By.xpath("//a[@href='/logout']");
    public PaymentDonePage(WebDriver driver) {
        this.driver = driver;
    }

    public void continueShopping(){
        WebElement continueElement = driver.findElement(continueBy);
        continueElement.click();
    }

    public void downloadInvoice(){
        WebElement downloadInvoiceElement = driver.findElement(downloadInvoiceBy);
        downloadInvoiceElement.click();
    }

    public void logoutFromAccount(){
        WebElement logoutBtnElement = driver.findElement(logoutBtnBy);
        logoutBtnElement.click();
    }
    public  Boolean downloadInvoiceIsDone (String fileName){
        File f = new File("/Users/alaafawzy/Downloads/" + fileName);
        return f.exists();
    }


}
