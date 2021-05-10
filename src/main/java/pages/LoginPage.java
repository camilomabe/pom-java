package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LoginPage {

    WebDriver driver;

    By labelSingIn = By.xpath("//a[contains(text(),'Sign in')]");
    By labelAlready = By.xpath("//h3[contains(text(),'Already registered?')]");
    By txtEmail = By.cssSelector("#email");
    By txtPassword = By.cssSelector("#passwd");
    By btnSubmitLogin = By.id("SubmitLogin");

    By txtNewUser = By.cssSelector("#email_create");
    By btnCreateUser = By.id("SubmitCreate");


    public LoginPage(WebDriver driver) {this.driver = driver;}


    public void clickOnLabelSingIn() {
        driver.findElement(labelSingIn).click();
    }
    public void typeEmail(String strEmail) {
        driver.findElement(txtEmail).sendKeys(strEmail);
    }
    public void typePassword(String strPassword) {
        driver.findElement(txtPassword).sendKeys(strPassword);
    }
    public void clickOnButtonSingIn() {
        driver.findElement(btnSubmitLogin).click();
    }
    public void validHomePageLogin(String strValidLoginPage) {
        String homePageLogin = driver.findElement(labelAlready).getText();
        System.out.println("Texto real: "+homePageLogin +"\n"+ "Texto esperado: "+strValidLoginPage);
        assertEquals(homePageLogin,strValidLoginPage);
    }


    public void typeCreateUser(String strEmail) {
        driver.findElement(txtNewUser).sendKeys(strEmail);
    }

    public void clickOnCreateAnAcount() {
        driver.findElement(btnCreateUser).click();
    }


    public void invalidLogin(String strEmail, String strPassword) throws Exception {
        this.captureScreen("1. Home page");
        this.clickOnLabelSingIn();
        this.captureScreen("2. Home page Sing In");
        this.typeEmail(strEmail);
        this.captureScreen("3. Ingresar email");
        this.typePassword(strPassword);
        this.captureScreen("4. Screen password");
        this.captureScreen("5. Clic iniciar sesion");
        this.clickOnButtonSingIn();
        Thread.sleep(3000);

    }

    public void captureScreen(String imgName) throws IOException {
        String pathImg = "src/test/resources/screen/";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File fichero = new File(pathImg + imgName + ".png");
        if (fichero.exists()) {
            fichero.delete();
        }
        FileUtils.copyFile(scrFile, new File(pathImg + imgName + ".png"));
    }
}