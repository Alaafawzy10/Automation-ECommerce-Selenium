import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationUser {
    public WebDriver driver;
    HomePage homePage;
    LoginSignupPage loginSignupPage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    LoggedInHome loggedInHome;
    DeleteAccountPage deleteAccountPage;

    @Test (description = "Given I'm on the home Page and I Need Register A New User")
    void RegisterNewUser(){

        homePage.navigate();
        homePage.MoveToLoginSignupPage();

        Assert.assertFalse(loginSignupPage.getSignupText().isEmpty());
        loginSignupPage.ScrollOnPage(350);
        loginSignupPage.MoveToSignupPage("xlal489@gmail.com","alaa");
        signupPage.selectTitleMrs();
        signupPage.enterPassword("101010A");

        signupPage.selectBirthDate(10,10,1998);

        signupPage.scrollOnPage(150);

        signupPage.enterFirstAndLastName("alaa","fawzy");

        signupPage.enterAddress("st");
        signupPage.scrollOnPage(100);
        signupPage.enterCountry("Canada");

        signupPage.enterState("Egypt");

        signupPage.enterCity("cairo");
        signupPage.enterZipcode("11528");
        signupPage.enterPhone("01026103126");
        signupPage.scrollOnPage(150);
        signupPage.createAccount();

        Assert.assertTrue(accountCreatedPage.DisplayTextPage());

        accountCreatedPage.continueAndMoveToHome();

        Assert.assertTrue(loggedInHome.checkLoginDisplay());

        Assert.assertEquals("alaa",loggedInHome.getLoginUserName());


        loggedInHome.logoutFromAccount();
    }

 @Test  (description = "Given I'm on the home Page and I Need Register A New User With Exist Email")
 public void  RegisterUserWithExistingEmail(){
     homePage.MoveToLoginSignupPage();
     Assert.assertFalse(loginSignupPage.getSignupText().isEmpty());
     loginSignupPage.ScrollOnPage(350);
     loginSignupPage.MoveToSignupPage("lolmahmoud489@gmail.com","alaa");
     Assert.assertTrue(!loginSignupPage.getSignupText().isEmpty());
     Assert.assertTrue(loginSignupPage.checkSignUpTextErrorDisplay());

 }
    @BeforeClass
    void BeforeClass(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        homePage =new HomePage(driver);
        homePage.navigate();
        loginSignupPage = new LoginSignupPage(driver);
        signupPage =new SignupPage(driver);
        accountCreatedPage =new AccountCreatedPage(driver);
        loggedInHome = new LoggedInHome(driver);
        deleteAccountPage = new DeleteAccountPage(driver);

    }
    @AfterClass
    void AfterClass(){
        driver.quit();
    }
}
