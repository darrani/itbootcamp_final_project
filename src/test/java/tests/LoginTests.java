package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{

    @Test (priority = 10)
    @Description("TC1: Visits the login page")
    public void visitsTheLoginPage(){

        navPage.getLanguageButton().click();
        loginPage.getLoginButtonLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Not on login page.");
    }

    @Test (priority = 20)
    @Description("TC2: Checks input types")
    public void checksInputTypes(){
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"),
                "email", "Invalid email input type");
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"),
                "password", "Invalid password input type");

    }

    @Test(priority = 30)
    @Description("TC3: Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist(){
        loginPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.getTextFromDialogue().getText(),
               "User does not exists", "Error message does not appear");
    }

    @Test(priority = 40)
    @Description("TC4: Displays errors when password is wrong")

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

    @Test(priority = 50)
    @Description("TC5: Login")
    public void login() throws InterruptedException {
        loginPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "[Error] Page URL should contain '/home' ");;
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home", "Not on home page. ");
    }

    @Test(priority = 60)
    @Description("TC6: Logout")
    public void logout(){
        navPage.visibilityOfLogoutButton();
        navPage.getLogoutButton().click();

    }
}
