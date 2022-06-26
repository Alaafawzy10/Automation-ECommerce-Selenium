package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    WebDriver driver;
    By logPageBy = By.xpath("//img[@alt='Website for practice automation']");
    By titleMrsBy = By.xpath("//input[@id='id_gender2']");
    By passwordBy = By.xpath("//input[@id='password']");
    By daysBy = By.xpath("//select[@id='days']");
    By monthsBy = By.xpath("//select[@id='months']");
    By yearsBy = By.xpath("//select[@id='years']");
    By firstNameBy = By.xpath("//input[@id='first_name']");
    By lastNameBy = By.xpath("//input[@id='last_name']");
    By addressBy = By.xpath("//input[@data-qa='address']");
    By countryBy = By.xpath("//select[@id='country']");
    By stateBy = By.xpath("//input[@id='state']");
    By cityBy = By.xpath("//input[@id='city']");
    By zipcodeBy = By.xpath("//input[@id='zipcode']");
    By phoneBy = By.xpath("//input[@id='mobile_number']");
    By createBtnAccountBy = By.xpath("//button[@data-qa='create-account']");
    public SignupPage(WebDriver driver) {
        this.driver=driver;
    }
    public Boolean LogoDisplay(){
        WebElement logoPageElement = driver.findElement(logPageBy);
        return logoPageElement.isDisplayed();
    }
    public void selectTitleMrs(){
    WebElement titleMrsElement = driver.findElement(titleMrsBy);
        titleMrsElement.click();
    }
    public void enterPassword(String password){
        WebElement passwordElement = driver.findElement(passwordBy);
        passwordElement.sendKeys(password);
    }
    public void selectBirthDate(int days,int months, int years){
        WebElement birthDaysElement = driver.findElement(daysBy);
        Select dropdownDays = new Select(birthDaysElement);
        dropdownDays.selectByValue(String.valueOf(days));

        WebElement birthMonthsElement = driver.findElement(monthsBy);
        Select dropdownMonths = new Select(birthMonthsElement);
        dropdownMonths.selectByValue(String.valueOf(months));

        WebElement birthYearsElement = driver.findElement(yearsBy);
        Select dropDownYears = new Select(birthYearsElement);
        dropDownYears.selectByValue(String.valueOf(years));
    }
    public void scrollOnPage(int num){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+num+")", "");
    }
    public void enterFirstAndLastName(String firstName,String lastName){
        WebElement firstNameElement = driver.findElement(firstNameBy);
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = driver.findElement(lastNameBy);
        lastNameElement.sendKeys(lastName);
    }
    public void enterAddress(String address){
        WebElement addressElement = driver.findElement(addressBy);
        addressElement.sendKeys(address);
    }
    public void enterCountry(String country){
        WebElement countryElement = driver.findElement(countryBy);
        Select dropdownCountry = new Select(countryElement);
        dropdownCountry.selectByValue(country);
    }
    public void enterState(String state){
        WebElement stateElement = driver.findElement(stateBy);
        stateElement.sendKeys(state);
    }
    public void enterCity(String city){
        WebElement cityElement = driver.findElement(cityBy);
        cityElement.sendKeys(city);
    }
    public void enterZipcode(String zipcode){
        WebElement zipcodeElement = driver.findElement(zipcodeBy);
        zipcodeElement.sendKeys(zipcode);
    }
    public void enterPhone(String phone){
        WebElement phoneElement = driver.findElement(phoneBy);
        phoneElement.sendKeys(phone);
    }
    public void createAccount(){
        WebElement createAccountElement = driver.findElement(createBtnAccountBy);
        createAccountElement.click();
    }
}
