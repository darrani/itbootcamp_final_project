package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{

    @Test(priority = 10)
    @Description("TC1: Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities(){
        navPage.getLoginLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"), "Not on admin page.");

    }
    @Test(priority = 20)
    @Description("TC2: Checks input types for create/edit new city")
    public void checksInputTypesForCreateEditNewCity(){

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditOrCreateDialogToBeVisible();
        Assert.assertTrue(citiesPage.getSearchInput().getAttribute("type")
                        .contains("text"), "Invalid text input type");

    }

    @Test(priority = 30)
    @Description("TC3: Create new city")
    public void createNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditOrCreateDialogToBeVisible();
        citiesPage.getInputFieldForCities().sendKeys("Dragana Nikolic's city");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage().getText()
                .contains("Saved Successfully")," Invalid text message.");

    }
//
    @Test(priority = 40)
    @Description("TC4: Edit city")
    public void editCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Dragana Nikolic's city");
        citiesPage.waitUntilRowsToBeVisible(1);
        citiesPage.getEditButtonFromRow(1).click();
        citiesPage.getInputFieldForCities().sendKeys(Keys.CONTROL + "a");
        citiesPage.getInputFieldForCities().sendKeys(Keys.BACK_SPACE);
        citiesPage.getInputFieldForCities().sendKeys("Dragana Nikolic's city Edited");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromDialogue().getText()
                .contains("Saved Successfully"), "Invalid text message");
    }

    @Test(priority = 50)
    @Description("TC5: Search city")
    public void searchCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Dragana Nikolic's city");
        citiesPage.waitUntilRowsToBeVisible(1);
        Assert.assertTrue(citiesPage.getCellByColumnAndRow(1,2).getText()
                .contains("Dragana Nikolic's city"), "Column doesn't contain 'Dragana Nikolic's city'.");

    }

    @Test(priority = 60)
    @Description("TC6: Delete city")
    public void deleteCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Dragana Nikolic's city");
        citiesPage.waitUntilRowsToBeVisible(1);
        Assert.assertTrue(citiesPage.getCellByColumnAndRow(1,2).getText()
                .contains("Dragana Nikolic's city"), "Column doesn't contain 'Dragana Nikolic's city'.");
        citiesPage.getDeleteButtonFromRow(1).click();
        citiesPage.waitUntilDeleteItemDiagogToBeVisible();
        citiesPage.getDeleteButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromDialogue().getText()
                .contains("Deleted successfully"),"Invalid text message" );

    }


}
