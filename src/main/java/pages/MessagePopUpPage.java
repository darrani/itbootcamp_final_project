package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public void waitForPopUpMessageToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public WebElement getTextFromDialogue() {
        return driver.findElement(By.xpath("//div[@class='v-snack__content']/ul/li"));
    }

    public WebElement getCloseButtonFromDialog(){
        return driver.findElement(By.xpath("//*[contains(@class,'btnClose')]"));
    }

    public void waitUntilVerifyYourAccountDialogIsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[]contains(@class, 'v-dialog--active)]")));
    }
    public WebElement getVerifyYourAccountHeader(){
        return driver.findElement(By.className("v-card__title"));
    }
    public WebElement getVerifyYourAccountCloseButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'v-card_actions')]/button"));
    }

    public void waitForSuccessDialog(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getSuccessMessage(){
        return driver.findElement(By.xpath("//*[contains(@class,'success')]/div"));
    }
}


