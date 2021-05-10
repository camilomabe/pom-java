package tests;

import data.ClassData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAccountPage;
import pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;


    ClassData data = new ClassData();
    LoginPage categoria = new LoginPage(driver);
    CreateAccountPage perInfo = new CreateAccountPage(driver);


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", data.driverExe);
        driver = new ChromeDriver();
        driver.navigate().to(data.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void invalidLoginTest() throws Exception {
        System.out.println("Usuario no registrado inica sesion");
        categoria = new LoginPage(driver);
        categoria.invalidLogin(data.strLogin, data.strPassword);
        categoria.captureScreen("Loging exitoso");

    }


   @Test
    public void registerUser() throws Exception {
        System.out.println("Usuario no registrado inica sesion");
        categoria = new LoginPage(driver);
        perInfo = new CreateAccountPage(driver);

        categoria.invalidLogin(data.strEmail, data.strPassword);
        categoria.validHomePageLogin(data.strValidHomePageLogin);
        categoria.typeCreateUser(data.strEmail);
        categoria.captureScreen("7. Email para cre3ar cuenta de nuevo usuario");
        categoria.clickOnCreateAnAcount();
        perInfo.validHomePagePersonInfo(data.strValidHomePagePersonalInfo);
        categoria.captureScreen("8. Form crear nueva cuenta");
        perInfo.clickGenero(data.strGenero);
        categoria.captureScreen("9. Genero seleccionado "+data.strGenero);

        perInfo.typeCusFistName(data.strFirstName);
        categoria.captureScreen("10. Nombre");

        perInfo.typeCusLastName(data.strLastName);
        categoria.captureScreen("11. Appellido");

        categoria.typePassword(data.strPassword);
        categoria.captureScreen("12. Password info personal");

        perInfo.selectDateOfBirth(data.strDay,data.strMonth,data.strYear);
        categoria.captureScreen("13. fecha de cumpleaños");

        perInfo.radCheckNewsletter();
        categoria.captureScreen("14. Suscríbase a nuestro boletín de noticias");

        perInfo.radCheckFromOurPartners();
        categoria.captureScreen("15. nuestros amigos");

        perInfo.typeFirsName(data.strFirstName);
        categoria.captureScreen("16. Ingresa nombre");

        perInfo.typeLastName(data.strLastName);
        categoria.captureScreen("17. Ingresa apellido");

        perInfo.typeCompany(data.strCompany);
        categoria.captureScreen("18. Ingresa Commpañia");

        perInfo.typeAddress(data.strAddress);
        categoria.captureScreen("19. Ingresa Direccion");

        perInfo.typeAddressLine(data.strAddressLine);
        categoria.captureScreen("20. Direccion opcional");

        perInfo.typeCity(data.strCity);
        categoria.captureScreen("21. Ingresa ciudad");

        perInfo.selectState(data.strState);
        categoria.captureScreen("22. Selecciona estado");

        perInfo.typePostCode(data.strPostCode);
        categoria.captureScreen("23. Ingresa codigo postal");

        perInfo.selectCountry(data.strCountry);
        categoria.captureScreen("24. Selecciona pais");



        perInfo.typeOther(data.strOther);
        categoria.captureScreen("25. Ingresa otros");
        perInfo.typePhone(data.strPhone);
        categoria.captureScreen("26. Ingresa telefono");
        perInfo.typePhoneMobile(data.strPhoneMobile);
        categoria.captureScreen("27. Ingresa celular");
        perInfo.typeAlias(data.strAlias);
        categoria.captureScreen("28. Ingresa alias");
        categoria.captureScreen("29. Click en crear cuenta");
        perInfo.clickOnSubmitAccount();
        perInfo.validHomePagMyAccount(data.strMyAccount);
        categoria.captureScreen("30. Cuenta creada corecctamente");

        Thread.sleep(5000);
    }

    //@Test
    public void LoginPhptravels() throws IOException, InterruptedException {
        System.out.println("Login on Automation Practice");
        categoria = new LoginPage(driver);

        categoria.clickOnLabelSingIn();
        categoria.typeEmail(data.strEmail);
        categoria.typePassword(data.strPassword);
        categoria.clickOnButtonSingIn();
        Thread.sleep(2000);
        categoria.captureScreen("Screen Login 2");
    }


    @After
    public void tearDown() {
        //driver.quit();
    }

}