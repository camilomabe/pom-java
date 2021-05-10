package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class CreateAccountPage {

    WebDriver driver;

    By labelPersonInfo = By.xpath("//h3[contains(text(),'Your personal information')]");
    By sir = By.id("id_gender1");
    By mis = By.id("id_gender2");

    By txtCusFirstName = By.id("customer_firstname");
    By txtCusLastName = By.id("customer_lastname");
    By listDay = By.name("days");
    By listMonth = By.name("months");
    By listYear = By.name("years");
    By checkNewsletter = By.id("newsletter");
    By checkFromOurPartners = By.id("optin");
    By txtFirstName = By.id("firstname");
    By txtLastName = By.id("lastname");
    By txtAddress = By.id("address1");
    By txtAddressLine = By.id("address2");
    By txtCity = By.id("city");
    By txtCompany = By.id("company");
    By listState = By.id("id_state");
    By txtPostCode = By.id("postcode");
    By listCountry = By.id("id_country");
    By txtOther = By.id("other");
    By txtPhone = By.id("phone");
    By txtPhoneMobile = By.id("phone_mobile");
    By txtAlias = By.id("alias");
    By btnSubmitAccount = By.id("submitAccount");
    By labelMyAccount = By.xpath("//h1[contains(text(),'My account')]");




    public CreateAccountPage(WebDriver driver) {this.driver = driver;}

    public void validHomePagePersonInfo(String strValidPreateAcountPage) {
        String homePagePersonInfo = driver.findElement(labelPersonInfo).getText();
        System.out.println("Texto real: "+homePagePersonInfo +"\n"+ "Texto esperado: "+strValidPreateAcountPage);
        assertEquals(homePagePersonInfo,strValidPreateAcountPage);
    }

    public void clickGenero(String genero) {
        if(genero == "F"){
            driver.findElement(mis).click();
        }else if(genero == "M"){
            driver.findElement(sir).click();
        }else {
            System.out.println("Genero no valido");
        }

    }

    public void typeCusFistName(String strFistName) {
        driver.findElement(txtCusFirstName).sendKeys(strFistName);
    }
    public void typeCusLastName(String strCusLastName) {driver.findElement(txtCusLastName).sendKeys(strCusLastName);}

    public void selectDateOfBirth(int strDay, int strMonth, String strYear) throws InterruptedException {
        driver.findElement(listDay).click();
        Select selectDay = new Select(driver.findElement(listDay));
        selectDay.selectByIndex(strDay);

        driver.findElement(listMonth).click();
        Select selectMonth = new Select(driver.findElement(listMonth));
        selectMonth.selectByIndex(strMonth);

        Select listYear = new Select(driver.findElement(this.listYear));
        listYear.selectByValue(strYear);
    }

    public void radCheckNewsletter() {
        driver.findElement(checkNewsletter).click();
    }
    public void radCheckFromOurPartners() {
        driver.findElement(checkFromOurPartners).click();
    }

    public void typeFirsName(String strFirstName) {
        driver.findElement(txtFirstName).clear();
        driver.findElement(txtFirstName).sendKeys(strFirstName);
    }
    public void typeLastName(String strLastName) {
        driver.findElement(txtLastName).clear();
        driver.findElement(txtLastName).sendKeys(strLastName);
    }

    public void typeAddress(String strAddress) {
        driver.findElement(txtAddress).sendKeys(strAddress);
    }
    public void typeAddressLine(String strAddressLine) {
        driver.findElement(txtAddressLine).sendKeys(strAddressLine);
    }
    public void typeCompany(String strCompany) {
        driver.findElement(txtCompany).sendKeys(strCompany);
    }
    public void typeCity(String strCity) {
        driver.findElement(txtCity).sendKeys(strCity);
    }

    public void selectState(String strState) throws InterruptedException {
        Select selectState = new Select(driver.findElement(listState));
        selectState.selectByVisibleText(strState);

    }

    public void typePostCode(String strPostCode) {
        driver.findElement(txtPostCode).sendKeys(strPostCode);
    }

    public void selectCountry(String strCountry) throws InterruptedException {
        Select selectCountry = new Select(driver.findElement(listCountry));
        selectCountry.selectByVisibleText(strCountry);

    }


    public void typeOther(String strOther) {
        driver.findElement(txtOther).sendKeys(strOther);
    }
    public void typePhone(String strPhone) {
        driver.findElement(txtPhone).sendKeys(strPhone);
    }
    public void typePhoneMobile(String strPhoneMobile) {
        driver.findElement(txtPhoneMobile).sendKeys(strPhoneMobile);
    }

    public void typeAlias(String strAlias) {
        driver.findElement(txtAlias).clear();
        driver.findElement(txtAlias).sendKeys(strAlias);
    }

    public void clickOnSubmitAccount() {
        driver.findElement(btnSubmitAccount).click();
    }


    public void validHomePagMyAccount(String strMyAccount) {
        String homePageMyAccount = driver.findElement(labelMyAccount).getText();
        System.out.println("Texto real: "+homePageMyAccount +"\n"+ "Texto esperado: "+strMyAccount);
        assertEquals(homePageMyAccount,strMyAccount);
    }


}
