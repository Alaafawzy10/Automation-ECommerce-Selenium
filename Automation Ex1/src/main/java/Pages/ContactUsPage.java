package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ContactUsPage {
    WebDriver driver;
By nameBy = By.xpath("//input[@name='name']");
By emailBy = By.xpath("//input[@name='email']");
By subjectBy = By.xpath("//input[@name='subject']");
By messageBy = By.id("message");
By uploadFileBy = By.xpath("//input[@name='upload_file']");
By responseMessageBy = By.xpath("//div[@class='status alert alert-success']");
public ContactUsPage(WebDriver driver){
    this.driver=driver;
}
public void fillFormFields(String name, String email,String subject,String message){
    WebElement nameElement = driver.findElement(nameBy);
    nameElement.sendKeys(name);

    WebElement emailElement = driver.findElement(emailBy);
    emailElement.sendKeys(email);

    WebElement subjectElement = driver.findElement(subjectBy);
    subjectElement.sendKeys(subject);

    WebElement messageElement = driver.findElement(messageBy);
    messageElement.sendKeys(message);
}
public void uploadFile(String filePath) {
    WebElement uploadFileElement = driver.findElement(uploadFileBy);
    uploadFileElement.sendKeys(filePath);
}
public void sendTheMessage() {
    WebElement submitElement = driver.findElement(RelativeLocator.with(By.name("submit")).below(uploadFileBy));
   submitElement.click();
}
public void dealWithAlert(Boolean alertAction){
    if(alertAction) driver.switchTo().alert().accept();
    else driver.switchTo().alert().dismiss();
}
public String getResponseMessage(){
    WebElement responseElement = driver.findElement(responseMessageBy);
    return responseElement.getText();
}
}
