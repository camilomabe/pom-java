package tutorial;

import data.ClassData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    LoginPage page = new LoginPage(driver);
    ClassData data = new ClassData();
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", data.driverExe);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(data.url2);
    }

    @Test
    public void Test() {
        page = new LoginPage(driver);

        page.typeUser(data.strEmail);
        page.typePassword(data.strPassword);
        page.clickOnLogin();
        page.validLoginPage(data.strLoginHome);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
