package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewCartPage {
    WebDriver driver;
    String url="https://automationexercise.com/view_cart";
    By cartProducts = By.xpath("//tbody//tr");
    By cartPriceProductsCellsBy = By.xpath("//tbody//td[contains(.,'Rs.')]");
    By cartQuantityProductCellsBy = By.xpath("//tbody//td//button");
    By cartQuantityProductCellBy = By.xpath("//tbody//td//button[1]");
    By proceedToCheckOutBy = By.xpath("//a[text()='Proceed To Checkout']");
    By registerLoginBy = By.partialLinkText("Register");
    public ViewCartPage(WebDriver driver){
        this.driver = driver;
    }
    public int getProductsCartSize(){
        for(WebElement element:driver.findElements(cartProducts)){
            System.out.println(element.getAttribute("class"));
        }
        return  driver.findElements(cartProducts).size();
    }
    public ArrayList<List<Integer>> getPricesQuantityAndTotalProductsInCart(){
        List<WebElement> cartPriceProductsCellsElements = driver.findElements(cartPriceProductsCellsBy);
        List<WebElement> cartQuantitiesProductsCellsElements = driver.findElements(cartQuantityProductCellsBy);
        Integer []pricesCells =new Integer[cartPriceProductsCellsElements.size()/2] ;
        Integer []totalCells=new Integer[cartPriceProductsCellsElements.size()/2];
        Integer []quantitiesCells=new Integer[cartQuantitiesProductsCellsElements.size()];
        ArrayList <List<Integer>> pricesQuantityAndTotalProducts = new ArrayList<>();

        for(int i = 0,j=0;i<cartPriceProductsCellsElements.size();j++,i++) {
            pricesCells[j] = Integer.parseInt((cartPriceProductsCellsElements.get(i++).getText().split(" ")[1]));
            //    System.out.println(pricesCells[j]);
            totalCells[j] =  Integer.parseInt((cartPriceProductsCellsElements.get(i).getText().split(" ")[1]));
            //  System.out.println(totalCells[j]);
            quantitiesCells[j]=Integer.parseInt(cartQuantitiesProductsCellsElements.get(j).getText());
            //  System.out.println(quantitiesCells[j]);
        }
        pricesQuantityAndTotalProducts.add(Arrays.asList(pricesCells));
        pricesQuantityAndTotalProducts.add(Arrays.asList(quantitiesCells));
        pricesQuantityAndTotalProducts.add(Arrays.asList(totalCells));

        return pricesQuantityAndTotalProducts;
    }
    public String getQuantityCellFirstProduct(){
        WebElement cartQuantityProductCellElement = driver.findElement(cartQuantityProductCellBy);
        return cartQuantityProductCellElement.getText();
    }
    public void proceedToCheckOut(){
        WebElement proceedToCheckOutElement = driver.findElement(proceedToCheckOutBy);
        proceedToCheckOutElement.click();
    }
    public void moveToRegisterOrLogin(){
        WebElement registerLoginElement = driver.findElement(registerLoginBy);
        registerLoginElement.click();
    }
    public void navigate(){
        driver.navigate().to(url);
    }
}
