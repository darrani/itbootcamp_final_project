package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {

    @Test(priority = 10)
    @Description("TC1: Visits the signup page")
    public void visitsTheSignupPage(){
        navPage.getSignUpButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup",
                "Not on signup page.");
    }

    @Test(priority = 20)
    @Description("TC2: Checks input types")
    public void checksInputTypes(){
        navPage.getSignUpButton().click();
        Assert.assertEquals(signUpPage.getFieldEmailInput().getAttribute("type"),
                "email", "Invalid email input type");
        Assert.assertEquals(signUpPage.getFieldPasswordInput().getAttribute("type"),
                "password", "Invalid password input type");
        Assert.assertEquals(signUpPage.getFieldConfirmPasswordInput().getAttribute("type"),
                "password", "Invalid confirm password input type");
    }

    @Test(priority = 30)
    @Description("TC3: Displays errors when user already exists")
    public void displaysErrorsWhenUserAlreadyExists(){
        navPage.getSignUpButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl +"/signup", "Not on signup page" );
        signUpPage.getFieldNameInput().sendKeys("Another User");
        signUpPage.getFieldEmailInput().sendKeys("admin@admin.com");
        signUpPage.getFieldPasswordInput().sendKeys("12345");
        signUpPage.getFieldConfirmPasswordInput().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();
       messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromDialogue().getText()
                        .contains("E-mail already exists"), "Error message does not appear");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl +"/signup", "Not on signup page" );

}

    @Test(priority = 40)
    @Description("TC4: Signup")
    public void signUp() {
        navPage.getSignUpButton().click();
        signUpPage.getFieldNameInput().sendKeys("Dragana Nikolic");
        signUpPage.getFieldEmailInput().sendKeys("dragana.nikolic@itbootcamp.com");
        signUpPage.getFieldPasswordInput().sendKeys("12345");
        signUpPage.getFieldConfirmPasswordInput().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();
//        wait.until(ExpectedConditions.urlContains("/home"));
        messagePopUpPage.waitUntilVerifyYourAccountDialogIsVisible();
        Assert.assertEquals(messagePopUpPage.getVerifyYourAccountHeader()
                .getText() ,"IMPORTANT: Verify your account ",
                "The message doesn't contain 'IMPORTANT: Verify your account'");
        Assert.assertTrue(messagePopUpPage.getTextFromDialogue().getText()
                        .contains("IMPORTANT: Verify your account"), "Message does not appear");
        messagePopUpPage.getVerifyYourAccountCloseButton().click();
        navPage.getLogoutButton().click();
    }


}
