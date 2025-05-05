package Pages;

import Utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddToCartPage {

    private final WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }


    // Locators


    //private final By IphoneItem   = By.cssSelector("div[class=\"caption\"] a[href=\"https://awesomeqa.com/ui/index.php?route=product/product&product_id=40\"]");
    private final By IphoneItem = By.xpath("//div[@class='caption']//a[text()='iPhone' and @href='https://awesomeqa.com/ui/index.php?route=product/product&product_id=40']");
    private final By MacBook        = By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=product/product&product_id=43']");
    private final By Canon          = By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=product/product&product_id=30']");    private final By AddToCartButton = By.id("button-cart");
    private final By SuccessMsg     = By.cssSelector("div.alert.alert-success.alert-dismissible");
    private final By ShoppingCart   = By.cssSelector("a[href=\"https://awesomeqa.com/ui/index.php?route=checkout/cart\"] span[class=\"hidden-xs hidden-sm hidden-md\"]");
    private final By ItemModel1     = By.cssSelector("div[class=\"table-responsive\"] img[src=\"https://awesomeqa.com/ui/image/cache/catalog/demo/iphone_1-47x47.jpg\"]");
    private final By ItemModel2     = By.cssSelector("div[class=\"table-responsive\"] img[src=\"https://awesomeqa.com/ui/image/cache/catalog/demo/macbook_1-47x47.jpg\"]");
    private final By Home_btn       = By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=common/home']");
    private final By TotalPrice     = By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[1]/td[2]");
    public void clickOnHome(){
        WebElement Home_btnL = Waits.waitForElementToBeClickable(driver, Home_btn);
        Home_btnL.click();
    }
/*
    public void AddToCartViewProductIphone(){
        driver.findElement(IphoneItem).click();
    }
    public void AddToCartViewProductMacBook(){
        driver.findElement(MacBook).click();
    }
    public void AddToCartViewProductCanon(){
        driver.findElement(Canon).click();
    }
*/
    public void AddToCartViewProduct(By product){
        driver.findElement(product).click();
    }
/*
    public void AddToCartClickIphoneAddToCart(){
        driver.findElement(AddToCartButton).click();
    }

    public void AddToCartClickMacbookAddToCart(){
        driver.findElement(AddToCartButton).click();
    }

    public void AddToCartClickCanonAddToCart(){
        driver.findElement(AddToCartButton).click();
    }
*/
    public void addToCartClick(By product) {
        driver.findElement(product).click();
    }


    public void AddIphone(){
        AddToCartViewProduct(IphoneItem);
        addToCartClick(AddToCartButton);
    }

    public void AddproductV2(By product){
        AddToCartViewProduct(product);
        addToCartClick(AddToCartButton);
    }
/*
    public void Addproduct2(){
        AddToCartViewProductMacBook();
        AddToCartClickMacbookAddToCart();
    }

    public void Addproduct3(){
        AddToCartViewProductCanon();
        AddToCartClickCanonAddToCart();
    }
*/

    public void AddToCartCheckIphoneMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement loggedInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loggedInElement.isDisplayed(), "Success: You have added iPhone to your shopping cart!.");
        softAssert.assertAll();
        clickOnHome();
    }

    public void AddToCartCheckMsg(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement loggedInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loggedInElement.isDisplayed(), "Success: You have added " + productName + " to your shopping cart!.");
        softAssert.assertAll();
        clickOnHome();
    }

    public void ShoppingCartView(){
        driver.findElement(ShoppingCart).click();
        driver.findElement(ItemModel1).isDisplayed() ;
    }

    public void ShoppingCartViewV2(){
        driver.findElement(ShoppingCart).click();
        driver.findElement(ItemModel1).isDisplayed() ;
        driver.findElement(ItemModel2).isDisplayed() ;
    }

    public void AssertTotalPrice(){
        WebElement SuccessMessage = Waits.waitForElementToBeVisible(driver, TotalPrice);
        Assert.assertEquals(SuccessMessage.getText(), "$601.00");
    }


    public void AddMoreproduct(){
        AddIphone();
        AddToCartCheckIphoneMsg();
        AddproductV2(MacBook);
        AddToCartCheckMsg("MacBook");
    }

}
