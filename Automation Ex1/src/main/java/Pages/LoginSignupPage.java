package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LoginSignupPage {
    WebDriver driver ;
    By signupTextBy = By.xpath("//*[text()='New User Signup!']");
    By signUpEmailAddressBy = By.xpath("//input[@data-qa='signup-email']");
    By signUpUserNameBy = By.xpath("//input[@data-qa='signup-name']");
    By signUpBtnBy = By.xpath("//button[text()='Signup']");
    String url = "https://automationexercise.com/login";
    By signUpTextErrorBy= By.xpath("//p[text()='Email Address already exist!']");

    By loginTextBy = By.xpath("//h2[text()='Login to your account']");
    By loginEmailAddressBy = By.xpath("//input[@data-qa='login-email']");
    By loginPasswordBy = By.xpath("//input[@type='password']");
    By loginBtnBy = By.xpath("//button[@data-qa='login-button']");
    By logoPage = By.xpath("//img[@alt='Website for automation practice']");
    public LoginSignupPage(WebDriver driver) {
        this.driver =driver;
    }
    public String getSignupText(){
       return driver.findElement(signupTextBy).getText();
    }
    public void MoveToSignupPage(String email,String userName){

        WebElement emailAddressElement = driver.findElement(signUpEmailAddressBy);
        emailAddressElement.sendKeys(email);

        WebElement nameUserElement = driver.findElement(signUpUserNameBy);
        nameUserElement.sendKeys(userName);

        WebElement signUpButtonElement = driver.findElement(signUpBtnBy);
        signUpButtonElement.click();
    }
    public void ScrollOnPage(int num){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+num+")", "");
    }
    public Boolean checkSignUpTextErrorDisplay(){
        WebElement signUpTextErrorElement = driver.findElement(signUpTextErrorBy);
        return signUpTextErrorElement.isDisplayed();
    }
    public Boolean checkLoginTextPageDisplayed(){
        WebElement loginTextElement = driver.findElement(loginTextBy);
       return loginTextElement.isDisplayed();
    }
    public void loginToAccount(String email , String password){
        WebElement emailAddressElement = driver.findElement(loginEmailAddressBy);
        emailAddressElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(loginPasswordBy);
        passwordElement.sendKeys(password);
        WebElement loginButtonElement = driver.findElement(loginBtnBy);
        loginButtonElement.click();
    }
    public Boolean getTextLoginIncorrect(){
        WebElement passwordElement = driver.findElement(loginPasswordBy);
        WebElement  textLoginErrorElement = driver.findElement(RelativeLocator.with(By.tagName("p")).below(passwordElement));
        return textLoginErrorElement.isDisplayed();

    }
    public Boolean checkLogoPageDisplayed(){

        WebElement logoElement = driver.findElement(logoPage);
        return logoElement.isDisplayed();
    }
}
