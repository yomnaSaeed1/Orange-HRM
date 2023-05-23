package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static By dashboardHeader = By.className("oxd-topbar-header-breadcrumb-module");

    public String getDashboardText() {
        return getElementText(dashboardHeader);
    }

}
