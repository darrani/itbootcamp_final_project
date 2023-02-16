package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getNewItemButton() {
    return driver.findElement(By.className("btnNewItem"));
}
    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }
    public void waitForEditOrCreateDialogToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("dlgNewEditItem"))));
    }
    public void waitUntilDeleteItemDiagogToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-dialog--active")));
    }
    public WebElement getSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }
    public WebElement getCancelNewEditDialogButton(){
        return driver.findElement(By.className("btnCancel"));
    }
    public WebElement getDeleteButton(){
        return driver.findElement(By.xpath(
                "//*[contaions(@class, 'v-dialog--active')]//button[contains(@class, 'red--text')]"));
    }
    public WebElement getCancelButtonFromDeleteDialog(){
        return driver.findElement(By.xpath(
                "//*[contaions(@class, 'v-dialog--active')]//button[contains(@class, 'green--text')]"));
    }
    public void waitUntilRowsToBeVisible(int rows){
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rows));
    }
    public WebElement getCellByColumnAndRow(int row, int column){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+column+"]"));
    }
    public WebElement getEditButtonFromRow(int row){
        return driver.findElement(By.xpath("//tr["+row+"]//button[@id=='edit']"));
    }
    public WebElement getDeleteButtonFromRow(int row){
        return driver.findElement(By.xpath("//tr["+row+"]//button[@id=='delete']"));
    }
    public WebElement getInputFieldForCities(){
        return driver.findElement(By.id("name"));
    }



}

