package Tests;

import Base.TestBase;
import Pages.AddToCartPage;
import Pages.HomePage;
import Pages.RegisterPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    HomePage homePage;
    AddToCartPage addTocart ;


    @Description("Validate that user can Add Product To Cart")
    @Test
    public void validateAddProductToCart(){
        homePage = new HomePage(driver);
        addTocart = new AddToCartPage(driver);
        homePage.navigate();
        addTocart.AddIphone();
        addTocart.AddToCartCheckIphoneMsg();
        addTocart.ShoppingCartView();
    }

    @Description("Validate that user can Add More Product To Cart")
    @Test
    public void validateAddMoreProductToCart(){
        homePage = new HomePage(driver);
        addTocart = new AddToCartPage(driver);
        homePage.navigate();
        addTocart.AddMoreproduct();
        addTocart.ShoppingCartViewV2();
        addTocart.AssertTotalPrice();
    }
}
