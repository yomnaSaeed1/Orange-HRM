package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.ValidationPage;

public class ValidLoginTest extends TestBase {

    LoginPage loginObj;
    HomePage homeObj;

    @BeforeMethod
    public void beforeMethod(){
        loginObj = new LoginPage(driver);
        homeObj = new HomePage(driver);
    }

    @Test
    public void userLoginSuccessfully() {
        loginObj.userLoginSuccessfully();
        Assert.assertEquals(homeObj.getDashboardText(), "Dashboard");
        loginObj.scrollToButtom();
    }
}
