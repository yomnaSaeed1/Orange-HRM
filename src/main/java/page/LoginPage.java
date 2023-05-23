package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.LoadProperties;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static By userNameTxt = By.name("username");
    private static By PasswordTxt = By.name("password");
    private static By loginBtn = By.className("orangehrm-login-button");

    String Username = LoadProperties.userData.getProperty("Username");
    String Password = LoadProperties.userData.getProperty("Password");



    public void userLoginSuccessfully(){
        typeTextInField(userNameTxt, Username);
        typeTextInField(PasswordTxt, Password);
        clickButton(loginBtn);
    }

    public void scrollToHomePageEnd(){
        scrollToButtom();
    }


}
