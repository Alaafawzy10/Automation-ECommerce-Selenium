import Pages.ContactUsPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class ContactUsForm {
    WebDriver driver;
    HomePage homePage;
    ContactUsPage contactUsPage;


    @Test(description = "Given I'm on the home Page and I Need to Send an Inquiry through the Contact Us Page")
    public void ContactUs() {
     homePage.MoveToContactUsPage();
     contactUsPage.fillFormFields("alaa","alaa@gamil.com","test","for test");
     contactUsPage.uploadFile("/Users/alaafawzy/Desktop/convert.jpeg");
     contactUsPage.sendTheMessage();
     contactUsPage.dealWithAlert(true);
     Assert.assertTrue(!contactUsPage.getResponseMessage().isEmpty());
    }
    @BeforeClass
    void BeforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.navigate();
        contactUsPage = new ContactUsPage(driver);
    }
    @AfterClass
    void AfterClass(){
        driver.quit();
    }
}

