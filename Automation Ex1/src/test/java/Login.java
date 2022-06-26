import Pages.HomePage;
import Pages.LoggedInHome;
import Pages.LoginSignupPage;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;

public class Login {
   public WebDriver driver;
   public LoginSignupPage loginSignupPage;
   public HomePage homePage;
   public LoggedInHome loggedInHome;
   @DataProvider(name = "LoginProvider")
   public Object[][] get(Method m) throws FileNotFoundException {

       if (m.getName().equalsIgnoreCase("LoginUserWithCorrectEmailAndPassword")) {

           return getDataFromJson("TrueAccounts");
       }
       else {
           return getDataFromJson("FalseAccounts");
       }
   }
    @Test(description = "Given I'm on the home Page and I Need Login User With Correct Email And Password",dataProvider = "LoginProvider")
    public void LoginUserWithCorrectEmailAndPassword(String email, String password){

        String firstName ="alaa";

        homePage.MoveToLoginSignupPage();

        Assert.assertTrue(loginSignupPage.checkLoginTextPageDisplayed());

        loginSignupPage.loginToAccount(email,password);

        Assert.assertTrue(loggedInHome.checkLoginDisplay(),"Something Wrong And Not Logged in");

        Assert.assertEquals(firstName,loggedInHome.getLoginUserName());
        loggedInHome.logoutFromAccount();

    }
    @Test (description = "Given I'm on the home Page and I Need Login User With Incorrect Email And Password Then Check the System will deny that ",dataProvider ="LoginProvider")
    public void LoginUserWithIncorrectEmailAndPassword(String email, String password){

        homePage.MoveToLoginSignupPage();

        Assert.assertTrue(loginSignupPage.checkLoginTextPageDisplayed());

        loginSignupPage.loginToAccount(email,password);

        Assert.assertTrue(loginSignupPage.getTextLoginIncorrect(),"Not Visible");
    }

    @BeforeClass
    void BeforeClass(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationexercise.com");
        homePage = new HomePage(driver);
        loginSignupPage =new LoginSignupPage(driver);
        loggedInHome = new LoggedInHome(driver);
    }
    @AfterClass
    void AfterClass(){
        driver.quit();
    }
    public Object[][] getDataFromJson(String accountType) throws FileNotFoundException {
        FileReader fileReader = new FileReader("/Users/alaafawzy/IdeaProjects/Automation Ex1/LoginAccounts.json");

        JsonObject jsObject = (JsonObject)new JsonParser().parse(fileReader);
        JsonArray arr =jsObject.get(accountType).getAsJsonArray();
        Object [][] objectsString = new Object[arr.size()][2];
       for(int i=0;i< arr.size();i++ ){
           for (int  j=0;j<arr.get(i).getAsJsonArray().size();j++){
               objectsString[i][j]=arr.get(i).getAsJsonArray().get(j).toString().replace("\"","");
           }
       }
return objectsString;
    }
}
