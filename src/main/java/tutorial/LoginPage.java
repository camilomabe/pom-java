package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginPage {
    WebDriver driver;

    By txtUser = By.id("user");
    public void typeUser(String strUser) {
        driver.findElement(txtUser).sendKeys(strUser);
    }

    By txtPassword = By.id("pass");
    public void typePassword(String strPassword) {
        driver.findElement(txtPassword).sendKeys(strPassword);
    }

    By btnLogin = By.id("submit");
    public void clickOnLogin() {
        driver.findElement(btnLogin).click();
    }

    By labelLoginPage = By.xpath("//h4[contains(text(),'Direccion de Envio')]");
    public void validLoginPage(String strLoginHome) {
        String labelHomePage = driver.findElement(labelLoginPage).getText();
        assertEquals(labelHomePage,strLoginHome);
    }
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}