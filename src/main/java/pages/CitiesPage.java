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

//dugme New Item
//input za pretragu
//metodu koja ceka da se dijalog za editovanje i kreiranje pojavi
//metodu koja ceka da se dijalog za brisanje pojavi
//save dugme iz dijalog za editovanje i kreiranje
//delete dugme iz dijaloga za brisanje
//metodu koja ceka da se u tabeli pojavi odredjeni broj redova.
// Metoda kao parametar prima broj redova. Ako se metoda pozove sa parametrom 5,
// to znaci da metoda ceka da se u tabeli pojavi 5 redova.
//metodu koja vraca celiju iz odredjenog reda. Metoda kao parametre prima red i kolonu a vraca td iz tabele.
// Npr: ukoliko se metoda pozove row=2, cell=3 tada metoda vraca trecu celiju iz 2 reda.
//metodu koja vraca edit dugme trazenog reda. Metoda kao parametar prima red a vraca dugme.
// Npr ako se metoda pozove row=3, metoda vraca edit dugme iz treceg reda tabele
//metodu koja vraca delete dugme trazenog reda. Metoda kao parametar prima red a vraca dugme.
// Npr ako se metoda pozove row=3, metoda vraca delete dugme iz treceg reda tabele

    public WebElement getNewItemButton(){
        return driver.findElement(By.className("btnNewItem"));
    }
    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
    public WebElement waitForEditOrCreateDialogToBeVisible() {
         return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit")));
    }

    public WebElement waitForDeleteDialogToBeVisible(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete")));
    }
    public WebElement getSaveButtonFromEditDialog(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }
    public WebElement getDeleteButtonFromDeleteDialog(){
        return driver.findElement(By.xpath("//*[@class='v-card__actions']/button[2]"));
    }

//metodu koja ceka da se u tabeli pojavi odredjeni broj redova.
    public List<WebElement> waitForNumberOfRowsToBe(int expectedNumOfRows){
        return wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody"), expectedNumOfRows));
    }
    public WebElement getEditButton(int rowIndex) {
        return this.driver.findElements(By.id("edit")).get(rowIndex - 1);
    }
    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return this.driver.findElement(By.xpath("//tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]"));
    }
    public WebElement getDeleteButtonForRow(int rowIndex) {
        return this.driver.findElements(By.id("delete")).get(rowIndex - 1);
    }
    public void waitForDialogueToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("py-3")));
    }
    public WebElement getDeleteFromDialogue(){
        return  driver.findElement(By.xpath("//*[contains(@class, 'v-card__actions')]//button[2]"));
    }


}
