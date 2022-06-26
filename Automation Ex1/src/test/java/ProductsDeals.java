import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductsDeals {
    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    ViewCartPage viewCartPage;
    LoginSignupPage loginSignupPage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    LoggedInHome loggedInHome;
    CheckOutPage checkOutPage;
    PaymentPage paymentPage;
    PaymentDonePage paymentDonePage;

    @Test(description = "Given I'm on the home Page and I Need to Navigate to All Products Page ," +
            " Then I Need To view the Details of the first product and Check that the details is displayed")
    public void VerifyAllProductsAndProductDetailPage() {
        homePage.navigate();
        Assert.assertTrue(homePage.checkHomePageIsLoaded());
        homePage.MoveToProductsPage();
        Assert.assertTrue(productsPage.checkProductsPageIsLoaded());
        productsPage.MoveToSpecificDetailsViewPageProduct(1);
        Assert.assertEquals(productDetailsPage.verifyThatCardElementsIsDisplayed(),"");

    }
    @Test(description = "Given I'm on the home Page and I Need to Navigate to All Products Page ," +
            " Then I Need To add the First and Second Product" +
            " , Then I Need to View cart page to verify the details are correct")
    public void VerifyAddProductsInCart() {
        homePage.navigate();
        Assert.assertTrue(homePage.checkHomePageIsLoaded());
        homePage.MoveToProductsPage();
        Assert.assertTrue(productsPage.checkProductsPageIsLoaded());
        productsPage.addProductToCart(1);
        productsPage.continueShopping();
        productsPage.addProductToCart(2);
        productsPage.viewCart();
        Assert.assertEquals(viewCartPage.getProductsCartSize(),2);
        viewCartPage.getPricesQuantityAndTotalProductsInCart();
    }
    @Test(description = "Given I'm on the home Page and I Need to Navigate to All Products Page ," +
            "Then I Need To add 4 items from the Second Product  ," +
            " Then I Need to View cart page to verify the Product's quantity is correct")
     public void VerifyProductQuantityInCart(){
        homePage.navigate();
        Assert.assertTrue(homePage.checkHomePageIsLoaded());
        homePage.MoveToProductsPage();
        Assert.assertTrue(productsPage.checkProductsPageIsLoaded());
        productsPage.MoveToSpecificDetailsViewPageProduct(2);
        productDetailsPage.setTheQuantity(4);
        productDetailsPage.addProductToCart();
        productDetailsPage.viewCart();
        Assert.assertEquals(viewCartPage.getQuantityCellFirstProduct(),"4");
    }
    @Test(description = "Given I'm on the home Page and I Need to Navigate to All Products Page ," +
            "Then I Need To add the First Product  ," +
            "Then Register New Account While I Proceed To Check out" +
            " After I submitted the order I will download the invoice and verify that it is downloaded successfully")
    public void PlaceOrderRegisterWhileCheckout(){
        homePage.navigate();
        Assert.assertTrue(homePage.checkHomePageIsLoaded());
        homePage.MoveToProductsPage();
        Assert.assertTrue(productsPage.checkProductsPageIsLoaded());
        productsPage.addProductToCart(1);
        productsPage.viewCart();
        viewCartPage.proceedToCheckOut();
        viewCartPage.moveToRegisterOrLogin();
        loginSignupPage.MoveToSignupPage("loal489@gmail.com","alaa");
        signupPage.selectTitleMrs();
        signupPage.enterPassword("1110A");

        signupPage.selectBirthDate(10,10,1998);


        signupPage.scrollOnPage(150);

        signupPage.enterFirstAndLastName("alaa","fawzy");

        signupPage.enterAddress("st");

        signupPage.enterCountry("Canada");

        signupPage.enterState("Egypt");

        signupPage.enterCity("cairo");
        signupPage.enterZipcode("11528");
        signupPage.enterPhone("01026103126");
        signupPage.createAccount();

        Assert.assertTrue(accountCreatedPage.DisplayTextPage());

        accountCreatedPage.continueAndMoveToHome();

        Assert.assertTrue(loggedInHome.checkLoginDisplay());

        Assert.assertEquals("alaa",loggedInHome.getLoginUserName());

        loggedInHome.viewCart();

        viewCartPage.proceedToCheckOut();

        checkOutPage.setDescriptionOrder("Hi, this for test");

        checkOutPage.placeOrder();

        paymentPage.setCardDetails("Hank Dudley","4000 0000 0000 0002","123","10","24");
        paymentPage.submitOrder();
        paymentDonePage.downloadInvoice();
        Assert.assertTrue(paymentDonePage.downloadInvoiceIsDone("invoice.txt"));

    }
    @Test(description = "Given I'm on the home Page and I Need to Navigate to All Products Page ," +
            "Then I Need To add the First Product  ," +
            "Then Login To my account While I Proceed To Check out" +
            " After I submitted the order I will download the invoice and verify that it is downloaded successfully")
   public void  PlaceOrderLoginBeforeCheckout(){
        homePage.navigate();
        Assert.assertTrue(homePage.checkHomePageIsLoaded());
        homePage.MoveToProductsPage();
        Assert.assertTrue(productsPage.checkProductsPageIsLoaded());
        productsPage.addProductToCart(1);
        productsPage.viewCart();
        viewCartPage.proceedToCheckOut();
        viewCartPage.moveToRegisterOrLogin();
        loginSignupPage.loginToAccount("dd489@gmail.com","101010A");

        Assert.assertTrue(loggedInHome.checkLoginDisplay());

        Assert.assertEquals("alaa",loggedInHome.getLoginUserName());

        loggedInHome.viewCart();

        viewCartPage.proceedToCheckOut();

        checkOutPage.setDescriptionOrder("Hi, this for test");

        checkOutPage.placeOrder();

        paymentPage.setCardDetails("Hank Dudley","4000 0000 0000 0002","123","10","24");
        paymentPage.submitOrder();
        paymentDonePage.downloadInvoice();
        Assert.assertTrue(paymentDonePage.downloadInvoiceIsDone("invoice.txt"));
        paymentDonePage.continueShopping();
        productsPage.logoutFromAccount();
   }

    @BeforeMethod
    void BeforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        viewCartPage = new ViewCartPage(driver);
        loginSignupPage = new LoginSignupPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        loggedInHome = new LoggedInHome(driver);
        checkOutPage = new CheckOutPage(driver);
        productsPage = new ProductsPage(driver);
        paymentPage = new PaymentPage(driver);
        paymentDonePage = new PaymentDonePage(driver);

    }
    @AfterMethod
    void AfterMethod(){
        driver.quit();
    }
}
