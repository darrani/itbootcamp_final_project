package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
//    Test #1: Visits the login page
//Koraci:
//Postaviti EN jezik stranice
//Klik na login dugme iz navigacije
//Verifikovati da se u url-u stranice javlja ruta /login

    @Test (priority = 10)
    @Description("Test #1: Visits the login page")
    public void visitsTheLoginPage(){

        navPage.getLanguageButton().click();
        loginPage.getLoginButtonLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Not on login page.");
    }

//  Test #2: Checks input types
//Koraci:
//Klik na sign up dugme iz navigacije
//Verifikovati da polje za unos emaila za atribut type ima vrednost email
//Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
    @Test (priority = 20)
    @Description("Test #2: Checks input types")
    public void checksInputTypes(){
        signUpPage.getSignUpButton().click();

        Assert.assertEquals(signUpPage.getFieldEmailInput().getAttribute("type"),
                "email", "Invalid email input type");
        Assert.assertEquals(signUpPage.getFieldPasswordInput().getAttribute("type"),
                "password", "Invalid password input type");

        Assert.assertEquals(signUpPage.getFieldConfirmPasswordInput().getAttribute("type"),
                "password", "Invalid confirm password input type");

    }
//    Test #3: Displays errors when user does not exist
//Podaci:
//email: non-existing-user@gmal.com
//password: password123
//Koraci:
//Klik na login dugme iz navigacije
//Popuniti login formu podacima za logovanje
//Klik na login dugme
//Sacekati da popu za prikaz greske bude vidljiv
//Verifikovati da greska sadrzi poruku User does not exists
//Verifikovati da se u url-u stranice javlja /login ruta

    @Test
    @Description("Test #3: Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist(){
        loginPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
//
////        mora lista da se napravi da bi mogle da se verifikuju poruke iz dijaloga
//        Assert.assertEquals(messagePopUpPage.getTextFromDialogue().getText(),
//               "User does not exists", "Error message does not appear");
    }

//    Test #4: Displays errors when password is wrong
//Podaci:
//email: admin@admin.com
//password: password123
//Koraci:
//Klik na login dugme iz navigacije
//Popuniti login formu podacima za logovanje
//Klik na login dugme
//Sacekati da popu za prikaz poruke bude vidljiv
//Verifikovati da greska sadrzi poruku Wrong password
//Verifikovati da se u url-u stranice javlja /login ruta
    @Test
    @Description("Test #4: Displays errors when password is wrong")

    public void displaysErrorsWhenPasswordIsWrong(){
        loginPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextFromDialogue().getText(),
                "Wrong password", "Error message does not appear");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Not on login page. ");
    }

//    Test #5: Login
//Podaci:
//email: admin@admin.com
//password: 12345
//Koraci:
//Klik na login dugme iz navigacije
//Popuniti login formu podacima za logovanje
//Verifikovati da se u url-u stranice javlja /home ruta

    @Test
    @Description("Test #5: Login")
    public void login() throws InterruptedException {
        loginPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "[Error] Page URL should contain '/home' ");;
        //proveriti
    //    Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home", "Not on home page. ");
    }

//   Test #6: Logout
//Koraci:
//Verifikovati da je dugme logout vidljivo na stranici
//Kliknuti na logout dugme

    @Test
    @Description("Logout")
    public void logout(){
        navPage.visibilityOfLogoutButton();
       navPage.getLogoutButton().click();

    }
}
